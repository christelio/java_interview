package guess_interview;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//文件或文件夹的复制

public class g6_5_fileCopy {
	public void superCopyFile(File file, String newPath) {
		String oldFilePath = file.getAbsolutePath();
		String newFilePath = newPath + oldFilePath.split(":")[1];// 分割路径字符串,1就代表分割的后面的c://dasdadasd
		System.out.println(newFilePath);
		File newFile = new File(newFilePath);
		File[] files = file.listFiles();// 返回一个抽象路径名数组，该抽象路径名表示目录中的文件。如果这个抽象路径名不表示目录，那么这个方法返回null。通过这个数组完成文件夹中的文件表示,也就是文件夹中文件的路径的改变
		// System.out.print(files.length);
		if (files != null)// 如果是文件夹的话 就要创建文件夹和文件
		{
			System.out.println(files.length);
			newFile.mkdirs();
			if (files.length != 0) {
				for (File f : files) {
					this.superCopyFile(f, newPath);// f是变化的通过递归完成文件夹的复制
				}
			}
		}

		else {//递归完毕,这次的递归下通过流操作完成文件的复制
			FileInputStream fis = null;
			FileOutputStream fos = null;
			try {
				fis = new FileInputStream(file);
				fos = new FileOutputStream(newFile);
				byte b[] = new byte[1024];
				int count = fis.read(b);
				while (count != -1) {
					fos.write(b);
					fos.flush();
					count = fis.read();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}
	}

	public static void main(String args[]) {
		File file = new File("D:/JAVA疯狂动物城/图片");
		String path = "D:/SLS/";
		g6_5_fileCopy demo = new g6_5_fileCopy();
		demo.superCopyFile(file, path);
	}
}
