package datastructure_interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

import org.junit.Assert;
import org.junit.Test;

public class data_structure_solution {
	
	/*在一个二维数组中（
	 * 每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
	 * 每一列都按照从上到下递增的顺序排序。
	 * 请完成一个函数，输入这样的一个二维数组和一个整数，
	 * 判断数组中是否含有该整数。
	*/
	public boolean matrix_fine(int target, int array[][]) {
		int length = 0;
		int i = array[0].length - 1;
		while ((length < array.length) && (i >= 0)) {
			if (target > array[length][i]) {
				length++;
			} else if (target < array[length][i]) {
				i--;
			} else {
				return true;
			}
		}
		return false;
	}
	//关键点,选取定点然后比较
	
	
	/*给定一个数组 nums，
	 * 编写一个函数将所有 0 移动到数组的末尾
	 * 同时保持非零元素的相对顺序。
	 * */
	 public void moveZeroes(int[] nums) {
	        int i = 0,j = 0;
	        for(i = 0 ; i < nums.length; i++)
	        {
	            if(nums[i] != 0)
	            {
	                nums[j++] = nums[i];
	            }
	        }
	        while(j < nums.length)
	        {
	            nums[j++] = 0;
	        }
	    }
	 /*关键点,两个下标的移动速度
	    双指针法*/

	/*
	 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。

	不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

	元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
	 */
	   public int removeElement(int[] nums, int val) {
            int i = 0,j = 0;
       for(i = 0 ; i < nums.length; i++)
       {
           if(nums[i] != val)
           {
               nums[j++] = nums[i];
           }
       }
       return j;
   }
	 //关键点和上题一样 
	 
	   public int removeElement1(int[] nums, int val) {
		    int i = 0;
		    int n = nums.length;
		    while (i < n) {
		        if (nums[i] == val) {
		            nums[i] = nums[n - 1];
		            // reduce array size by one
		            n--;
		        } else {
		            i++;
		        }
		    }
		    return n;
		}
	   //第二个解
	   
	   
	   
	   
	   /*给定一个排序数组，
	    * 你需要在原地删除重复出现的元素，
	    * 使得每个元素只出现一次，
	    * 返回移除后数组的新长度。

		不要使用额外的数组空间，
		你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成*/
	   public int removeDuplicates(int[] nums) {
	        int j=0;
	        int i=1;
	        while(i<nums.length)
	        {
	            if(nums[j]!=nums[i])
	            {
	                j++;
	                nums[j]=nums[i];
	            }
	             i++;
	        }
	        return j+1;
	    }
	   	//双指针法,注意一个快指针的坐标表示,只要一直往后移就代表都是重复元素,所以这之内的元素就可以不用管！！


	/*
	 * 给定一个排序数组，你需要在原地删除重复出现的元素，
	 * 使得每个元素最多出现两次，返回移除后数组的新长度。
	
	不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1)
	 额外空间的条件下完成。*/
	   public int removeDuplicates_2(int[] nums) {
	        int j=0;
	        int i=1;
	        int k=1;
	        int num=0;
	        while(i<nums.length)
	        {
	            if(nums[j]==nums[i]&&k==1)
	            {
	               
	                nums[++j]=nums[i];
	                k=0;
	            }
	            else if(nums[j]!=nums[i])
	            {
	               
	                nums[++j]=nums[i];
	                k=1;
	            }
	             ++i;
	        }
	        return j+1;
	    }
	   //双指针法,和上一题类似,只是多了一个重复变量K的判断,即多加了一个判断语句和一个变量变化
	   
	   /*给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
	    * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
	    * 注意:不能使用代码库中的排序函数来解决这道题。*/
	   //解法一   
	   public void sortColors(int[] nums) {
	        int zero=0;
	        int one=0;
	        int two=0;
	        for(int i=0;i<nums.length;i++)
	        {
	            if(nums[i]==0)
	                ++zero;
	            else if(nums[i]==1)
	                ++one;
	            else
	                ++two;
	        }
	        for(int i=0;i<nums.length;i++)
	        {        if(i<zero)
	                    nums[i]=0;
	                else if(i>=zero&&(i<(zero+one)))
	                    nums[i]=1;
	                else 
	                    nums[i]=2;
	        }
	}
	   //计数字法  将0,1,2出现的次数分别记下来,重新构造数组
	   //解法二
	   public void sortColors2(int[] nums) {
		     int len = nums.length;
		        int i = 0,j = len-1;
		        int index = 0;
		        int temp=0;
		        while(index<=j)
		        {
		            if(nums[index]==0)
		            {
		                temp=nums[index];
		                nums[index]=nums[i];
		                nums[i]=temp;
		               
		                i++;
		                index++;
		            }

		            else if(nums[index]==2)
		            {
		                 temp=nums[index];
		                nums[index]=nums[j];
		                nums[j]=temp;
		                j--;
		            }
		            else
		                index++;
		        }
		}
	   //三指针快排法  i,j表示交换指针,index是遍历指针,i确保数组头是0,j确保数组尾是2,由遍历指针和它们交换
	   //i和j不断往中间靠拢,已经交换好了的就是已经排序好的。
	   
	   public void findKthLargest() {
		   int[] nums= {15,4,2,5,6,9,8,7,11,12,16,13,22};
		   int k=5;
		    if (nums == null || nums.length == 0) {
		       // return -1;
		    }
		    PriorityQueue<Integer> queue = new PriorityQueue<>();
		    for (int i = 0; i < nums.length; i++) {
		        if (i < k || nums[i] > queue.peek()) {
		        	
		            queue.offer(nums[i]);
		            System.out.println(queue);
		           
		        }
		        if (queue.size() > k) {
		            queue.poll();
		        }
		    }
		    System.out.println(queue.peek());
		  //  return queue.peek();
		}
		/*给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
		
			说明:
		
		    初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
		    你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
		*/
	   
	   public void merge(int[] nums1, int m, int[] nums2, int n) {
	        //归并,且是排好序之后的merge部分
			if(m==0){
				for(int i=0;i<nums2.length;i++){
					nums1[i] = nums2[i];
				}
				return ;
			}
			if(n==0){
				return ;
			}
	        int i=m-1,j=n-1,k=m+n-1;//2 2
	        while(i>=0&&j>=0){
	            if(nums1[i]>nums2[j]){
	                nums1[k--] = nums1[i];
	                nums1[i--] = 0;
	            }
	            else{
	                nums1[k--] = nums2[j];
	                nums2[j--] = 0;
	            }
	        }
	        while(i>=0)
	        	nums1[k--] = nums1[i--];
	        while(j>=0)
	        	nums1[k--] = nums2[j--];
	    }
	   	//尾插法，将nums1当做一个大数组,从nums1和nums2的末尾开始比较然后插入元素到nums1末尾(因为nums1足够大所以可以这样)


	/*给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
	
	函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
	
	说明:
	
	    返回的下标值（index1 和 index2）不是从零开始的。
	    你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
	*/
	public int[] twoSum(int[] nums, int target) {
		int i=0;
		int j=nums.length-1;
		while(i!=j)
	    {
			if((nums[i]+nums[j])<target)
				{
					i++;
				}
			else if((nums[i]+nums[j])>target)
			{
				j--;
			}
			else
			{
				i++;
				j++;
				return new int[]{i,j};
			}
		}
		 throw new IllegalArgumentException("No two sum solution");
	}
	//对撞指针i为数组头j为数组尾,通过缩短i和j的距离找到对应的坐标,nums[i]+nums[j]>target就缩小j反之增加i
	
	/*给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

	说明：本题中，我们将空字符串定义为有效的回文串。*/

	public boolean isPalindrome(String s) {
		int i, j;
		i = 0;
		j = s.length() - 1;

		while (i < j) {
			if (!((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') || (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
					|| (s.charAt(i) >= '0' && s.charAt(i) <= '9'))) {
				i++;
				continue;
			}
			if (!((s.charAt(j) >= 'A' && s.charAt(j) <= 'Z') || (s.charAt(j) >= 'a' && s.charAt(j) <= 'z')
					|| (s.charAt(j) >= '0' && s.charAt(j) <= '9'))) {
				j--;
				continue;
			}
			if (s.charAt(i) == s.charAt(j) || ((Math.abs(s.charAt(i) - s.charAt(j))) == 32)) {
				i++;
				j--;
			} else {
				return false;
			}
		}

		return true;

	}
	 //头指针和尾指针,只要在范围内的字母相等就同时往中间移,不在范围内的就跳过,有不同的直接结束
	 
	 
	
	 /**/
	 
	 
	 		/*写一个函数，以字符串作为输入，反转该字符串中的元音字母。

			示例 1:
			
			输入: "hello"
			输出: "holle"*/
	 		
		    private HashSet<Character> simple=new HashSet<Character>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
		   
		    public String reverseVowels(String s) {
		    	
		       int i=0,j=s.length()-1;
		        char[] result=new char[s.length()];
		        while(i<=j){
		            char ci=s.charAt(i);
		            char cj=s.charAt(j);
		            if(!(ci=='a'||ci=='e'||ci=='i'||ci=='o'||ci=='u'||ci=='A'||ci=='E'||ci=='I'||ci=='O'||ci=='U'))
		                result[i++]=ci;
		            else if(!(cj=='a'||cj=='e'||cj=='i'||cj=='o'||cj=='u'||cj=='A'||cj=='E'||cj=='I'||cj=='O'||cj=='U'))
		                result[j--]=cj;
		            else{
		                result[i++]=cj;
		                result[j--]=ci;
		            }
		        }
		       return new String(result);
		    }
		    
		    //双指针思想,因为String无法内部交换字符,所以用的字符数组,要首指针和尾指针同时遇到元音字母才会交换
			/*
			 * 
			 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
			
			说明：你不能倾斜容器，且 n 的值至少为 2。*/	
		    public int maxArea(int[] height) {
		        int maxarea = 0, l = 0, r = height.length - 1;
		        while (l < r) {
		            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
		            if (height[l] < height[r])
		                l++;
		            else
		                r--;
		        }
		        return maxarea;
		    }
		    //双指针,因为面积是根据短的一方算的,所以队头和队尾移动短的即可
		    
		    
		    /*
		     * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。
		     * 如果不存在符合条件的连续子数组，返回 0。*/
	
		    public int minSubArrayLen(int s,int nums[]) {
		        int i = 0;
		        int j = 0;
		        int curSum = 0;
		        int minLength = nums.length + 1;
		        while (j < nums.length) {
		            if (curSum < s) {
		                curSum += nums[j];
		                j++;
		            }
		            /*while (curSum >= s)*/else {
		                minLength = Math.min(minLength, j - i);
		                curSum = curSum - nums[i];
		                i++;
		            }
		        }
	
		        if (minLength > nums.length) {
		            return 0;
		        }else {
		            return minLength;
		        }
		    }
		    //双指针,慢指针i和快指针j,
		    //基本思路,i和j从头开始,j往后移动,直到i到j的和cumSum大于s,记下i与j之间的长度,i向后移动一个,判断cumSum与s的大小,j继续后移判断,直到j>length
		    
		    /*
		      给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。

			说明：
			
			你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
		     * 
		     * */
		    
		    public int singleNumber(int nums[]) {
		    	
		        for (int i = 1; i < nums.length; i++) {
		        	
		        	 nums[0] = nums[i]^nums[0];
		        	 int num;
		        	 
		        }
		         return nums[0];
		    }
		    /**异或操作,交换律,a^b^c=a^c^b
		     * 			相同数异或为0
		     * 			n和0异或为n	
		     * 			不同数异或要计算,转换成二进制计算
		     * 
		     * **/
		    
		    /*给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。

				你可以假设数组是非空的，并且给定的数组总是存在众数。*/
		    public  int majorityElement(int[] nums)
			 {
			     int count=0;//计算当前的数字出现的次数
			     int mj=0;//当前判断的元素
			     for (int i = 0; i < nums.length; i++)
			     {
					if(count==0){//当次数为0时，则换下一判断元素
						mj=nums[i];
						count=1;
					}
					else if (nums[i]==mj) {
						count++;//当前元素等于判断元素，次数加一
					}
					else {
						count--;//不等于则次数减一
					}
				}
			     return mj;
			 }
		    //因为众数大于n/2的数量,所以count的计数留在众数的上面最多,即couunt每次抵消的数会超出总数,所以最后返回的就是多余的众数
		 
		    
		    /*给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。

		    示例:

		    输入: [1,2,3,4]
		    输出: [24,12,8,6]*/
		    public int []productExceptSelf(int nums[]) {
		   
		    	int len = nums.length;
		        int[] re = new int[len];
		        if(len == 0) return new int[]{0};
		        int help = 1;
		        for(int i = 0; i < len; i++){//re[i]代表前i-1项的乘积
		        	re[i] = help;
		        	help *= nums[i];
		     
		        }
		        help = 1;
		        for(int i = len-1; i >= 0; i--){//通过help来保证re[i]后面数字的乘积
		        	re[i] *= help;
		        	help *= nums[i];
		        }
		        
		       	return re;
				}
		    	//定义一个新数组存储原数组从前往后少当前坐标的成绩,例如re[0]=1,re[1]=re[0]*nums[0],re[2]=re[1]*nums[1]
		    	//这样re[length-1]就存储了前length-1项的乘积,。然后在从后往前乘,因为re数组保存的是前n-1项的乘积,。
		    
		    
		    /*给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

			说明：
			
			拆分时可以重复使用字典中的单词。
			你可以假设字典中没有重复的单词。
			示例 1：
			
			输入: s = "leetcode", wordDict = ["leet", "code"]
			输出: true
			解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。*/
		    
		    public boolean wordBreak(String s, List<String> wordDict) {
		        // 可以类比于背包问题
		        int n = s.length();
		        // memo[i] 表示 s 中以 i - 1 结尾的字符串是否可被 wordDict 拆分
		        boolean[] memo = new boolean[n + 1];
		        memo[0] = true;
		        for (int i = 1; i <= n; i++) {
		            for (int j = 0; j < i; j++) {
		                if (memo[j] && wordDict.contains(s.substring(j, i))) {//当j到i这个序列存在于字典中,且j之前的也是字典中的时候(通过tboolean数组判断判断)。
		                    memo[i] = true;
		                    break;
		                }
		            }
		        }
		        return memo[n];
		    }
		    /*
		     * 
		     * */
		    
		    /*给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。

		    返回 s 所有可能的分割方案。

		    示例:

		    输入: "aab"
		    输出:
		    [
		      ["aa","b"],
		      ["a","a","b"]*/
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
		    ////
		    /*
		     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

			案例:
			
			s = "leetcode"
			返回 0.
			
			s = "loveleetcode",
			返回 2.*/
		    public static int firstUniqChar(String s) {
		        int[] letter=new int[26];//存储各字符出现次数
		        for (char c:s.toCharArray())//第一次遍历
		            letter[c-'a']++;//将字符与最小ascall码字符a的差值设成数组
		        for (int i = 0; i <s.length() ; i++) {//第二次遍历
		            if(letter[s.charAt(i)-'a']==1) 
		            	return i;
		        }
		        return -1;//无解
		    }
		    
		    
		    /*编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。

		    不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。

		    你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。

		     

		    示例 1：

		    输入：["h","e","l","l","o"]
		    输出：["o","l","l","e","h"]*/
		    public void reverseString(char[] s) {
		        int i=0;
		        int j = s.length-1;
		        char temp;
		        while(i<=j)
		        {
		            temp=s[i];
		            s[i]=s[j];
		            s[j]=temp;
		            i++;
		            j--;
		        }
		    }
		    /*
		     * 给定一个整数数组，判断是否存在重复元素。

			如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
			
			示例 1:
			
			输入: [1,2,3,1]
			输出: true*/
		    public boolean containsDuplicate(int[] nums) {
		        //先排序，在遍历一次
		        //执行用时 : 8 ms, 在Contains Duplicate的Java提交中击败了88.65% 的用户
		        //内存消耗 : 46.2 MB, 在Contains Duplicate的Java提交中击败了80.21% 的用户
		        int len=nums.length;
		        Arrays.sort(nums);
		        if(len<=1)
		            return false;
			for(int i=0;i<len-1;i++)
				if(nums[i]==nums[i+1])//只要存在重复元素即可
		                             return true;
				return false;
		  }
		    
		    /**给定两个数组，编写一个函数来计算它们的交集。

		    示例 1:

		    输入: nums1 = [1,2,2,1], nums2 = [2,2]
		    输出: [2,2]*/
		    public int[] intersect(int[] nums1, int[] nums2) {
		        Arrays.sort(nums1);
		        Arrays.sort(nums2);
		        List<Integer> list = new ArrayList<>();
		        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
		            if (nums1[i] < nums2[j]) {
		                i++;
		            } else if (nums1[i] > nums2[j]) {
		                j++;
		            } else {
		                list.add(nums1[i]);
		                i++;
		                j++;
		            }
		        }
		        int[] res = new int[list.size()];
		        for (int i = 0; i < list.size(); i++) {
		            res[i] = list.get(i);
		        }
		        return res;
		    }
		    
		    /*假设按照升序排序的数组在预先未知的某个点上进行了旋转。

			( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
			
			编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
			
			示例 1:
			
			输入: nums = [2,5,6,0,0,1,2], target = 0
			输出: true
			
			*
			*下面的这种解法,感觉更可以解释为在升序+降序的数组找目标
			*/
		    public boolean search(int[] nums, int target) {
		        if (nums.length == 0) {
		            return false;
		        }
		        for (int i = 0; i < nums.length; i++) {
		            if (target == nums[i]) {
		                return true;
		            }
		            //由于是升序数组,故后面的数组肯定不能匹配taeget,故退出循环
		            if (target < nums[i]) {
		                break;
		            }
		            //到旋转点
		            if (i > 0 && nums[i] < nums[i - 1]) {
		                break;
		            }
		        }
		        for (int i = nums.length - 1; i >= 0; i--) {
		            if (target == nums[i]) {
		                return true;
		            }
		            //降序数组,同理
		            if (target>nums[i]) {
		                break;
		            }
		            //到旋转点
		            if (i<nums.length - 1&&nums[i]>nums[i+1]) {
		                break;
		            }
		        }
		        return false;
		    }
		    
		    
}