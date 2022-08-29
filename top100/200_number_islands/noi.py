from collections import deque

# BFS
from collections import deque

class Solution(object):
    def numIslands(self, grid):
        """
        :type grid: List[List[str]]
        :rtype: int
        """
        
        if not grid or not grid[0]: return 0
        
        num = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == '1':
                    self.bfs(grid, i, j)
                    num+=1
                    
        return num
    
    def bfs(self, grid, x, y):
        q = deque([(x,y)])
        grid[x][y] = '0'
        while q:
            cur_x, cur_y = q.popleft()
            for dx, dy in [(1,0),(0,1),(-1,0),(0,-1)]:
                next_x = cur_x + dx
                next_y = cur_y + dy
                if self.isValid(grid, next_x, next_y):
                    q.append((next_x, next_y))
                    grid[next_x][next_y] = '0'
                
    def isValid(self, grid, x, y):
        m = len(grid)
        n = len(grid[0])
        return (0<=x<m) and (0<=y<n) and grid[x][y] == '1'