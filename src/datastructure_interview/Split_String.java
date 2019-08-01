package datastructure_interview;

import java.util.ArrayList;
import java.util.List;

public class Split_String {
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
        while(i<=len){
            if(isRever(index,i)){
                list.add(str.substring(index,i+1));
                find(list,i+1);
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
}
