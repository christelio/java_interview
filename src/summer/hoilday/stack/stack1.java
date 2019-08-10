package summer.hoilday.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class stack1 {
	/*
	 * 基于数组的栈
	 * 
	 * 入栈push(int x)
	 **出栈pop();
	 *获取栈顶元素top()
	 *判断是否为空isEmpty();
	 *
	 */
	class stack {
		private List<Integer> data; // store elements

		public stack() {
			data = new ArrayList<>();
		}

		/** Insert an element into the stack. */
		public void push(int x) {
			data.add(x);
		}

		/** Checks whether the queue is empty or not. */
		public boolean isEmpty() {
			return data.isEmpty();
		}

		/** Get the top item from the queue. */
		public int top() {
			return data.get(data.size() - 1);
		}

		/**
		 * Delete an element from the queue. Return true if the operation is successful.
		 */
		public boolean pop() {
			if (isEmpty()) {
				return false;
			}
			data.remove(data.size() - 1);
			return true;
		}

	}
	
	class MinStack {
		// 库栈
		private Stack<Integer> stack;
		// 最小值
		private int min = Integer.MAX_VALUE;
		private Map<Integer, Integer> count = new HashMap<Integer, Integer>();
		//初始化
		public MinStack() {
			stack = new Stack<Integer>();
		}
		//进栈
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
		//出栈
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
		//返回最小数
		public int getMin()
		{
			return min;
		}
	}
}
