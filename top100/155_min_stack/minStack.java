class MinStack 
{
    Stack<Integer> stack;
    int min;
    
    /** initialize your data structure here. */
    public MinStack() 
    {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) 
    {
        if (x <= min)           // if new value is new min
        {
            stack.push(min);    // push current min first
            min = x;            // update min
        }
        stack.push(x);          // push new value
    }
    
    public void pop() 
    {
        if (stack.pop() == min) // if current pop is min
            min = stack.pop();  // pop again to get previous min
    }
    
    public int top() 
    {
        return stack.peek();    
    }
    
    public int getMin() 
    {
        return min;    
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */