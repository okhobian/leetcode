## simple way
# class Solution:
#     def isPowerOfFour(self, n: int) -> bool:
#         while n and (n % 4 == 0):
#             n /= 4;

#         return n == 1;
    
    
## smart way

'''
three conditions:
1) n is positive
2) n is power of 2 (power of 4 must be power of 2)
    - power of two in binary: 1xxx
    - power of two minus one: x111
    - n & (n-1) == 0 means it's power of two
3) power of 4 minus 1 must be multiplier of 3
'''

class Solution:
    def isPowerOfFour(self, n: int) -> bool:
        return n and (n & (n-1) == 0) and (n-1)%3==0
    

obj = Solution()
print( obj.isPowerOfFour(15) )