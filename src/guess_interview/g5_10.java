package guess_interview;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class g5_10 {
	
	
	@Test
	public void Test()
	{
		LinkedList <String> l=new LinkedList();
		ArrayList<String> l2=new ArrayList();
		for(int i=0;i<36;i++)
		{
			l.add("yhm"+i);
			l2.add("yhm"+i);
		}
		System.out.println(l);
		
		
		System.out.println(l2);
	}
}
