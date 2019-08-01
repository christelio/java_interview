package guess_interview.bank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

public class atmDaoFileLoad {
	
	
	
	
	
	private File file = null;
	
	
	atmDaoFileLoad(String fileName)
	{
		file=new File(fileName);
	}
	
	public HashMap<String,User> loadFile()
	{		
			HashMap<String,User> userBox=new HashMap<String,User>();
			try {
				FileReader fileReader;
				fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				String value = bufferedReader.readLine();
				while (value != null) {
					String[] userValue = value.split("-");
					User user = new User(userValue[0], userValue[1], Float.parseFloat(userValue[2]));
					userBox.put(user.getUserName(), user);
					value=bufferedReader.readLine();
				}
				return userBox;

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	}
	
	
	public void commit(HashMap<String,User> userBox) {

		FileWriter fileWriter = null;
		BufferedWriter bufferedWrited = null;

		try {
			File file = new File("src\\\\guess_interview\\\\user.txt");
			fileWriter = new FileWriter(file);
			bufferedWrited = new BufferedWriter(fileWriter);
			Iterator<String> names = userBox.keySet().iterator();

			while (names.hasNext()) {
				String name = names.next();
				User user = userBox.get(name);
				StringBuilder builder = new StringBuilder(user.getUserName());
				builder.append("-");
				builder.append(user.getUserPassword());
				builder.append("-");
				builder.append(user.getBalance());
				bufferedWrited.write(builder.toString());
				bufferedWrited.newLine();
				bufferedWrited.flush();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (fileWriter != null)
					fileWriter.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				if (bufferedWrited != null)
					bufferedWrited.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}
}
