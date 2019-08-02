package summer.holiday.sort;

import org.junit.Test;

public class Sort {
	// 直接插入排序
	public void StraightInsertion(int[] arr) {
		int f, t;// f为已排序好的数组的指针,t为未排序好的指针
		int insertNote = 0;
		for (t = 1; t < arr.length; t++) {
			insertNote = arr[t];
			f = t - 1;
			for (; f >= 0 && insertNote < arr[f]; f--) {
				arr[f + 1] = arr[f];
			}
			arr[f + 1] = insertNote;
		}
	}
	//快速排序
	class Qksort {
		// 寻找中间值
		public int partition(int[] arr, int left, int right) {
			int temp = arr[left];// temp是选取值
			while (left < right) {
				// 先填补左边的坑
				while (left < right && arr[right] >= temp) {
					--right;
				}
				if (left < right) {
					arr[left] = arr[right];
					++left;
				}
				// 然后填补右边的坑
				while (left < right && arr[left] <=temp) {
					++left;
				}
				if (left < right) {
					arr[right] = arr[left];
					--right;
				}
			}
			arr[left] = temp;
			return left;//
		}

		// 快排的递归
		public void quickSort(int[] arr, int left, int right) {
			if (arr == null || left >=right || arr.length <=1)
				return;
			int mid = partition(arr, left, right);
			quickSort(arr, left, mid);
			quickSort(arr, mid + 1, right);

		}
	}
	//冒泡排序
	public  void bubbleSort1(int[] a, int n) {
		int i, j;

		for (i = 0; i < n; i++) {// 表示n次排序过程。
			for (j = 1; j < n - i; j++) {
				if (a[j - 1] > a[j]) {// 前面的数字大于后面的数字就交换
					// 交换a[j-1]和a[j]
					int temp;
					temp = a[j - 1];
					a[j - 1] = a[j];
					a[j] = temp;
				}
			}
		}
	}

	// 二分法排序
	public static int biSearch(int[] array, int a) {
		int lo = 0;
		int hi = array.length - 1;
		int mid;
		while (lo <= hi) {
			mid = (lo + hi) / 2;// 中间位置
			if (array[mid] == a) {
				return mid + 1;
			} else if (array[mid] < a) { // 向右查找
				lo = mid + 1;
			} else { // 向左查找
				hi = mid - 1;
			}
		}
		return -1;
	}
		
		//归并排序的递归
	public  void sort(int[] arr, int L, int R) {
	    if(L == R) {
	        return;
	    }
	    int mid = L + ((R - L) /2);
	    sort(arr, L, mid);
	    sort(arr, mid + 1, R);
	    merge(arr, L, mid, R);
	}

	public  void merge(int[] arr, int L, int mid, int R) {
	    int[] temp = new int[R - L + 1];
	    int i = 0;
	    int p1 = L;
	    int p2 = mid + 1;
	    // 比较左右两部分的元素，哪个小，把那个元素填入temp中
	    while(p1 <= mid && p2 <= R) {
	        temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
	    }
	    // 上面的循环退出后，把剩余的元素依次填入到temp中
	    // 以下两个while只有一个会执行
	    while(p1 <= mid) {
	        temp[i++] = arr[p1++];
	    }
	    while(p2 <= R) {
	        temp[i++] = arr[p2++];
	    }
	    // 把最终的排序的结果复制给原数组
	    for(i = 0; i < temp.length; i++) {
	        arr[L + i] = temp[i];
	    }
	}
		
		
		
		
		
		
		
		
		
	public static void main(String[] args) {
		Sort demo = new Sort();
		int num[] = { 5, 4, 7, 8, 3, 8, 2, 1 };
		demo.sort(num, 0, 7);
		for (int i = 0; i < num.length; i++) {
			System.out.println(num[i]);

		}

	}
	


}
