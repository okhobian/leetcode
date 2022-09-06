## slow: by rotate 90 each time
class Solution(object):
    def findRotation(self, mat, target):
        """
        :type mat: List[List[int]]
        :type target: List[List[int]]
        :rtype: bool
        """
        
        if mat==target:
            return True

        num = 0
        while num < 3:
            mat = self.rotate(mat)
            if mat == target: return True
            num+=1

        return False

    def rotate(self, mat):

        # length
        n = len(mat)

        # transpose
        for i in range(n):
            for j in range(i,n):
                mat[i][j], mat[j][i] = mat[j][i], mat[i][j]

        # reverse by row
        for i in range(n):
            mat[i] = mat[i][::-1]

        return mat