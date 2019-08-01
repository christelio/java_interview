package guess_interview;

public class g5_15 {
	  public volatile int inc = 0;
	    
	    public void increase() {
	        inc++;
	    }
	     
	    public static void main(String[] args) {
	         g5_15 test = new g5_15();
	       
	        for(int i=0;i<10;i++){
	            new Thread(){
	                public void run() {
	                    for(int j=0;j<1000;j++)
	                    {
	                        test.increase();
	                    	//System.out.println(test.inc);
	                    }
	                };
	            }.start();
	        }
	         
	        while(Thread.activeCount()>1)  //保证前面的线程都执行完
	            Thread.yield();
	        System.out.println(test.inc);
	        
	    }
}
