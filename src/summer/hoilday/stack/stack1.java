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
	 * 入栈push(int x) 出栈pop(); 获取栈顶元素top() 判断是否为空isEmpty();
	 *
	 */
	class stack {
		private int[] datas;
		private int point ;

		public stack(int size) {
			datas = new int[size];
			point =0;
		}

		/** Insert an element into the stack. */
		public void push(int x) {
			if (point == datas.length)
				throw new ArrayIndexOutOfBoundsException("栈满");
			datas[point++] = x;
		}

		/** Checks whether the queue is empty or not. */
		public boolean isEmpty() {
			if (point == 0)
				return false;
			return true;
		}

		/** Get the top item from the queue. */
		public int peek() {
			if (isEmpty()) {
				throw new ArrayIndexOutOfBoundsException("栈空");
			}
			return datas[point - 1];
		}

		/**
		 * Delete an element from the queue. Return true if the operation is successful.
		 */
		public int pop() {

			if (isEmpty()) {
				throw new ArrayIndexOutOfBoundsException("栈空");
			}
			return datas[--point];

		}

	}

	class MinStack {
		// 库栈
		// 库栈
		private Stack<Integer> stack;
		// 最小值
		private Stack<Integer> stackMin;

		// 初始化
		public MinStack() {
			stack = new Stack<Integer>();
			stackMin = new Stack<Integer>();
		}

		// 进栈
		public void push(int newData) {

			stack.push(newData);
			if (stackMin.size() == 0)
				stackMin.push(newData);
			else if (stackMin.peek() < newData)
				stackMin.push(stackMin.peek());
			else
				stackMin.push(newData);
		}

		// 出栈
		public int pop() {
			if (stackMin.size() == 0)
				throw new RuntimeException("栈空");
			stack.pop();
			return stackMin.pop();
		}

		// 返回最小数
		public int getMin() {
			if (stackMin.size() == 0)
				throw new RuntimeException("栈空");
			return stackMin.peek();
		}
		//返回栈顶元素
		public int top() {
			if (stack.size() == 0)
				throw new RuntimeException("栈空");
			return stack.peek();
		}
	}
}
