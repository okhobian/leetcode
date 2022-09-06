'''
clockwise 90: 1. transpose; 2. reverse each row
counter-clockwise 90: 1. reverse each row; 2. transpose
180: 1. reverse each row; 2. reverse each col

'''


## clockwise 90
class Solution(object):
    def rotate(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: None Do not return anything, modify matrix in-place instead.
        """
        
        # squre shape, row=col=n
        n = len(matrix)
        
        # transpose
        for i in range(n):
            for j in range(i, n):
                matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]            
        
        # revser each row
        for i in range(n):
            matrix[i] = matrix[i][::-1]
            
# counterclockwise 90
class Solution(object):
    def rotate(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: None Do not return anything, modify matrix in-place instead.
        """
        
        # squre shape, row=col=n
        n = len(matrix)
        
        # reverse each row
        for i in range(n):
            matrix[i] = matrix[i][::-1]
            
        # transpose
        for i in range(n):
            for j in range(i, n):
                matrix[i][j], matrix[j][i] = matrix[j][i], matrix[i][j]        
                
# 180
class Solution(object):
    def rotate(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: None Do not return anything, modify matrix in-place instead.
        """
        
        # squre shape, row=col=n
        n = len(matrix)
        
        # reverse each row
        for i in range(n):
            matrix[i] = matrix[i][::-1]
            
        # reverse col
        for j in range(n):
             top = 0
             bottom = n-1
             while top<bottom:
                 matrix[top][j], matrix[bottom][j] = matrix[bottom][j], matrix[top][j]
                 top+=1
                 bottom-=1 