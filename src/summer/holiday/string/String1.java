package summer.holiday.string;

import java.util.Arrays;

public class String1 {

	/*
	 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
	 * 
	 * 示例 1:
	 * 
	 * 输入: s = "anagram", t = "nagaram" 输出: true
	 * 
	 * 就是相同的字符的不同的组成
	 */
	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		char[] str1 = s.toCharArray();
		char[] str2 = t.toCharArray();
		Arrays.sort(str1);
		Arrays.sort(str2);
		System.out.println(str1);
		return Arrays.equals(str1, str2);

	}
	// 知识点的体现 排序

	////
	/*
	 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
	 * 
	 * 案例:
	 * 
	 * s = "leetcode" 返回 0.
	 * 
	 * s = "loveleetcode", 返回 2.
	 */
	public int firstUniqChar(String s) {
		int[] letter = new int[26];// 存储各字符出现次数
		for (char c : s.toCharArray())// 第一次遍历
			letter[c - 'a']++;// 将字符与最小ascall码字符a的差值设成数组
		for (int i = 0; i < s.length(); i++) {// 第二次遍历
			if (letter[s.charAt(i) - 'a'] == 1)
				return i;
		}
		return -1;// 无解
	}
	// 思路:建立字符出现的次数数组,统计每个字符的出现次数.

	/*
	 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
	 * 
	 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
	 * 
	 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
	 */

	public void reverseString(char[] s) {
		int i = 0;
		int j = s.length - 1;
		char temp;
		while (i <= j) {
			temp = s[i];
			s[i] = s[j];
			s[j] = temp;
			i++;
			j--;
		}
	}
	// 思路双指针
	// 对撞指针i为数组头j为数组尾,通过缩短i和j的距离找到对应的坐标,nums[i]+nums[j]>target就缩小j反之增加i

	/*
	 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
	 * 
	 * 说明：本题中，我们将空字符串定义为有效的回文串。
	 */

	public boolean isPalindrome(String s) {
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
			if (s.charAt(i) == s.charAt(j) || ((Math.abs(s.charAt(i) - s.charAt(j))) == 32)) {
				i++;
				j--;
			} else {
				return false;
			}
		}

		return true;

	}
	// 头指针和尾指针,只要在范围内的字母相等就同时往中间移,不在范围内的就跳过,有不同的直接结束

	public static void main(String[] args) {
		String a = "abcdg";
		String b = "cdgab";
		System.out.println(isAnagram(a, b));
	}

}
