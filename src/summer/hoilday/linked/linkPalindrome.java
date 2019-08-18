package summer.hoilday.linked;

import java.util.Stack;

public class linkPalindrome {

	
	public static boolean judgeLinkStack(node link) {
		if (link == null || link.next == null)
			return true;
		node slow = null;
		node quick = null;
		node half;
		Stack<Integer> halfLink = new Stack<Integer>();
		slow = link;
		quick = link;
		while (quick != null && quick.next != null) {
			slow = slow.next;
			quick = quick.next.next;
		}
		if (quick == null) {

		} else {
			slow = slow.next;
		}
		half = slow;
		while (slow != null) {
			halfLink.push(slow.val);
			slow = slow.next;
		}
		slow = link;
		while (!halfLink.isEmpty())
		{
			if (slow.val == halfLink.pop())
				slow = slow.next;
			else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		node a = new node(1);
		node b = new node(2);
		node c = new node(3);
		node d = new node(2);

		node e = new node(1);

		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		System.out.println(judgeLinkStack(a));
	}

}
