set ns [new Simulator]

# open trace file as write mode
set nf [open nam2.out w]
$ns namtrace-all $nf

proc finish {} {
	global ns nf
	$ns flush-trace
	close $nf
	exec nam nam2.out &
	exit 0
}

for {set i 0} {$i < 8} {incr i} {
	set n($i) [$ns node]
}

for {set i 0} {$i < 8} {incr i} {
	$ns duplex-link $n($i) $n([expr ($i+1)%8]) 1Mb 10ms DropTail
}


for {set i 0} {$i < 8} {incr i} {
	set udp($i) [new Agent/UDP]
	$ns attach-agent $n($i) $udp($i)
}

for {set i 0} {$i < 8} {incr i} {
	set cbr($i) [new Application/Traffic/CBR]
 	$cbr($i) set packetSize_ 500
 	$cbr($i) set interval_ 0.005
 	$cbr($i) attach-agent $udp($i)
}

for {set i 0} {$i < 8} {incr i} {
	set null($i) [new Agent/Null]
	$ns attach-agent $n($i) $null($i)
}

$ns connect $udp(0) $null(1)
$ns connect $udp(1) $null(2)
$ns connect $udp(2) $null(3)
$ns connect $udp(3) $null(4)
$ns connect $udp(4) $null(5)
$ns connect $udp(5) $null(6)
$ns connect $udp(6) $null(7)
$ns connect $udp(7) $null(0)


$ns at 0.1 "$cbr(0) start"
$ns at 0.1 "$cbr(1) start"
$ns at 0.1 "$cbr(2) start"
$ns at 0.1 "$cbr(3) start"
$ns at 0.1 "$cbr(4) start"
$ns at 0.1 "$cbr(5) start"
$ns at 0.1 "$cbr(6) start"
$ns at 0.1 "$cbr(7) start"

$ns at 4 "$cbr(0) stop"
$ns at 4 "$cbr(1) stop"
$ns at 4 "$cbr(2) stop"
$ns at 4 "$cbr(3) stop"
$ns at 4 "$cbr(4) stop"
$ns at 4 "$cbr(5) stop"
$ns at 4 "$cbr(6) stop"
$ns at 4 "$cbr(7) stop"

$ns at 5.0 "finish"
$ns run
