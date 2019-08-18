package summer.holiday.queue;

import java.util.ArrayList;
import java.util.List;

public class MyQueue {
	// 只有队头指针的队列 基于List实现
	/*
	 * enQueue(int x)入队 deQueue()出队 isEmpty()判断非空 Font()取出对头元素
	 * 
	 * 
	 */
	class Queue {
		// 队列
		private List<Integer> data;
		private int p_start;

		public Queue() {
			data = new ArrayList<Integer>();
			p_start = 0;
		}

		// 入队
		public boolean enQueue(int x) {
			data.add(x);
			return true;
		}

		// 出队
		public boolean deQueue() {
			if (isEmpty() == true) {
				return false;
			}
			p_start++;
			return true;
		}

		// 取出队头元素,好像要和出队联合使用
		public int Front() {
			return data.get(p_start);
		}

		// 判断
		public boolean isEmpty() {
			return p_start >= data.size();
		}
	}

	// 循环队列
	/*
	 * 基于数组实现的循环队列 enQueue(int x)入队
	 * 
	 * 
	 */
	class CircularQueue {
		// 队列
		private Integer[] datas;
		// 队头
		private Integer head;
		// 队尾
		private Integer tail;
		// 判断队空或队满的变量,将队头和队尾解耦
		private Integer size;

		public CircularQueue(int length) {

			datas = new Integer[length];
			head = 0;
			tail = 0;
			size = 0;
		}

		public int push(int data) {
			if (size == datas.length)
				throw new ArrayIndexOutOfBoundsException("队满");
			datas[tail] = data;
			size++;
			tail = nextIndex(datas.length, tail);
			return 0;
		}

		// 判断是否队满
		public int pop() {
			if (size == 0)
				throw new ArrayIndexOutOfBoundsException("队空");
			size--;
			int temp = datas[head];
			head = nextIndex(datas.length, head);
			return temp;

		}

		public int nextIndex(int length, int index) {
			return index == length - 1 ? 0 : index + 1;
		}

	}
}
