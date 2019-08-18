package summer.holiday.queue;

import java.util.ArrayList;
import java.util.List;

public class MyQueue {
	// ֻ�ж�ͷָ��Ķ��� ����Listʵ��
	/*
	 * enQueue(int x)��� deQueue()���� isEmpty()�жϷǿ� Font()ȡ����ͷԪ��
	 * 
	 * 
	 */
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

	// ѭ������
	/*
	 * ��������ʵ�ֵ�ѭ������ enQueue(int x)���
	 * 
	 * 
	 */
	class CircularQueue {
		// ����
		private Integer[] datas;
		// ��ͷ
		private Integer head;
		// ��β
		private Integer tail;
		// �ж϶ӿջ�����ı���,����ͷ�Ͷ�β����
		private Integer size;

		public CircularQueue(int length) {

			datas = new Integer[length];
			head = 0;
			tail = 0;
			size = 0;
		}

		public int push(int data) {
			if (size == datas.length)
				throw new ArrayIndexOutOfBoundsException("����");
			datas[tail] = data;
			size++;
			tail = nextIndex(datas.length, tail);
			return 0;
		}

		// �ж��Ƿ����
		public int pop() {
			if (size == 0)
				throw new ArrayIndexOutOfBoundsException("�ӿ�");
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
