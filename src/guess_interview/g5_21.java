package guess_interview;

import org.junit.Test;

public class g5_21 extends Thread{


	    private boolean flag;

	    public  g5_21(boolean flag) {
	        this.flag = flag;
	    }
	  
	    @Override
	    public void run() {
	        if (flag) {
	            synchronized (MyLock.objA) {
	                System.out.println("if objA");
	                synchronized (MyLock.objB) {
	                    System.out.println("if objB");
	                }
	            }
	        } else {
	            synchronized (MyLock.objB) {
	                System.out.println("else objB");
	                synchronized (MyLock.objA) {
	                    System.out.println("else objA");
	                }
	            }
	        }
	      
	        }
	    @Test
	    public void demo()
        {
        	g5_21 dl1 = new g5_21(true);
        	g5_21 dl2 = new g5_21(false);

            dl1.start();
            dl2.start();
        }
	    
	}

