<?php

// Add any extra import statements you may need here


// Add any helper functions you may need here
  
  function reachB($days, $g) {
  $sum = 0;
  $count = 0;
  
  //hold the current users for all apps
  $cur = [];
  
  //initate day one
  foreach ($g as $r) {
    $cur[] = $r;
  }
  
  while ($count < $days) {
    $count++;
    
    //every day, multiply growth
    if ($count>1) {
      for ($i=0; $i< count($g); $i++) {
        $cur[$i] = $cur[$i] * $g[$i];
     }
    }
    
    
    //sum up and see if reach 1 billion
    $sum = 0;
    
    foreach ($cur as $val) {
      $sum = $sum + $val;
    }
    if ($sum > 1000000000) {
      return true;
    }
  }
  
  return false;
  
}


 


 
function getBillionUsersDay($growthRates) {
   // Write your code here
  $low =1;
  $high = 1000000000;
  
  
  
  while ($low <= $high) {
    $mid = (int)(($low + $high)/2);
    
    if (reachB($mid, $growthRates)) {
      $high = $mid-1;
    } else {
      $low = $mid+1;
    }
  }
  
  //check mid
  if (reachB($mid, $growthRates)) {
    return $mid;
  } else {
    return $mid +1;
  }
  
 
  
}

//test
$result = getBillionUsersDay([1.1, 1.2, 1.3]);
echo $result, "\n";
