package summer.hoilday.thread.model;

public class testMainPhilosopher {

	
	public static void main(String[] args)
	{
		Chopsticks c1=new Chopsticks("1�ſ���");
		Chopsticks c2=new Chopsticks("2�ſ���");
		Chopsticks c3=new Chopsticks("3�ſ���");
		Chopsticks c4=new Chopsticks("4�ſ���");
		
		
		Philosopher p1=new Philosopher("ŷ������",c2,c1,0);
		Philosopher p2=new Philosopher("����Ϫ",c3,c2,200);
		Philosopher p3=new Philosopher("�׷���",c4,c3,0);
		Philosopher p4=new Philosopher("Eilo",c1,c4,500);
		p1.start();
		p2.start();
		p3.start();
		p4.start();
	}
}
