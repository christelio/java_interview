package summer.hoilday.linked;

public class linked2 {

	
	
	
	/*将一个单链表按某一个数分成小于区,等于区和大于区*/
	public static node linkPartition(node head, int partition) {
		// 000
		if (head == null) {
			return null;
		}

		node small = null; // 小于区域开头
		node mid = null;// 等于区域开头
		node big = null;// 大于区域开头
		node tempHead = head;
		node tempSmall = null;
		node tempMid = null;
		node tempBig = null;

		// 分别用来确保链表中小于区的第一个,等于区的第一个和大于区的第一个
		boolean judgeSmall = true;
		boolean judgeMid = true;
		boolean judgeBig = true;
		while (tempHead != null) {
			if (tempHead.val < partition && judgeSmall) {
				small = tempHead;
				judgeSmall = false;
			} else if (tempHead.val == partition && judgeMid) {
				mid = tempHead;
				judgeMid = false;
			} else if (tempHead.val > partition && judgeBig) {
				big = tempHead;
				judgeBig = false;
			}
			if ((!judgeSmall) && (!judgeMid) && (!judgeBig))
				break;
			tempHead = tempHead.next;
		}

		tempSmall = small;
		tempMid = mid;
		tempBig = big;
		tempHead = head;
		while (tempHead != null) {
			if (tempHead.val < partition && tempHead != small) {
				tempSmall.next = tempHead;
				tempSmall = tempHead;
			} else if (tempHead.val == partition && tempHead != mid) {
				tempMid.next = tempHead;
				tempMid = tempHead;
			} else if (tempHead.val > partition && tempHead != big) {
				tempBig.next = tempHead;
				tempBig = tempHead;
			}
			tempHead = tempHead.next;
		}

		// 下面是进行小于区,等于区和大于区的连接
		// 注意别界的划分,还要防止生成循环链表
		//

		// 001
		if (small == null && mid == null && big != null) {
			return big;
		}
		// 010
		else if (small == null && mid != null && big == null) {
			return mid;
		}
		// 011
		else if (small == null && mid != null && big != null) {
			tempMid.next = big;
			tempBig.next = null;
			return mid;
		}
		// 100
		else if (small != null && mid == null && big == null) {
			return small;
		}
		// 101
		else if (small != null && mid == null && big != null) {
			tempSmall.next = big;
			tempBig.next = null;
			return small;
		}
		// 110
		else if (small != null && mid != null && big == null) {
			tempSmall.next = mid;
			tempMid.next = null;
			return small;
		}
		// 111
		else if (small != null && mid != null && big != null) {

			tempSmall.next = mid;
			tempMid.next = big;
			tempBig.next = null;
			return small;
		}

		return null;
	}

	public static void main(String[] args) {
		node a = new node(6);
		node b = new node(9);
		node c = new node(2);
		node d = new node(4);

		node e = new node(3);
		node f = new node(12);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		node temp = null;
		temp = linkPartition(a, 5);
		while (temp != null) {
			System.out.println(temp.val);
			temp = temp.next;
		}
	}

}
