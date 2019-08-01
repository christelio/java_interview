package summer.holiday.queue;

import java.util.ArrayList;
import java.util.List;

public class MyQueue {
	// ֻ�ж�ͷָ��Ķ���
	class Queue {
		// ����
		private List<Integer> data;
		private int p_start;

		public Queue() {
			data = new ArrayList<Integer>();
			p_start = 0;
		}

		// ���
		public boolean enQueue(int x) {
			data.add(x);
			return true;
		}

		// ����
		public boolean deQueue() {
			if (isEmpty() == true) {
				return false;
			}
			p_start++;
			return true;
		}

		// ȡ����ͷԪ��,����Ҫ�ͳ�������ʹ��
		public int Front() {
			return data.get(p_start);
		}

		// �ж�
		public boolean isEmpty() {
			return p_start >= data.size();
		}
	}

	class CircularQueue {
		// ����
		private int[] data;
		// ��ͷ
		private int head;
		// ��β
		private int tail;
		private int size;

		public CircularQueue(int k) {
			data = new int[k];
			head = -1;
			tail = -1;
			size = k;
		}

		// ���
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

		// ����
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

		// �鿴��ͷԪ��
		public int Front() {
			if (isEmpty() == true) {
				return -1;
			}
			return data[head];
		}

		// �жϷǿ�
		public boolean isEmpty() {
			return head == -1;
		}

		// �ж��Ƿ����
		public boolean isFull() {
			return ((tail + 1) % size) == head;
		}

	}
}
