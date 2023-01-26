class Solution:
    def smallerNumbersThanCurrent(self, nums: List[int]) -> List[int]:
        result = [];
        for x in nums:
            count = 0;
            for y in nums:
                if (x>y):
                    count=count+1
            result.append(count)
        
        return result
