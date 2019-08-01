package guess_interview;

import org.junit.Test;

public class g4_22 {
	static int tickets=1000;
	public static synchronized void sellTickets()
	{
		int i=4;
		while(i>0)
		{
			i--;
			tickets--;
			System.out.println(Thread.currentThread().getName()+"---"+tickets);
		}
	}
	public  synchronized void sellTickets2()
	{
		int i=4;
		while(i>0)
		{
			i--;
			tickets++;
			System.out.println(Thread.currentThread().getName()+"---"+tickets);
		}
	}
		
		@Test
		public void Synchronizeddemo() throws InterruptedException
		{
			g4_22 demo=new g4_22();
			Thread thread1=new Thread(new Runnable()
					{
						public void run()
						{
							g4_22.sellTickets();
						
						}
					});
			
			
			Thread thread2=new Thread(new Runnable()
			{
				public void run()
				{
					demo.sellTickets2();
				}
			});
			
			Thread thread3=new Thread(new Runnable()
			{
				public void run()
				{
					demo.sellTickets2();
				}
			});
			
			Thread thread4=new Thread(new Runnable()
			{
				public void run()
				{
					g4_22.sellTickets();
					
				}
			});
			
			thread1.start();
			
			thread2.start();
			thread3.start();
			thread4.start();
	
		}
	
}
