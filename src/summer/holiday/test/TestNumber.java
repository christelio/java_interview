package summer.holiday.test;

import org.junit.Test;

public class TestNumber {
	@Test
	public void testShort()
	{
		System.out.println(((short)10/10.2*2));
		System.out.println(10);
	}
}
class Node {
    int x;
    Node next;
    public Node(int x) {
        this.x = x;
        this.next = null;
    }
}

