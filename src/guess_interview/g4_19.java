package guess_interview;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class g4_19 {
	@Test
	public void array() throws UnsupportedEncodingException
	{
		List d=new ArrayList();	
		String b="dasd";
		g4_19 c = null;
		Object a[]=new Object[10];
		
		a[0]=b;
		a[1]=c;
		a[2]=2;
		
		//输出指定编码的字符串
		{
			System.out.println(a[0]);
			{
			String name="yhm";
			String name1=new String(name.getBytes(),"Iso8859-1");
			System.out.println(name1);
			}
		}
		//跳出多层循环
		{
			ok:for(int i=1;i<10;i++)
			{
				System.out.print(2);
				for(int j=1;j<10;j++)
				{
					System.out.print(1);
					
					break ok;
				}
			}
			boolean bool=false;
			for(int i=1;i<10&&bool==true;i++)
			{
				System.out.print(2);
				for(int j=1;j<10;j++)
				{
					System.out.print(1);
					
					break ;
				}
			}
		
		}
	}
}
