package summer.hoilday.thread.model;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;

public class Warehouse {

	private ArrayList<String> list = new ArrayList<>();
	private static Warehouse wh = new Warehouse();

	private Warehouse() {

	};

	public static Warehouse getWarehouse() {
		return wh;
	}

	public  synchronized void add() {
		if (list.size() < 21) {
			list.add("a");
			System.out.println("数量:"+list.size());
		} else {
			try {
				this.notifyAll();
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public synchronized void get() {
		if (list.size() > 0) {
			list.remove(0);
			System.out.println("剩余数量:"+list.size());
		}
		else {
		try {
			this.notifyAll();
			this.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
}
