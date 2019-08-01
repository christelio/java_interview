package summer.holiday.test;

import java.util.TreeSet;

import org.junit.Test;

public class TestCollection {
	@Test
	public void test()
	{
		TreeSet<Integer> set = new TreeSet<Integer>();
		TreeSet<Integer> subSet = new TreeSet<Integer>();
		for(int i=606;i<613;i++){
		    if(i%2==0){
		 set.add(i);
		    }
		}
		subSet = (TreeSet<Integer>)set.subSet(608,false,611,true);
		set.add(629);
		System.out.println(set+" "+subSet);
	}
	
}
