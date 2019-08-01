package guess_interview;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class g6_1 {
	public static void main(String args[])
	{
		File file=new File("D:/javademo/abc.txt");
		try {
			FileInputStream fis=new FileInputStream(file);
			char i=(char)fis.read();
			byte b[]=new byte[5];
			int count=fis.read(b);
			while(count!=0)
			{
				String s=new String(b);
				System.out.print(s);
				count=fis.read(b);
				
			}
			System.out.println(i);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
