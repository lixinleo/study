<?php

$str = "abcde";

//create a range. It will create a array from start to end (included). Python does not include end
$range = range(0, strlen($str) -1);

//should print out a b c d e
foreach ($range as $i) {
	echo $str[$i], " ";
}

echo "\n";

