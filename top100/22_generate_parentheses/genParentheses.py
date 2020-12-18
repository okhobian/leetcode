class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        res = []
        self.helper(res, n, n, "")
        return res
    
    def helper(self, res, left, right, curr):
        if left == 0 and right == 0:
            res.append(curr)
            return
        if left > 0:
            self.helper(res, left-1, right, curr+"(")
        if right > left:
            self.helper(res, left, right-1, curr+")")