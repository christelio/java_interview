package summer.hoilday.linked;

public class linked1 {

	// 链表顶点对象
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	/*
	 * 反转一个单链表。
	 * 
	 * 示例:
	 * 
	 * 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL
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
	 * 请判断一个链表是否为回文链表。
	 * 
	 * 示例 1:
	 * 
	 * 输入: 1->2 输出: false 示例 2:
	 * 
	 * 输入: 1->2->2->1 输出: true
	 */

	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null)
			return true;
		ListNode slow = head, fast = head.next, pre = null, prepre = null;
		while (fast != null && fast.next != null) {
			// 反转前半段链表
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
			// 先移动指针再来反转
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
