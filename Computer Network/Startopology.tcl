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
set hub [$ns node]




$ns duplex-link $hub $n0 1Mb 10ms DropTail	
$ns duplex-link $hub $n1 1Mb 10ms DropTail
$ns duplex-link $hub $n2 1Mb 10ms DropTail
$ns duplex-link $hub $n3 1Mb 10ms DropTail



set udp0 [new Agent/UDP]
set udp1 [new Agent/UDP]


$ns attach-agent $n0 $udp0
$ns attach-agent $n1 $udp1



set cbr0 [new Application/Traffic/CBR]
$cbr0 set packetSize_ 	500
$cbr0 set interval_ 0.005
$cbr0 attach-agent $udp0


set cbr1 [new Application/Traffic/CBR]
$cbr1 set packetSize_ 	500
$cbr1 set interval_ 0.005
$cbr1 attach-agent $udp1



set null2 [new Agent/Null]
$ns attach-agent $n2 $null2
set null3 [new Agent/Null]
$ns attach-agent $n3 $null3


$ns connect $udp0 $null2
$ns connect $udp1 $null3


$ns at 0.5 "$cbr0 start" 
$ns at 1.0 "$cbr1 start"
$ns at 4.0 "$cbr1 stop"
$ns at 4.5 "$cbr0 stop"

$ns at 5.0 "finish"
$ns run