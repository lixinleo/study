<?php

class Solution {

    /**
     * @param Integer $n
     * @return Integer
     */
    function countPrimes($n) {
        
        if ($n == 0) {
            return 0;
        }

        if ($n == 1) {
            return 0;
        }

        $count = 0;

        for ($i = 2; $i < $n; $i++) {
            if ($this->isPrime($i)) {
                $count++;
            }
        }

        return $count;
        
        
    }
    
    function isPrime($num)
    {
        if ($num == 1 || $num ==0) {
            return false;
        }
        
        if ($num ==2) {
            return true;
        }
        
       	//only need to count to square root!!! This is a moth theory for it! 
        $ceiling = (int)sqrt($num)+1;
        
        for ($i = 2; $i <= $ceiling; $i++) {
            if ($num % $i == 0) {
                return false;
            }
        }

        return true;

    }
}
