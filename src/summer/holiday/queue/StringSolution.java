package summer.holiday.queue;

public class StringSolution {

	// ��֤�Ƿ��ǻ��Ĵ�
	public boolean isPalindrome(String s) {
		//iΪͷָ�룬jΪβָ��
		int i, j;
		i = 0;
		j = s.length() - 1;
		while (i < j) {
			if (!((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
					|| (s.charAt(i) >= '0' && s.charAt(i) <= '9'))) {
				i++;
				continue;
			}
			if (!((s.charAt(j) >= 'A' && s.charAt(j) <= 'Z') || (s.charAt(j) >= 'a' && s.charAt(j) <= 'z')
					|| (s.charAt(j) >= '0' && s.charAt(j) <= '9'))) {
				j--;
				continue;
			}
			if (s.charAt(i) == s.charAt(j)
					|| (Math.abs(s.charAt(i) - s.charAt(j)) == 32) && s.charAt(i) >= 'A' && s.charAt(j) >= 'a') {
				i++;
				j--;

			} else {
				return false;
			}

		}
		return true;
	}
}
