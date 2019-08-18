package summer.hoilday.Tree;

import java.util.LinkedList;
import java.util.Queue;
//�����������Ĳ���
public class treeSearch {
	/*�ж��Ƿ��Ƕ���������*/
	
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
	/*��������������,ÿ�ε�����С��Ԫ��
	 * 
	 * next()�����Ƴ���С��Ԫ��
	 * hasNext()�ж��Ƿ������һ��Ԫ��
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
	
	/*������������в����½��,�����ظ����*/
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
