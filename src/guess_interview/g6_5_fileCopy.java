package guess_interview;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//�ļ����ļ��еĸ���

public class g6_5_fileCopy {
	public void superCopyFile(File file, String newPath) {
		String oldFilePath = file.getAbsolutePath();
		String newFilePath = newPath + oldFilePath.split(":")[1];// �ָ�·���ַ���,1�ʹ���ָ�ĺ����c://dasdadasd
		System.out.println(newFilePath);
		File newFile = new File(newFilePath);
		File[] files = file.listFiles();// ����һ������·�������飬�ó���·������ʾĿ¼�е��ļ�������������·��������ʾĿ¼����ô�����������null��ͨ�������������ļ����е��ļ���ʾ,Ҳ�����ļ������ļ���·���ĸı�
		// System.out.print(files.length);
		if (files != null)// ������ļ��еĻ� ��Ҫ�����ļ��к��ļ�
		{
			System.out.println(files.length);
			newFile.mkdirs();
			if (files.length != 0) {
				for (File f : files) {
					this.superCopyFile(f, newPath);// f�Ǳ仯��ͨ���ݹ�����ļ��еĸ���
				}
			}
		}

		else {//�ݹ����,��εĵݹ���ͨ������������ļ��ĸ���
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
		File file = new File("D:/JAVA������/ͼƬ");
		String path = "D:/SLS/";
		g6_5_fileCopy demo = new g6_5_fileCopy();
		demo.superCopyFile(file, path);
	}
}
