package summer.hoilday.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class stack1 {
	
	
	
	class MinStack {
		// ¿âÕ»
		private Stack<Integer> stack;
		// ×îĞ¡Öµ
		private int min = Integer.MAX_VALUE;
		private Map<Integer, Integer> count = new HashMap<Integer, Integer>();

		public MinStack() {
			stack = new Stack<Integer>();
		}

		public void push(int x) {
			if (x <= min) {
				min = x;
				if (count.containsKey(x)) {
					count.put(x, count.get(x) + 1);
				} else {
					count.put(x, 1);
				}
			}
			stack.push(x);
		}
		public void pop()
		{
			Integer pop=stack.pop();
			if(min==pop)
			{
				if(count.get(pop)==1)
				{
					count.remove(pop);
					min=Integer.MAX_VALUE;
					for(Integer number:count.keySet())
					{
						if(min>number)
						{
							min=number;
						}
						else
						{
							continue;
						}
					}
				}
				else
				{
					count.put(min,count.get(min)-1);
				}
			}
		}
		public int top()
		{
			if(stack.size()==0)
			{
				return 0;
			}
			else
			{
				return stack.get(stack.size()-1);
			}
		}
		public int getMin()
		{
			return min;
		}
	}
	
	
	
	
}
