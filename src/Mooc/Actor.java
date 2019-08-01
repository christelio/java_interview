package Mooc;

public class Actor extends Thread{
	
	public void run()
	{
		System.out.println(getName()+"这是一个演员");
		int count=0;
		boolean keepRunning=true;
		while(keepRunning)
		{
		System.out.println(getName()+"登台演出"+(++count));
		if(count==120)
			keepRunning=false;
		 if(count%10==0)
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(getName()+"的演出结束了");
	}
	
	public static void main(String[] args)
	{
		Thread actor=new Actor();
		actor.start();
		Thread actor2=new Actor();
		actor2.start();
		//Thread actressThread=new Thread(new Actress(),"asd");
		
	}
	class Actress implements Runnable{
		@Override
		public void run()
		{
			System.out.println(Thread.currentThread().getName()+"这是一个演员");
			int count=0;
			boolean keepRunning=true;
			while(keepRunning)
			{
			System.out.println(Thread.currentThread().getName()+"登台演出"+(++count));
			if(count==120)
				keepRunning=false;
			 if(count%10==0)
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName()+"的演出结束了");
		}
		
	}
}
