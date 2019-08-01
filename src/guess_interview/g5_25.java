package guess_interview;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.Set;
import java.util.SortedMap;

import org.junit.Test;

public class g5_25 {

	//@Test
	 public void demo()
	 {
		//新建文件
		 File file=new File("D:/javademo/java/demo/abc.txt");
		/* try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		 
		// file.mkdirs();
		// file.delete();
		 
		 
		 Charset c=Charset.defaultCharset();
		 System.out.println(c);
		 SortedMap<String,Charset> sm=Charset.availableCharsets();
		 Set<String> ketset=sm.keySet();
		System.out.println(ketset.size());
		 for(String s:ketset)
		 {
			 System.out.println(s);
		 }
		
	 }
	
	
	public static void Demo2() throws IOException
	{
		FileOutputStream fos=null;
		OutputStreamWriter osw=null;
		BufferedWriter bw=null;
		String charset="UTF-8";
		try {
			fos=new FileOutputStream("D:/javademo/java/demo/abc.txt");
		
			osw= new OutputStreamWriter(fos,charset);
			bw=new BufferedWriter(osw);
			bw.write("123");
			bw.newLine();
			System.out.println("123");
			bw.write("456");
			
			
			
			 File file = new File("D:/javademo/java/demo/abc.txt");
		        Writer writer = new FileWriter(file);
		        BufferedWriter b = new BufferedWriter(writer);
		        b.write("1234\n");
		        b.write("2345\n");
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			/*fos.close();
			osw.close();
			bw.close();*/
			
		}
	
	}
	
	@Test
	public  void writeFile1() {
		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		String charset = "UTF-8"; 
		
		try {
			fos=new FileOutputStream("D:/javademo/java/demo/abc.txt");
			
			osw= new OutputStreamWriter(fos,charset);
			bw=new BufferedWriter(osw);
			bw.write("123");
			bw.newLine();
			bw.write("741");
			
			
		
		
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				bw.close(); // 关闭最后一个类，会将所有的底层流都关闭
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	public static void main(String args[]) throws IOException
	{
			//Demo2();
			//writeFile1();
	}
	
	
}
