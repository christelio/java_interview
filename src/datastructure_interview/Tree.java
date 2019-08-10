package datastructure_interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import datastructure_interview.Tree_class.TreeNode;

public class Tree {
	
	//ǰ��ǵݹ����
	 public List<Integer> preorderTraversal(TreeNode root) {
	        List<Integer> list = new ArrayList<>();
	        if (root != null) {
	            Stack<TreeNode> stack = new Stack<>();
	            //��ѹ�����
	            stack.add(root);
	            while (!stack.isEmpty()) {
	                root = stack.pop();
	                list.add(root.val);
	                //��ѹ������
	                if (root.right != null) {
	                    stack.push(root.right);
	                }
	                //��ѹ������
	                if (root.left != null) {
	                    stack.push(root.left);
	                }
	                //������ջ˳���������������
	            }
	        }
	        return list;           
	    }
	 
	//��������ݹ�
	public void dsfTree(List<Integer> result, TreeNode root) {
	        
	        if (root.left != null) {
	            dsfTree(result, root.left);
	        }
	        
	        result.add(root.val);
	        
	        if (root.right != null) {
	            dsfTree(result, root.right);
	        }
	    }
	//��������ݹ�
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



