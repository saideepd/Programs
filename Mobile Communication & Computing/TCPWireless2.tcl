set val(chan)	Channel/WirelessChannel
set val(prop)	Propagation/TwoRayGround
set val(netif)	Phy/WirelessPhy
set val(mac)	Mac/802_11
set val(ll)		LL
set val(ant)	Antenna/OmniAntenna
set val(ifq)	Queue/DropTail/PriQueue
set val(ifqlen)	50
set val(rp)		DSDV
set val(nn)		6
set val(x)		500
set val(y)		500

set ns_ [new Simulator]
set tarcefd [open simple4.tr w]
$ns_ trace-all $tarcefd
set namtrace [open wireless4-Out.nam w]
$ns_ namtrace-all-wireless $namtrace $val(x) $val(y)



set topo [new Topography]
$topo load_flatgrid 500 500

create-god $val(nn)

#set chan_(0)_ [new $val(chan)]
#set chan_(1)_ [new $val(chan)]

$ns_ node-config -adhocRouting $val(rp) \
			-llType $val(ll) \
			-ifqType $val(ifq) \
			-macType $val(mac) 	\
			-ifqLen	 $val(ifqlen) \
			-antType $val(ant) \
			-propType $val(prop) \
			-phyType $val(netif) \
			-channelType $val(chan) \
			-topoInstance $topo \
			-agentTrace ON \
			-routerTrace ON \
			-macTrace OFF \
			-movementTrace OFF 


for {set i 0} {$i < $val(nn)} {incr i} {
	set node_($i) [$ns_ node]
	$node_($i) random-motion 0
}




$node_(0) set X_ 300.0
$node_(0) set Y_ 300.0
$node_(0) set Z_ 0.0

$node_(1) set X_ 250.0
$node_(1) set Y_ 200.0
$node_(1) set Z_ 0.0

$node_(2) set X_ 350.0
$node_(2) set Y_ 300.0
$node_(2) set Z_ 0.0

$node_(3) set X_ 200.0
$node_(3) set Y_ 200.0
$node_(3) set Z_ 0.0

$node_(4) set X_ 100.0
$node_(4) set Y_ 50.0
$node_(4) set Z_ 0.0

$node_(5) set X_ 100.0
$node_(5) set Y_ 80.0
$node_(5) set Z_ 0.0


$ns_ at 5.0 "$node_(0) setdest 350.0 250.0 15.0"
$ns_ at 5.0 "$node_(1) setdest 300.0 250.0 15.0"
$ns_ at 5.0 "$node_(2) setdest 200.0 150.0 15.0"
$ns_ at 5.0 "$node_(3) setdest 250.0 30n0.0 15.0"
$ns_ at 5.0 "$node_(4) setdest 120.0 50.0 15.0"
$ns_ at 5.0 "$node_(5) setdest 130.0 50.0 15.0"

for {set i 0} {$i < 4} {incr i} {
	set tcp_($i) [new Agent/TCP]
	$tcp_($i) set class_ 2
	$ns_ attach-agent $node_($i) $tcp_($i)

}
for {set i 0} {$i < 4} {incr i} {
	set sink_($i) [new Agent/TCPSink]
	$ns_ attach-agent $node_($i) $sink_($i)
}

for {set i 0} {$i < 4} {incr i} {
	set ftp_($i) [new Application/FTP]
	$ftp_($i) attach-agent $tcp_($i)
	
}

$ns_ connect $tcp_(0) $sink_(1)
$ns_ connect $tcp_(1) $sink_(2)
$ns_ connect $tcp_(2) $sink_(3)
$ns_ connect $tcp_(3) $sink_(0)

$ns_ at 5.0 "$ftp_(0) start" 
$ns_ at 5.0 "$ftp_(1) start" 
$ns_ at 5.0 "$ftp_(2) start" 
$ns_ at 5.0 "$ftp_(3) start"

$ns_ at 18.0 "$ftp_(0) stop" 
$ns_ at 18.0 "$ftp_(1) stop" 
$ns_ at 18.0 "$ftp_(2) stop" 
$ns_ at 18.0 "$ftp_(3) stop"

for {set i 0} {$i < $val(nn)} {incr i} {
	$ns_ at 20.0 "$node_($i) reset";
}

$ns_ at 20.0 "stop"
proc stop {} {
	global ns_ tarcefd namtrace
	$ns_ flush-trace
	close $tarcefd
	close $namtrace
	exec nam wireless4-Out.nam &
	exit 0
}
puts "Starting Simulation..."
$ns_ run