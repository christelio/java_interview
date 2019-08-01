package guess_interview;

import java.io.File;

public class g5_29 {
	
	public void showFile(File file)
	{
		File[] files=file.listFiles();
		if(files!=null &&files.length!=0)
			for(File f: files)
			{
				this.showFile(f);
			}
		System.out.println(file.getAbsolutePath());
		
	}
	
	public static void main(String args[])
	{
		g5_29 a=new g5_29();
		File file=new File("D:/SCM");
		a.showFile(file);
	}
}
