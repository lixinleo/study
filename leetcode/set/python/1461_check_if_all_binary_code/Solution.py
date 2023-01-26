class Solution:
    def hasAllCodes(self, s: str, k: int) -> bool:
        myset = set()
        
        i=0
        while i<=len(s)-k:
            myset.add(s[i:i+k])
            i +=1
        
        return pow(2, k) == len(myset)
