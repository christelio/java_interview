package Mooc;

public class Actor extends Thread{
	
	public void run()
	{
		System.out.println(getName()+"����һ����Ա");
		int count=0;
		boolean keepRunning=true;
		while(keepRunning)
		{
		System.out.println(getName()+"��̨�ݳ�"+(++count));
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
		System.out.println(getName()+"���ݳ�������");
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
			System.out.println(Thread.currentThread().getName()+"����һ����Ա");
			int count=0;
			boolean keepRunning=true;
			while(keepRunning)
			{
			System.out.println(Thread.currentThread().getName()+"��̨�ݳ�"+(++count));
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
			System.out.println(Thread.currentThread().getName()+"���ݳ�������");
		}
		
	}
}
