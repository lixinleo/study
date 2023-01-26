<?php

class Solution
{

    public static $nums;

    /**
     * @param Integer[] $nums
     * @return Integer[]
     */
    function frequencySort($nums)
    {
        self::$nums = $nums;

        usort($nums, array("Solution", "cmp"));

        return $nums;

    }

    private static function cmp($a, $b)
    {

        if ($a == $b) {
            return 0;
        }

        $freA = self::getFrenquency($a);
        $freB = self::getFrenquency($b);

        if ($freA == $freB) {
            return ($a < $b) ? 1 : -1;
        } else {
            return ($freA < $freB) ? -1 : 1;
        }


    }

    public static function getFrenquency($val)
    {
        $count = 0;
        foreach (self::$nums as $num) {
            if ($val == $num) {
                $count++;
            }

        }

        return $count;
    }

}