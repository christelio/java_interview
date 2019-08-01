package summer.hoilday.thread.model;

public class Consumer implements Runnable{
	private Warehouse wh=Warehouse.getWarehouse();
	public void run()
	{
		while(true)
		{
			wh.get();
			System.out.println("拿出仓库一件商品");
			try {
				Thread.sleep(360);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
}

