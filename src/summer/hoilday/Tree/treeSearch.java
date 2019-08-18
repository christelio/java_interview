package summer.hoilday.Tree;

import java.util.LinkedList;
import java.util.Queue;
//二叉搜索树的操作
public class treeSearch {
	/*判断是否是二叉搜索树*/
	
	public boolean helper(TreeNode node, Integer lower, Integer upper) {
		if (node == null)
			return true;
		int val = node.val;
		if (upper != null && val >= upper)
			return false;
		if (lower != null && val <= lower)
			return false;

		if (!helper(node.left, lower, val))
			return false;
		if (!helper(node.right, val, upper))
			return false;
		return true;

	}

	public boolean isValidBST(TreeNode root) {
		return helper(root, null, null);
	}
	/*迭代二叉搜索树,每次迭代最小的元素
	 * 
	 * next()用来推出最小的元素
	 * hasNext()判断是否存在下一个元素
	 * */
	  
	TreeNode current;
	Queue<Integer> queue;

	public void BSTIterator(TreeNode root) {
        this.current=root;
        queue=new LinkedList<Integer>();
        in(current);
    }

	public void in(TreeNode root) {
		if (root == null)
			return;
		in(root.left);
		queue.add(root.val);
		in(root.right);
	}

	/** @return the next smallest number */
	public int next() {
		if (!queue.isEmpty()) {
			return queue.poll();
		}
		return -1;
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		if (queue.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
	
	/*向二叉搜索树中插入新结点,并返回根结点*/
	public TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null) {
			return null;
		}
		TreeNode base = root;
		while (true) {
			if (val > root.val) {
				if (root.right == null) {
					root.right = new TreeNode(val);
					return base;
				} else
					root = root.right;
			}
			if (val < root.val) {
				if (root.left == null) {
					root.left = new TreeNode(val);
					return base;
				} else
					root = root.left;
			}
		}
	}
}
