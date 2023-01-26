<?php

class Solution
{
    private $maxLenFound = 0;

    private $found = "";

    /**
     * @param String $s
     * @return String
     */
    function longestPalindrome($s)
    {

        if ($this->isP($s)) {
            return $s;
        }

        for ($i = 0; $i < strlen($s); $i++) {
            $sub = substr($s, $i);

            if (strlen($sub) <= $this->getMaxLen()) {
                break;
            }


            if ($this->isP($sub)) {
                $this->setMaxLen(strlen($sub));
                $this->setFound($sub);

            } else {


                $count = 1;

                while (1) {
                    if ($count >= strlen($sub)) {
                        break;
                    }

                    $newS = substr($sub, 0, strlen($sub) - $count);

                    if (strlen($newS) <= $this->getMaxLen()) {
                        break;
                    }

                    if ($this->isP($newS)) {
                        $this->setMaxLen(strlen($newS));
                        $this->setFound($newS);
                        break;
                    }

                    $count++;
                }
            }
        }

        return $this->found;


    }

    public function setMaxLen($len)
    {
        if ($len > $this->maxLenFound) {
            $this->maxLenFound = $len;
        }
    }

    public function getMaxLen()
    {
        return $this->maxLenFound;
    }

    public function setFound($str)
    {
        if (strlen($str) > strlen($this->found)) {
            $this->found = $str;
        }

    }


    function isP($s)
    {
        $len = strlen($s);
        if ($len == 1) {
            return true;
        }


        $max = (int)$len / 2;
        for ($i = 0; $i < $max; $i++) {
            if ($s[$i] != $s[$len - $i - 1]) {
                return false;
            }
        }

        return true;

    }


}


$str = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";



$solution = new Solution();
echo $solution->longestPalindrome($str), "\n";
