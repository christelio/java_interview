package summer.hoilday.thread.model;

public class Consumer implements Runnable{
	private Warehouse wh=Warehouse.getWarehouse();
	public void run()
	{
		while(true)
		{
			wh.get();
			System.out.println("�ó��ֿ�һ����Ʒ");
			try {
				Thread.sleep(360);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
}

