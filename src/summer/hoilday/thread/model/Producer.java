package summer.hoilday.thread.model;

public class Producer implements Runnable{
	private Warehouse wh=Warehouse.getWarehouse();
	public void run()
	{
		while(true)
		{
			wh.add();
			System.out.println("����ֿ�һ����Ʒ");
			Thread.yield();
		}	
	}
}
