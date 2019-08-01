package guess_interview.bank;

//�����,ֻ��עҵ���߼�
public class Service {

	
	private atmDao dao=new atmDao("//src//a.txt");
	



	

	// ��¼
	public String login(String aname, String apassord) {
		User user = dao.selectOne(aname);
		if (user != null && user.getUserPassword().equals(apassord)) {
			return "��¼�ɹ�";
		}
		return "�û������������";
	}

	// ��ѯ���
	public Float querrBalance(String aname) {
		User user = dao.selectOne(aname);// ÿ�������������,���Կ����Ż�
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
			System.out.print("����");
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
			System.out.print("����");
		}
	
	}
	

}
