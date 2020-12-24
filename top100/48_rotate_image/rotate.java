class Solution 
{
    public void rotate(int[][] matrix) 
    {
        int top = 0;
        int down = matrix.length-1;
        
        // top - down flip
        while (top < down)
        {
            int[] temp = matrix[top]; 
            matrix[top] = matrix[down];
            matrix[down] = temp;
            top++;
            down--;
        }
        
        // dignosis flip
        for (int i=0; i<matrix.length; i++)
        {
            for (int j=i+1; j<matrix[i].length; j++)
            {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}

/**
 * rotate(90, clockwise)         -->  top-down(mid-horizontal) + diagnosis(leftTop-rightBottom)
 * 
 * 1 2 3        7 8 9        7 4 1    |    1 2 3        \ 8 9        7 4 1
 * 4 5 6   ->   4 5 6   ->   8 5 2    |    - - -   ->   4 \ 6   ->   8 5 2  
 * 7 8 9        1 2 3        9 6 3    |    7 8 9        1 2 \        9 6 3
 * 
 * rotate(90, counter-clockwise) -->  top-down(mid-horizontal) + diagnosis(rightTop-leftBottom)
 * rotate(180)                   -->  top-down(mid-horizontal) + left-right(mid-vertical)
 * 
 * https://www.youtube.com/watch?v=E4r9z6kMjPU
 */