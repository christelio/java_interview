package summer.hoilday.Tree;

import java.util.List;



public class TreeTraversal {
	//结点
	class Node{
		Node left;
		Node right;
		int val;
		Node(int val)
		{
			this.val=val;
		}
	}
	//前序遍历
	public void preTree(List<Integer> result, Node root) {
		result.add(root.val);
		if (root.left != null) {
			preTree(result, root.left);
		}
		if (root.right != null) {
			preTree(result, root.right);
		}
	}
	// 中序遍历递归
	public void dsfTree(List<Integer> result, Node root) {

		if (root.left != null) {
			dsfTree(result, root.left);
		}

		result.add(root.val);

		if (root.right != null) {
			dsfTree(result, root.right);
		}
	}

	// 后序遍历递归
	public void ptfTree(List<Integer> result, Node root) {

		if (root.left != null) {
			ptfTree(result, root.left);
		}

		if (root.right != null) {
			ptfTree(result, root.right);
		}
		result.add(root.val);
	}
}
