package summer.hoilday.linked;

public class linked2 {

	
	
	
	/*��һ��������ĳһ�����ֳ�С����,�������ʹ�����*/
	public static node linkPartition(node head, int partition) {
		// 000
		if (head == null) {
			return null;
		}

		node small = null; // С������ͷ
		node mid = null;// ��������ͷ
		node big = null;// ��������ͷ
		node tempHead = head;
		node tempSmall = null;
		node tempMid = null;
		node tempBig = null;

		// �ֱ�����ȷ��������С�����ĵ�һ��,�������ĵ�һ���ʹ������ĵ�һ��
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

		// �����ǽ���С����,�������ʹ�����������
		// ע����Ļ���,��Ҫ��ֹ����ѭ������
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
