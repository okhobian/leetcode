class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        
        size = len(s)
        if size < 2:
            return s
        
        dp = [[False for x in range(size)] for y in range(size)] 
        for i in range(size):
            dp[i][i] = True
            
            
        max_len = 1
        begin_idx = 0
        for j in range(1, size):
            for i in range(0, j):
                if s[i] != s[j]:
                    dp[i][j] = False
                elif j-i < 3:
                    dp[i][j] = True
                else:
                    dp[i][j] = dp[i+1][j-1]
                
                if dp[i][j] and j-i+1 > max_len:
                    max_len = j-i+1
                    begin_idx = i
                
        return s[begin_idx: begin_idx+max_len]