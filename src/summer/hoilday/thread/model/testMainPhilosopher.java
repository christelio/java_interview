package summer.hoilday.thread.model;

public class testMainPhilosopher {

	
	public static void main(String[] args)
	{
		Chopsticks c1=new Chopsticks("1ºÅ¿ê×Ó");
		Chopsticks c2=new Chopsticks("2ºÅ¿ê×Ó");
		Chopsticks c3=new Chopsticks("3ºÅ¿ê×Ó");
		Chopsticks c4=new Chopsticks("4ºÅ¿ê×Ó");
		
		
		Philosopher p1=new Philosopher("Å·Ñô°×Ñæ",c2,c1,0);
		Philosopher p2=new Philosopher("Ò×ÖðÏª",c3,c2,200);
		Philosopher p3=new Philosopher("Ò×·öËÕ",c4,c3,0);
		Philosopher p4=new Philosopher("Eilo",c1,c4,500);
		p1.start();
		p2.start();
		p3.start();
		p4.start();
	}
}
