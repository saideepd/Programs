set ns [new Simulator]
set nf [open nam2.out w]
$ns namtrace-all $nf

proc finish {} {
	global ns nf
	$ns flush-trace
	close $nf
	exec nam nam2.out &
	exit 0
}

set n0 [$ns node]
set n1 [$ns node]
set n11 [$ns node]

set n2 [$ns node]
set n21 [$ns node]

set n3	[$ns node]

$ns duplex-link $n0 $n1 1Mb 10ms DropTail

$ns duplex-link $n1 $n11 1Mb 10ms DropTail

$ns duplex-link $n1 $n2 1Mb 10ms DropTail

$ns duplex-link $n2 $n21 1Mb 10ms DropTail

$ns duplex-link $n2 $n3 1Mb 10ms DropTail

set udp0 [new Agent/UDP]
$ns attach-agent $n0 $udp0

set udp1 [new Agent/UDP]
$ns attach-agent $n1 $udp1
set udp11 [new Agent/UDP]
$ns attach-agent $n11 $udp11


set udp2 [new Agent/UDP]
$ns attach-agent $n2 $udp2
set udp21 [new Agent/UDP]
$ns attach-agent $n21 $udp21


set udp3 [new Agent/UDP]
$ns attach-agent $n3 $udp3


#cbr agent to generate traffic
set cbr0 [new Application/Traffic/CBR]
$cbr0 set packetSize_ 500
$cbr0 set interval_ 0.005
$cbr0 attach-agent $udp0

set cbr1 [new Application/Traffic/CBR]
$cbr1 set packetSize_ 500
$cbr1 set interval_ 0.005
$cbr1 attach-agent $udp1

set cbr2 [new Application/Traffic/CBR]
$cbr2 set packetSize_ 500
$cbr2 set interval_ 0.005
$cbr2 attach-agent $udp2


#connecting the nodes and the udp agent
set null11 [new Agent/Null]
$ns attach-agent $n11 $null11

set null21 [new Agent/Null]
$ns attach-agent $n21 $null21


set null3 [new Agent/Null]
$ns attach-agent $n3 $null3

#connecting the sink and the udp agent
$ns connect $udp0 $null3
$ns connect $udp1 $null11
$ns connect $udp2 $null21



$ns at 0.0 "$n3 label n3"
$ns at 0.5 "$cbr0 start"
$ns at 0.5 "$cbr1 start"
$ns at 0.5 "$cbr2 start"
$ns at 4.5 "$cbr0 stop"
$ns at 4.5 "$cbr1 stop"
$ns at 4.5 "$cbr2 stop"


$ns at 5.0 "finish"
$ns run