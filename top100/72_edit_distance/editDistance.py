class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        m = len(word1)  # length of word1
        n = len(word2)  # length of word2
        
        if m==0:        # word1 is empty
            return n    # insert n times
        if n==0:        # word2 is empty
            return m    # delete m times
        
        # history matrix of size (m+1)*(n+1), empty at row, col = 0
        dp = [[0 for i in range(n+1)] for j in range(m+1)]
        
        for i in range(m+1):        # rows
            for j in range(n+1):    # cols
                if i==0:            # first column
                    dp[i][j] = j    # [0][j] = j
                elif j==0:          # first row
                    dp[i][j] = i    # [i][0] = i
                elif word1[i-1]==word2[j-1]:    # same last char of substring
                    dp[i][j] = dp[i-1][j-1]     # no change
                else:                           # diff last char of substring
                    dp[i][j] = min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1]) + 1
                                                # [i][j-1]: deletion
                                                # [i-1][j]: insertion
                                                # [i-1][i-1]: replacement
                                                # +1: current operation
        return dp[m][n] # full problme