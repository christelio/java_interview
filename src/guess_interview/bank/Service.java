package guess_interview.bank;

//服务层,只关注业务逻辑
public class Service {

	
	private atmDao dao=new atmDao("//src//a.txt");
	



	

	// 登录
	public String login(String aname, String apassord) {
		User user = dao.selectOne(aname);
		if (user != null && user.getUserPassword().equals(apassord)) {
			return "登录成功";
		}
		return "用户名或密码错误";
	}

	// 查询余额
	public Float querrBalance(String aname) {
		User user = dao.selectOne(aname);// 每个方法都有这个,所以可以优化
		return user.getBalance();
	}

	public void deposit(String aname, Float depositMoney) {
		User user = dao.selectOne(aname);
		user.setBalance(user.getBalance() + depositMoney);
		dao.update(user);
	}
	
	public void withdraw(String aname, Float depositMoney) {
		
		User user = dao.selectOne(aname);
		if(user.getBalance()>=depositMoney)
		{
			user.setBalance(user.getBalance() - depositMoney);
			dao.update(user);
		}	
		else
		{
			System.out.print("余额不足");
		}
	
	}
	
	
public void transfer(String outName,String inName,Float transferMoney) {
		
		User userOut = dao.selectOne(outName);
	
		
		
		if(userOut.getBalance()>=transferMoney)
		{
			User userIn=dao.selectOne(inName);
			if(userIn!=null)
			{
				userOut.setBalance(userOut.getBalance()-transferMoney);
				userIn.setBalance(userIn.getBalance()+transferMoney);
				dao.update(userOut);
				dao.update(userIn);
				
			}
		}	
		else
		{
			System.out.print("余额不足");
		}
	
	}
	

}
