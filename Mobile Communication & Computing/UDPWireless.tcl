#Define node varibales
set val(chan)	Channel/WirelessChannel
set val(prop)	Propagation/TwoRayGround
set val(ll)		LL	
set val(ant)	Antenna/OmniAntenna
set val(ifq)	Queue/DropTail/PriQueue ;# for DSDV and AOVD use Queue/DropTail/PriQueue for DSR use CMUPriQueue
set val(ifqlen)	50
set val(netif)	Phy/WirelessPhy
set val(mac)	Mac/802_11
set val(rp)		DSDV
set val(nn)		6
set val(x)		500
set val(y)		500

set ns [new Simulator]
set nf [open simple-wireless5.tr w]
$ns trace-all $nf
#for network animator
set namtrace [open wireless5-out.nam w]
$ns namtrace-all-wireless $namtrace $val(x) $val(y)


set topo [new Topography]
$topo load_flatgrid 500 500
#God (General Operations Director) is the object that is used to store global information about the state of the environment, 
#network or nodes that an omniscent observer would have, but that should not be made known to any participant in the simulation
create-god $val(nn)
#config node with the define node variables
#macTrace and movmentTrace stays off 
$ns node-config -adhocRouting $val(rp) \
				-channelType $val(chan) \
				-llType	$val(ll) \
				-propType $val(prop) \
				-antType $val(ant) \
				-ifqType $val(ifq) \
				-ifqLen  $val(ifqlen) \
				-phyType $val(netif) \
				-macType $val(mac) \
				-topoInstance $topo \
				-agentTrace ON \
				-routerTrace ON \
				-macTrace OFF \
				-movmentTrace OFF

for {set i 0} {$i < $val(nn)} {incr i} {
 	set node($i) [$ns node]
 	$node($i) random-motion 0
 } 
#set position for each node
$node(0) set X_ 300
$node(0) set Y_ 250
$node(0) set Z_ 0

$node(1) set X_ 200
$node(1) set Y_ 150
$node(1) set Z_ 0

$node(2) set X_ 100
$node(2) set Y_ 50
$node(2) set Z_ 0

$node(3) set X_ 260
$node(3) set Y_ 230
$node(3) set Z_ 0

$node(4) set X_ 100
$node(4) set Y_ 100
$node(4) set Z_ 0

$node(5) set X_ 200
$node(5) set Y_ 200
$node(5) set Z_ 0

#setdest is the destination to which node will travel
#eg: node(0) setdest x-coordinate y-coordinate speed 
$ns at 0.5 "$node(0) setdest 250 300 15.0"
$ns at 0.5 "$node(1) setdest 150 200 15.0"
$ns at 0.5 "$node(2) setdest 50 100 15.0"
$ns at 0.5 "$node(3) setdest 230 260 15.0"
$ns at 0.5 "$node(4) setdest 200 200 15.0"
$ns at 0.5 "$node(5) setdest 100 100 15.0"


for {set i 0} {$i < 4} {incr i} {
	set udp($i) [new Agent/UDP]
	$ns attach-agent $node($i) $udp($i) 
}

for {set i 0} {$i < 4} {incr i} {
	set cbr($i) [new Application/Traffic/CBR]
	$cbr($i) set packetSize_ 500
	$cbr($i) set interval_ 0.005
	$cbr($i) attach-agent $udp($i)
}


for {set i 0} {$i < 4} {incr i} {
	set null($i) [new Agent/Null]
	$ns attach-agent $node($i) $null($i) 
}

$ns connect $udp(0) $null(1)
$ns connect $udp(1) $null(2)
$ns connect $udp(2) $null(3)
$ns connect $udp(3) $null(0)

$ns at 1.0 "$cbr(0) start"
$ns at 1.0 "$cbr(1) start"
$ns at 1.0 "$cbr(2) start"
$ns at 1.0 "$cbr(3) start"

$ns at 18.0 "$cbr(0) stop"
$ns at 18.0 "$cbr(1) stop"
$ns at 18.0 "$cbr(2) stop"
$ns at 18.0 "$cbr(3) stop"
for {set i 0} {$i < $val(nn)} {incr i} {
	$ns at 20.0 "$node($i) reset"
}

$ns at 20.0 "stop"
proc stop {} {
	global ns nf namtrace
	$ns flush-trace
	close $nf
	close $namtrace
	exec nam wireless5-out.nam &
	exit 0
}
$ns run
