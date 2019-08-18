package summer.hoilday.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class stack1 {
	/*
	 * ���������ջ
	 * 
	 * ��ջpush(int x) ��ջpop(); ��ȡջ��Ԫ��top() �ж��Ƿ�Ϊ��isEmpty();
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
				throw new ArrayIndexOutOfBoundsException("ջ��");
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
				throw new ArrayIndexOutOfBoundsException("ջ��");
			}
			return datas[point - 1];
		}

		/**
		 * Delete an element from the queue. Return true if the operation is successful.
		 */
		public int pop() {

			if (isEmpty()) {
				throw new ArrayIndexOutOfBoundsException("ջ��");
			}
			return datas[--point];

		}

	}

	class MinStack {
		// ��ջ
		// ��ջ
		private Stack<Integer> stack;
		// ��Сֵ
		private Stack<Integer> stackMin;

		// ��ʼ��
		public MinStack() {
			stack = new Stack<Integer>();
			stackMin = new Stack<Integer>();
		}

		// ��ջ
		public void push(int newData) {

			stack.push(newData);
			if (stackMin.size() == 0)
				stackMin.push(newData);
			else if (stackMin.peek() < newData)
				stackMin.push(stackMin.peek());
			else
				stackMin.push(newData);
		}

		// ��ջ
		public int pop() {
			if (stackMin.size() == 0)
				throw new RuntimeException("ջ��");
			stack.pop();
			return stackMin.pop();
		}

		// ������С��
		public int getMin() {
			if (stackMin.size() == 0)
				throw new RuntimeException("ջ��");
			return stackMin.peek();
		}
		//����ջ��Ԫ��
		public int top() {
			if (stack.size() == 0)
				throw new RuntimeException("ջ��");
			return stack.peek();
		}
	}
}
