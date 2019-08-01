package summer.holiday.string;

import java.util.Arrays;

import org.junit.Test;

public class String2 {
	/*
	 * ����һ��Excel����е������ƣ���������Ӧ������š�
	 * 
	 * ���磬
	 * 
	 * A -> 1 B -> 2 C -> 3 ... Z -> 26 AA -> 27 AB -> 28 ... ʾ�� 1:
	 * 
	 * ����: "A" ���: 1 ʾ�� 3:
	 * 
	 * ����: "ZY" ���: 701
	 */
	public int titleToNumber(String s) {
		if (s == null) {
			return 0;
		} else {
			int ans = 0;
			int tem = 0;
			for (int i = 0; i < s.length(); i++) {
				tem = s.charAt(i) - 'A' + 1;
				ans = ans * 26 + tem;
			}
			return ans;
		}
	}

}
