package guess_interview;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class g6_4 {
	
	public static void CopyStream() throws IOException
	{
		File file=new File("D://src/asd/项目1思路");
		System.out.print(file.getName());
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try {
			fis=new FileInputStream(file);
			File newFile=new File("D:/子/"+file.getName());
			System.out.print(newFile.getName());
			fos=new FileOutputStream(newFile);
			byte[]b=new byte[1024];
			int count=fis.read(b);
			while(count!=-1)
			{
				fos.write(b,0,count);
				fos.flush();
				count=fis.read(b);
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			fis.close();
			fos.close();
		}
	}
	
	public static void main(String args[]) throws IOException
	{
		CopyStream();
	}

}
