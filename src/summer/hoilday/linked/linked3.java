package summer.hoilday.linked;

import java.util.HashMap;
import java.util.Map;

//复制含有随机指针的链表
public class linked3 {
	// 哈希表解法
	public static nodeRandom modelMerge(nodeRandom first) {
		if (first == null)
			return null;
		nodeRandom temp = first;
		Map<nodeRandom, nodeRandom> container = new HashMap<nodeRandom, nodeRandom>();
		while (first != null) {
			container.put(first, new nodeRandom(first.val));
			first = first.next;

		}
		first = temp;
		while (first != null) {
			container.get(first).next = container.get(first.next);
			container.get(first).random = container.get(first.random);
			first = first.next;
		}
		first = temp;
		return container.get(first);
	}

	// 非哈希表解法
	public static nodeRandom linkMerge(nodeRandom first) {
		if (first == null) {
			return null;
		}
		nodeRandom tempFirst = first;//老链表用来循环的代替指针
		nodeRandom tempSecond = null;//新链表的代替指针
		int judge = 1;
		// 新老链表合并
		while (tempFirst != null) {
			nodeRandom second = new nodeRandom(tempFirst.val);
			second.next = tempFirst.next;
			tempFirst.next = second;
			tempFirst = second.next;
		}
		tempSecond = first.next;
		tempFirst = first;
		// 新链表赋random值
		while (tempFirst != null) {
			if (judge % 2 == 1) {
				if (tempFirst.random != null) {
					tempFirst.next.random = tempFirst.random.next;
				} else {
					tempFirst.next.random = null;
				}
			}
			tempFirst = tempFirst.next;
			judge++;
		}

		tempFirst = first;
		tempSecond = tempFirst.next;
		nodeRandom second = tempSecond;
		tempFirst.next = tempSecond.next;
		tempFirst = tempFirst.next;
		// 新老链表分离
		while (tempFirst != null) {
			tempSecond.next = tempFirst.next;
			tempFirst.next = tempSecond.next.next;
			tempSecond = tempSecond.next;
			tempFirst = tempFirst.next;
		}
		return second;
	}

	public static void main(String[] args) {
		nodeRandom a = new nodeRandom(1);

		nodeRandom b = new nodeRandom(2);
		nodeRandom c = new nodeRandom(3);
		nodeRandom d = new nodeRandom(4);
		nodeRandom e = new nodeRandom(5);
		nodeRandom f = new nodeRandom(6);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;

		a.random = b;
		b.random = null;
		c.random = f;
		d.random = e;
		e.random = null;
		f.random = a;

		nodeRandom KK = modelMerge(a);
		while (KK != null) {
			if (KK.random != null)
				System.out.println(KK.val + "," + KK.random.val);
			else
				System.out.println(KK.val + "," + null);
			KK = KK.next;
		}
	}
}
