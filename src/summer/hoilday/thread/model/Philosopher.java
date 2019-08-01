package summer.hoilday.thread.model;

public class Philosopher extends Thread{
	private String pname;
	private Chopsticks left;
	private Chopsticks right;
	private int time;

	public Philosopher(String pname, Chopsticks left, Chopsticks right,int i) {
		this.pname = pname;
		this.left = left;
		this.right = right;
		this.time=i;
	}

	public void run() {
		try {
			this.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized (left) {
			System.out.println(this.pname + "拿起了左筷子");
			synchronized (right) {
				System.out.println(this.pname + "拿起了右筷子");
			}
		}
	}
}
