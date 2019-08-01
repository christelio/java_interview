package guess_interview.bank;

import java.util.HashMap;

public class atmDao {

	private String fileName = null;
	private atmDaoFileLoad fileLoad = null;
	private HashMap<String, User> userBox = null;

	atmDao(String fileName) {
		this.fileName = fileName;
		this.fileLoad = new atmDaoFileLoad(this.fileName);
		this.userBox = this.fileLoad.loadFile();
	}

	public User selectOne(String aneme) {
		return userBox.get(aneme);
	}

	public void update(User user)// 更新集合
	{
		userBox.put(user.getUserName(), user);
		fileLoad.commit(userBox);
	}

}
