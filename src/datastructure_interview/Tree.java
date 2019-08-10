package datastructure_interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import datastructure_interview.Tree_class.TreeNode;

public class Tree {
	
	//前序非递归遍历
	 public List<Integer> preorderTraversal(TreeNode root) {
	        List<Integer> list = new ArrayList<>();
	        if (root != null) {
	            Stack<TreeNode> stack = new Stack<>();
	            //先压根结点
	            stack.add(root);
	            while (!stack.isEmpty()) {
	                root = stack.pop();
	                list.add(root.val);
	                //在压右子树
	                if (root.right != null) {
	                    stack.push(root.right);
	                }
	                //再压左子树
	                if (root.left != null) {
	                    stack.push(root.left);
	                }
	                //这样出栈顺序就能做到根左右
	            }
	        }
	        return list;           
	    }
	 
	//中序遍历递归
	public void dsfTree(List<Integer> result, TreeNode root) {
	        
	        if (root.left != null) {
	            dsfTree(result, root.left);
	        }
	        
	        result.add(root.val);
	        
	        if (root.right != null) {
	            dsfTree(result, root.right);
	        }
	    }
	//后序遍历递归
	public void ptfTree(List<Integer> result, TreeNode root) {
        
        if (root.left != null) {
            ptfTree(result, root.left);
        } 
        
        if (root.right != null) {
            ptfTree(result, root.right);
        }
        result.add(root.val);
    }
}



