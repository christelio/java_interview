package summer.holiday.queue;

import java.util.LinkedList;
import java.util.Queue;

//两个队列实现一个栈
public class exQueue {

	private Queue<Integer> datas;
	private Queue<Integer> help;

	public exQueue() {
		this.datas = new LinkedList<Integer>();
		this.help = new LinkedList<Integer>();

	}

	public void push(int data) {
		datas.add(data);
	}

	public int poll() {
		if (datas.size() == 0)
			return 0;
		while (datas.size() != 1)
			help.add(datas.poll());
		int res = datas.poll();
		swap();
		return res;
	}

	public int peek() {
		if (datas.size() == 0)
			return 0;
		while (datas.size() != 1)
			help.add(datas.poll());
		int res = datas.poll();
		help.add(res);
		swap();
		return res;
	}

	public void swap() {
		Queue<Integer> temp;
		temp = datas;
		datas = help;
		help = temp;
	}

}
