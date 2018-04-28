set ns [new Simulator]
set nf [open nam.out w]
$ns namtrace-all $nf

proc finish {} {
	global ns nf
	$ns flush-trace
	close $nf
	exec nam nam.out &
	exit 0
}

set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]
set n3 [$ns node]

$ns duplex-link $n0 $n1 1Mb 10ms DropTail
$ns duplex-link $n0 $n2 1Mb 10ms DropTail


$ns duplex-link $n1 $n2 1Mb 10ms DropTail
$ns duplex-link $n1 $n3 1Mb 10ms DropTail

$ns duplex-link $n2 $n3 1Mb 10ms DropTail

$ns duplex-link $n3 $n0 1Mb 10ms DropTail


set udp0 [new Agent/UDP]
$ns attach-agent $n0 $udp0
set udp02 [new Agent/UDP]
$ns attach-agent $n0 $udp02

set udp1 [new Agent/UDP]
$ns attach-agent $n1 $udp1
set udp13 [new Agent/UDP]
$ns attach-agent $n1 $udp13

set udp2 [new Agent/UDP]
$ns attach-agent $n2 $udp2

set udp3 [new Agent/UDP]
$ns attach-agent $n3 $udp3

set cbr0 [new Application/Traffic/CBR]
$cbr0 set packetSize_ 500
$cbr0 set interval_ 0.005
$cbr0 attach-agent $udp0

set cbr02 [new Application/Traffic/CBR]
$cbr02 set packetSize_ 500
$cbr02 set interval_ 0.005
$cbr02 attach-agent $udp02

set cbr1 [new Application/Traffic/CBR]
$cbr1 set packetSize_ 500
$cbr1 set interval_ 0.005
$cbr1 attach-agent $udp1

set cbr13 [new Application/Traffic/CBR]
$cbr13 set packetSize_ 500
$cbr13 set interval_ 0.005
$cbr13 attach-agent $udp13

set cbr2 [new Application/Traffic/CBR]
$cbr2 set packetSize_ 500
$cbr2 set interval_ 0.005
$cbr2 attach-agent $udp2

set cbr3 [new Application/Traffic/CBR]
$cbr3 set packetSize_ 500
$cbr3 set interval_ 0.005
$cbr3 attach-agent $udp3

set null0 [new Agent/Null]
$ns attach-agent $n0 $null0
set null02 [new Agent/Null]
$ns attach-agent $n2 $null02

set null1 [new Agent/Null]
$ns attach-agent $n1 $null1
set null13 [new Agent/Null]
$ns attach-agent $n3 $null13

set null2 [new Agent/Null]
$ns attach-agent $n2 $null2

set null3 [new Agent/Null]
$ns attach-agent $n3 $null3

$ns connect $udp0 $null1
$ns connect $udp02 $null02
$ns connect $udp1 $null2
$ns connect $udp13 $null13
$ns connect $udp2 $null3
$ns connect $udp3 $null0

$ns at 0.5 "$cbr0 start"
$ns at 0.5 "$cbr02 start"
$ns at 0.5 "$cbr1 start"
$ns at 0.5 "$cbr13 start"
$ns at 0.5 "$cbr2 start"
$ns at 0.5 "$cbr3 start"

$ns at 4.5 "$cbr0 stop"
$ns at 4.5 "$cbr02 stop"
$ns at 4.5 "$cbr1 stop"
$ns at 4.5 "$cbr13 stop"
$ns at 4.5 "$cbr2 stop"
$ns at 4.5 "$cbr3 stop"


$ns at 5.0 "finish"
$ns run



