package summer.hoilday.thread.model;

public class TestMain {
	public static void main(String[] args)
	{
	Producer pro=new Producer();
	Consumer con=new Consumer();
	Thread pro1=new Thread(pro);
	Thread con1=new Thread(con);
	Thread con2=new Thread(con);
	/*pro1.setPriority(10);
	con1.setPriority(7);*/
	con1.setPriority(10);
	pro1.start();
	con1.start();
	con2.start();
	}
}
