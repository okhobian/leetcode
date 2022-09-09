class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        left = 0
        max_len = 0
        seen = dict()   # map {"char have seen": last_seen_index}
        
        for right, char in enumerate(s):
            if char in seen and left <= seen[char]:
                left = seen[char] + 1
            else:
                max_len = max(right-left+1, max_len)
            seen[char] = right
        
        return max_len