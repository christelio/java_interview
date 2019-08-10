package summer.hoilday.Tree;

import java.util.List;



public class TreeTraversal {
	//���
	class Node{
		Node left;
		Node right;
		int val;
		Node(int val)
		{
			this.val=val;
		}
	}
	//ǰ�����
	public void preTree(List<Integer> result, Node root) {
		result.add(root.val);
		if (root.left != null) {
			preTree(result, root.left);
		}
		if (root.right != null) {
			preTree(result, root.right);
		}
	}
	// ��������ݹ�
	public void dsfTree(List<Integer> result, Node root) {

		if (root.left != null) {
			dsfTree(result, root.left);
		}

		result.add(root.val);

		if (root.right != null) {
			dsfTree(result, root.right);
		}
	}

	// ��������ݹ�
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
