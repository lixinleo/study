class Solution {

    /**
     * @param String $num
     * @param Integer[] $change
     * @return String
     */
    function maximumNumber($num, $change) {
        //find start
        $start = -1;
        
        for($i=0; $i<strlen($num); $i++) {
            if ($change[$num[$i]]  > $num[$i]) {
                $start = $i;
                break;
            }
        }
        
   
        if (-1 == $start) {
            return $num;
        }
        
        //find end
        $end = -1;
        
         for($i=$start+1; $i<strlen($num); $i++) {
            if ($change[$num[$i]]  < $num[$i]) {
                $end = $i-1;
                break;
            }
        }
        
        if ($end == -1) {
            $end = strlen($num) -1;
        }
        
     
        
        //build mid
        $mid = "";
        
        for ($i=$start; $i<=$end; $i++) {
            $mid =  $mid . $change[$num[$i]];
        }
        
        return substr($num, 0, $start) . $mid . substr($num, $end+1);
        
        
        
    }
}
