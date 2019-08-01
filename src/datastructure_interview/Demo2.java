package datastructure_interview;

import java.util.ArrayList;
import java.util.List;

public class Demo2 {
	 List<List<String>> res=new ArrayList<List<String>>();
	    String str;
	    int len;
	    
	    public List<List<String>> partition(String s) {
	        str=s;
	        len=s.length()-1;
	        find(new ArrayList<>(),0);
	        return res;
	    }
	    
	    //主函数
	    public void find(List<String> list,int index) {
	        if(index==len+1){
	            res.add(new ArrayList<>(list));
	            return;
	       }
	        int i=index;
	       // System.out.println(i);
	        while(i<=len){
	            if(isRever(index,i)){
	            	list.add(str.substring(index,i+1));
	            
	                find(list,i+1);
	                System.out.println(list);
	                list.remove(list.size()-1);               
	            }
	            i++; 
	        } 
	    }
	    //判断是否是回文字符串
	    public boolean isRever(int i,int j){
	        while(i<=j){
	            if(str.charAt(i)!=str.charAt(j)) return false;
	            i++;
	            j--;
	        }
	        return true;
	    }
	    public static void main(String []args)
	    {
	    	Demo2 dd=new Demo2();
	    	dd.partition("aaaaa");
	    	System.out.println(dd.res);
	    }
}