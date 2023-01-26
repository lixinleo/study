<?php

class Solution {

    /**
     * @param Integer[] $prices
     * @return Integer
     */
    function maxProfit($prices) {

        $maxProfit = 0;

        //can not buy in the last day
        for($i=1; $i< count($prices); $i++) {
            $profit = $this->maxProfitForDay($i, $prices);

            if ($profit > $maxProfit) {
                $maxProfit = $profit;
            }
        }

        return ($maxProfit>=0) ? $maxProfit: 0;
        
    }

    function maxProfitForDay($buyDay, $prices)
    {
        //day one => index 0
        $buyPrice = $prices[$buyDay -1];

        //get the left array
        $leftPrices = array_slice($prices, $buyDay);

        //get max price in the left price array
        $max = max($leftPrices);

        return $max - $buyPrice;
    }
    
    
}

$solution = new Solution();

$prices =  [7,1,5,3,6,4];

$result = $solution->maxProfit($prices);
var_dump($result);
