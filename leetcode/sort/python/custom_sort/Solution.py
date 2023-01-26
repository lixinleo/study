class Solution:
    def numberOfWeakCharacters(self, properties: List[List[int]]) -> int:
        properties.sort(key=lambda p: (p[0], -p[1]))
        
        
        i = len(properties)-2
        maxD = properties[i+1][1]
        ans = 0
        
        while i>=0:
            if properties[i][1] < maxD:
                ans +=1
            
            maxD = max(maxD, properties[i][1])
            i = i-1;
        
        return ans
