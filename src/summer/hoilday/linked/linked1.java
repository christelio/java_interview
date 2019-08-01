package summer.hoilday.linked;

public class linked1 {

	// ���������
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	/*
	 * ��תһ��������
	 * 
	 * ʾ��:
	 * 
	 * ����: 1->2->3->4->5->NULL ���: 5->4->3->2->1->NULL
	 */

	public ListNode reverseList(ListNode head) {
		ListNode pre = null;
		ListNode circle = head;
		ListNode temp = null;
		while (circle != null) {
			temp = circle.next;
			circle.next = pre;
			pre = circle;
			circle = temp;
		}
		return pre;
	}
	/*
	 * ���ж�һ�������Ƿ�Ϊ��������
	 * 
	 * ʾ�� 1:
	 * 
	 * ����: 1->2 ���: false ʾ�� 2:
	 * 
	 * ����: 1->2->2->1 ���: true
	 */

	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;
		ListNode slow = head, fast = head.next, pre = null, prepre = null;
		while (fast != null && fast.next != null) {
			// ��תǰ�������
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
			// ���ƶ�ָ��������ת
			pre.next = prepre;
			prepre = pre;
		}
		ListNode p2 = slow.next;
		slow.next = pre;
		ListNode p1 = fast == null ? slow.next : slow;
		while (p1 != null) {
			if (p1.val != p2.val)
				return false;
			p1 = p1.next;
			p2 = p2.next;
		}
		return true;
	}
	

}
