package summer.holiday.queue;

import java.util.ArrayList;
import java.util.List;

public class MyQueue {
	// 只有队头指针的队列
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

	class CircularQueue {
		// 队列
		private int[] data;
		// 队头
		private int head;
		// 队尾
		private int tail;
		private int size;

		public CircularQueue(int k) {
			data = new int[k];
			head = -1;
			tail = -1;
			size = k;
		}

		// 入队
		public boolean enQueue(int value) {
			if (isFull() == true) {
				return false;
			}
			if (isEmpty() == true) {
				head = 0;
			}
			tail = (tail + 1) % size;
			data[tail] = value;
			return true;
		}

		// 出队
		public boolean deQueue() {
			if (isEmpty() == true) {
				return false;
			}
			if (head == tail) {
				head = -1;
				tail = -1;
				return true;
			}
			head = (head + 1) % size;
			return true;
		}

		// 查看对头元素
		public int Front() {
			if (isEmpty() == true) {
				return -1;
			}
			return data[head];
		}

		// 判断非空
		public boolean isEmpty() {
			return head == -1;
		}

		// 判断是否队满
		public boolean isFull() {
			return ((tail + 1) % size) == head;
		}

	}
}
