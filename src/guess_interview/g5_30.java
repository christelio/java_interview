package guess_interview;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class g5_30 {
	
	
	public static void main(String args[])
	{
		File file=new File("D:/javademo/abc.txt");
		try {
			FileInputStream fis=new FileInputStream(file);
			char i=(char)fis.read();
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
