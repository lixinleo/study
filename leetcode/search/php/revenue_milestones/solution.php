<?php

// Add any helper functions you may need here
  function findDay($totalR, $m) {
  //use binary search to find the day reach the milestone
  $low = 0;
  $high = count($totalR)-1;

  while ($low <= $high) {
    $mid = (int)(($low + $high)/2);

    if ($totalR[$mid]==$m) {
      return $mid+1;
    } else {
      if ($totalR[$mid] > $m) {
        $high = $mid -1;
      } else {
        $low = $mid +1;
      }
    }

  }

  if ($totalR[$mid] >= $m) {
    return $mid +1;
  }

  //check high
  if ($totalR[$high] >=$m) {
    return $high +1;
  }

  return -1;

}


function getMilestoneDays($revenues, $milestones){
    // Write your code here
  //total revenues at that days
  $totalR = [];

  //populate total revenue
  for ($i=0; $i<count($revenues); $i++) {
    if ($i==0) {
      $totalR[0] = $revenues[0];
    } else {
      //add previous day's revenuew
      $totalR[$i] = $revenues[$i] + $totalR[$i-1];
    }
  }

  $ans = [];

  foreach($milestones as $m) {
    $ans[] = findDay($totalR, $m);
  }

  return $ans;

}



//--- test---
$revenues = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100];
$milestones = [100, 200, 500, 100000000];


$result = getMilestoneDays($revenues, $milestones);
var_dump($result);




