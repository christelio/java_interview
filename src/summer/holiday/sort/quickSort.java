package summer.holiday.sort;

public class quickSort {
	//随机元素结点选取的快排
	public static void quickSortR(int[] arr, int l, int r) {

		if (l < r) {
			swap(arr, l + (int) Math.random() * (r - l + 1), r);
			int temp[] = partition(arr, l, r);
			quickSortR(arr, l, temp[0]);
			quickSortR(arr, temp[1], r);
		}
	}

	public static int[] partition(int[] arr, int l, int r) {
		int less = l - 1;// 小于的扩张区域
		int more = r;
		while (l < more) {
			if (arr[l] < arr[r])
				swap(arr, ++less, l++);
			else if (arr[l] > arr[r])
				swap(arr, --more, l);
			else
				l++;
		}
		swap(arr, more, r);
		return new int[] { less, more + 1 };
	}

	// 交换数组元素
	public static void swap(int[] arr, int l, int r) {
		int temp = arr[l];
		arr[l] = arr[r];
		arr[r] = temp;
	}

	public static void main(String[] args) {
		int a[] = new int[] { 1, 9, 8, 6, 3, 6, 5, 7 };
		quickSortR(a, 0, a.length - 1);

	}

}
