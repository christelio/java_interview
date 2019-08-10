package summer.holiday.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class array1 {
	/*
	 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
	 * 
	 * 
	 * 输入: [-2,0,-1] 输出: 0 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
	 */
	public int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;// 参数有效性

		int max = nums[nums.length - 1];// 节点状态最大值 这里不用数组，只需要保存上一个节点的最大值和最小值
		int min = nums[nums.length - 1];// 节点状态最小值
		int result = nums[nums.length - 1];// 最大节点值

		for (int i = nums.length - 2; i >= 0; i--) {// 直接从倒数第2个元素开始向前遍历
			if (nums[i] < 0) {// 判断当前元素正负 因为负数计算最大值要乘以上一个节点的最小值才行
				int temp = max;
				max = nums[i] > nums[i] * min ? nums[i] : nums[i] * min;
				min = nums[i] < nums[i] * temp ? nums[i] : nums[i] * temp;
			} else {
				max = nums[i] > nums[i] * max ? nums[i] : nums[i] * max;
				min = nums[i] < nums[i] * min ? nums[i] : nums[i] * min;
			}
			if (result < max)
				result = max;// 记录目前为止的最大值
		}
		return result;

	}

	/*
	 * 打乱一个没有重复元素的数组。
	 * 
	 * 示例:
	 * 
	 * // 以数字集合 1, 2 和 3 初始化数组。 int[] nums = {1,2,3}; Solution solution = new
	 * Solution(nums);
	 * 
	 * // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。 solution.shuffle();
	 * 
	 * // 重设数组到它的初始状态[1,2,3]。 solution.reset();
	 * 
	 * // 随机返回数组[1,2,3]打乱后的结果。 solution.shuffle();
	 */

	class riffle {
		private int[] array;
		private int[] original;
		Random rand = new Random();

		// 返回已选取后的区间中的一个随机下标
		private int randRange(int min, int max) {
			return rand.nextInt(max - min) + min;
		}

		// 交换
		private void swapA(int i, int j) {
			int temp = array[j];
			array[j] = array[i];
			array[i] = temp;
		}

		public riffle(int[] nums) {
			array = nums;
			original = nums;
		}

		// 重置数组
		public int[] rest() {
			array = original;
			original = original.clone();
			return original;
		}

		public int[] shuffle() {
			for (int i = 0; i < array.length; i++) {
				swapA(i, randRange(i, array.length));
			}
			return array;
		}

	}

	/*
	 * 给定两个数组，编写一个函数来计算它们的交集。
	 * 
	 * 示例 1:
	 * 
	 * 输入: nums1 = [1,2,2,1], nums2 = [2,2] 输出: [2,2] 示例 2:
	 * 
	 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4] 输出: [4,9]
	 */
	public int[] intersect(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i = 0, j = 0;
		List<Integer> list = new ArrayList<>(nums1.length);
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] == nums2[j]) {
				list.add(nums1[i]);
				i++;
				j++;
			} else if (nums1[i] > nums2[j]) {
				j++;
			} else {
				i++;
			}
		}
		Object[] a = list.toArray();
		int n = 0;
		int ans[] = new int[a.length];
		for (Object e : a) {
			ans[n++] = (int) e;
		}
		return ans;
	}
	/*
	 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
	 * 
	 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
	 * 
	 * 示例 1:
	 * 
	 * 输入: [3,2,3] 输出: 3
	 */

	public int majorityElement(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int count = 0;
		int mj = 0;
		int i = 0;
		while (i < nums.length) {
			if (count == 0) {
				mj = nums[i];
				count++;
			} else if (mj == nums[i]) {
				count++;
			} else {
				count--;
			}
			i++;
		}
		return mj;
	}

	/*
	 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
	 * 
	 * 示例 1:
	 * 
	 * 输入: [1,2,3,4,5,6,7] 和 k = 3 输出: [5,6,7,1,2,3,4] 解释: 向右旋转 1 步: [7,1,2,3,4,5,6]
	 * 向右旋转 2 步: [6,7,1,2,3,4,5] 向右旋转 3 步: [5,6,7,1,2,3,4]
	 */
	public void rotate(int[] nums, int k) {
		k = k % nums.length;
		int count = 0;
		for (int start = 0; count < nums.length; start++) {
			int current = start;
			int prev = nums[start];
			do {
				int next = (current + k) % nums.length;
				int temp = nums[next];
				nums[next] = prev;
				prev = temp;
				current = next;
				count++;
			} while (start != current);
		}
	}

	
	public void maxSlidingWindow() {
		int[] nums = { 9, 10, 9, 7, -4, 8, 2, 6 };
		int k = 5;
		int n = nums.length;
		// if (n * k == 0) return new int[0];
		// if (k == 1) return nums;

		int[] left = new int[n];
		left[0] = nums[0];
		int[] right = new int[n];
		right[n - 1] = nums[n - 1];
		for (int i = 1; i < n; i++) {
			// from left to right
			if (i % k == 0)
				left[i] = nums[i]; // block_start
			else
				left[i] = Math.max(left[i - 1], nums[i]);

			int j = n - i - 1;
			if ((j + 1) % k == 0) {
				right[j] = nums[j];

			}
			// block_end
			else
				right[j] = Math.max(right[j + 1], nums[j]);

			System.out.println(right[j]);
		}
		/*
		 * for(int i=n-2;i>=0;i--) { //System.out.println(i); if((i+1)%k==0) {
		 * right[i]=nums[i]; System.out.println(right[i]); } else
		 * right[i]=Math.max(right[i],right[i+1]); System.out.println(right[i]); }
		 */

		int[] output = new int[n - k + 1];
		for (int i = 0; i < n - k + 1; i++)
			output[i] = Math.max(left[i + k - 1], right[i]);

		// return output;
	}
	
	/*
	 * 给定一个未排序的数组，判断这个数组中是否存在长度为 3 的递增子序列。
	 * 
	 * 数学表达式如下:
	 * 
	 * 如果存在这样的 i, j, k, 且满足 0 ≤ i < j < k ≤ n-1， 使得 arr[i] < arr[j] < arr[k] ，返回
	 * true ; 否则返回 false 。 说明: 要求算法的时间复杂度为 O(n)，空间复杂度为 O(1) 。
	 * 
	 * 示例 1:
	 * 
	 * 输入: [1,9,3,7,5] 输出: true
	 */
	public boolean increasingTriplet(int[] nums) {
		if (nums == null || nums.length < 3)
			return false;
		int middle = Integer.MAX_VALUE, min = Integer.MAX_VALUE;
		for (int i : nums) {
			if (i <= min)
				min = i;
			else if (i <= middle)
				middle = i;
			else
				return true;
		}
		return false;
	}

	public static int kthSmallest(int[][] matrix, int k) {
		int row = matrix.length, col = matrix[0].length;
		int l = matrix[0][0], r = matrix[row - 1][col - 1];
		while (l <= r) {
			int mid = (r - l) / 2 + l;
			System.out.println(mid);
			int count = 0;
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col && matrix[i][j] <= mid; j++) {
					count++;
				}
			}
			if (count < k)
				l = mid + 1;
			else
				r = mid - 1;
			System.out.println(count+"aaa");
		}
	
		return l;
	}
	public static void main(String[] args)
	{
		int nums[][]= {{1,5,9},{2,6,11},{7,10,12}};
		System.out.println(kthSmallest(nums,4));
		System.out.println((87.363));
		
	}

}
