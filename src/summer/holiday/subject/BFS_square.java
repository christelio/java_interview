package summer.holiday.subject;

import java.util.LinkedList;
import java.util.Queue;

/*给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

示例 1:

输入: n = 12
输出: 3 
解释: 12 = 4 + 4 + 4.
示例 2:

输入: n = 13
输出: 2
解释: 13 = 4 + 9.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/perfect-squares
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class BFS_square {
	// 结点类,
	static class Node {
		int val;
		int step;

		public Node(int val, int step) {
			this.val = val;
			this.step = step;
		}

	}

	public int numSquares(int n) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(n, 0));
		boolean[] visited = new boolean[n + 1];// 判断数组,判断是否已经出现过
		while (!queue.isEmpty()) {
			int num = queue.peek().val;
			int step = queue.peek().step;// 逆推的步数
			queue.remove();

			for (int i = 1;; i++) {
				int value = num - i * i;
				if (value == 0) {
					return step + 1;
				}
				if (value < 0) {
					break;
				}
				if (!visited[value]) {
					visited[value] = true;
					queue.add(new Node(value, step + 1));
				}
			}
		}
		return -1;
	}
}
