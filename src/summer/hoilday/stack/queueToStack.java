package summer.hoilday.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * 
 * Õ»×ª¶ÓÁÐ
 * */
public class queueToStack {

	private Stack<Integer> push;
	private Stack<Integer> poll;

	public queueToStack() {
		this.push = new Stack<>();
		this.poll = new Stack<>();
	}

	public void push(int data) {
		push.add(data);
		outPutAll();

	}

	public int pop() {
		if (poll.isEmpty())
			return 0;
		outPutAll();
		return poll.pop();
	}

	public int peek() {
		if (poll.isEmpty())
			return 0;
		outPutAll();
		return poll.peek();
	}

	public void outPutAll() {
		while (poll.isEmpty())
			while (!push.isEmpty()) {
				poll.push(push.pop());
			}
	}

}
