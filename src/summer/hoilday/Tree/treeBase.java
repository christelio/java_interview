package summer.hoilday.Tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import summer.hoilday.Tree.TreeTraversal.Node;
/*二叉树的基础问题*/
public class treeBase {
	
		//前序遍历
		public void preTree( TreeNode root) {
			System.out.println(root.val);
			if (root.left != null) {
				preTree(root.left);
			}
			if (root.right != null) {
				preTree( root.right);
			}
		}
		// 中序遍历递归
		public void dsfTree(List<Integer> result, TreeNode root) {

			if (root.left != null) {
				dsfTree(result, root.left);
			}

			result.add(root.val);

			if (root.right != null) {
				dsfTree(result, root.right);
			}
		}

		// 后序遍历递归
		public void ptfTree(List<Integer> result, TreeNode root) {

			if (root.left != null) {
				ptfTree(result, root.left);
			}

			if (root.right != null) {
				ptfTree(result, root.right);
			}
			result.add(root.val);
		}
		
	//数点最大深度
	   public int maxDepth(TreeNode root) {
	        if(root==null)
	            return 0;
	        int leftMax=maxDepth(root.left);
	        int rightMax=maxDepth(root.right);
	        return leftMax>rightMax?leftMax+1:rightMax+1;
	    }
	   
	   //是否是对称树    在递归中中用了&&
	    public boolean isSymmetric(TreeNode root) {
	        if(root==null)
	            return true;
	      return recur(root.left,root.right);
	    }
	    public boolean recur(TreeNode t1,TreeNode t2)
	    {
	        if(t1==null&&t2==null)
	            return true;
	        else if(t1==null||t2==null)
	            return false;
	        return((t1.val==t2.val)&&recur(t1.left,t2.right)&&recur(t1.right,t2.left));
	        }
	    
	    
	  //是否是对称树    在递归中中用了||
	    public boolean hasPathSum(TreeNode root, int sum) {
	        if(root==null)
	            return false;
	        sum=sum-root.val;
	        if(root.left==null&&root.right==null)
	            return (sum==0);
	        return hasPathSum(root.left,sum)||hasPathSum(root.right,sum);
	    }
	    
	    /*中序和后序遍历构造二叉树*/

		
		private int[] inorder;
		private int[] postorder;
		private int[] preorder;

		public TreeNode buildTree(int[] inorder, int[] postorder) {
			int len = inorder.length;
			this.inorder = inorder;
			this.postorder = postorder;
			return dfs(0, len - 1, 0, len - 1);
		}

		public TreeNode dfs(int inl, int inr, int pol, int por) {
			if (inl > inr || pol > por) {
				return null;
			}
			int k = 0;
			for (int i = inl; i < inr + 1; i++) {
				if (inorder[i] == postorder[por]) {
					k = i;
					break;
				}

			}
			TreeNode root = new TreeNode(inorder[k]);
			root.left = dfs(inl, k - 1, pol, k - 1 - inl + pol);
			root.right = dfs(k + 1, inr, por - 1 - inr + k + 1, por - 1);
			return root;
		}

	/* 前序遍历和中序遍历递归建立二叉树 */

	public TreeNode buildTree2(int[] inorder, int[] preorder) {
		int len = inorder.length;
		this.inorder = inorder;
		this.preorder = preorder;
		return pms(0, len - 1, 0, len - 1);
	}

	public TreeNode pms(int inl, int inr, int prl, int prr) {
		if (inl > inr || prl > prr) {
			return null;
		}
		int k = 0;
		for (int i = inl; i < inr + 1; i++) {
			if (inorder[i] == preorder[prl]) {
				k = i;
				break;
			}

		}
		TreeNode root = new TreeNode(inorder[k]);
		root.left = dfs(inl, k - 1, prl + 1, prl+k-inl);
		root.right = dfs(k + 1, inr, prl + k + 1 - inl, prr);
		return root;
	}
	
	// 二叉树的最近公共祖先
		//
	private TreeNode ans;

	public boolean find(TreeNode current, TreeNode p, TreeNode q) {
		if (current == null)
			return false;
		int left = this.find(current.left, p, q) ? 1 : 0;
		int right = this.find(current.right, p, q) ? 1 : 0;
		int mid = (current == p || current == q) ? 1 : 0;
		if (left + right + mid >= 2)
			this.ans = current;
		return ((left + right + mid) > 0);
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		this.find(root, p, q);
		return ans;
	}
	
	// 二叉树序列化与反序列化
	// 中序遍历序列化
	public String serialize(TreeNode root) {
		return find1(root, "");

	}

	public String find1(TreeNode root, String str) {

		if (root == null) {
			str += "null,";
			return str;
		}
		str += String.valueOf(root.val) + ",";
		str = find1(root.left, str);
		str = find1(root.right, str);
		return str;
	}

	// 反序列化 深度优先遍历构造
	// Decodes your encoded data to tree.
	 public TreeNode rdeserialize(List<String> l) {
		    // Recursive deserialization.
		    if (l.get(0).equals("null")) {
		      l.remove(0);
		      return null;
		    }

		    TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
		    l.remove(0);
		    root.left = rdeserialize(l);
		    root.right = rdeserialize(l);

		    return root;
		  }

		  // Decodes your encoded data to tree.
		  public TreeNode deserialize(String data) {
		    String[] data_array = data.split(",");
		    List<String> data_list = new LinkedList<String>(Arrays.asList(data_array));
		    return rdeserialize(data_list);
		  }



	public static void main(String[] args) {

		treeBase demo=new treeBase();
		int a[]= {1,5,4,6,7,9,12};
		int b[]= {1,4,7,6,12,9,5};
		TreeNode node=demo.buildTree(a,b);
		demo.preTree(node);
	}
}
