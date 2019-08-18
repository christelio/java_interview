package summer.holiday.sort;

public class mergeSort {
	class Sort {
		public void sort(int[] arr, int L, int R) {
			// 递归终点
			if (L == R) {
				return;
			}
			// 分解的子问题
			int mid = L + ((R - L) / 2);
			sort(arr, L, mid);
			sort(arr, mid + 1, R);
			merge(arr, L, mid, R);
		}

		public void merge(int[] arr, int L, int mid, int R) {
			int[] temp = new int[R - L + 1];
			int i = 0;
			int p1 = L;
			int p2 = mid + 1;
			// 比较左右两部分的元素，哪个小，把那个元素填入temp中
			while (p1 <= mid && p2 <= R) {
				temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
			}
			// 上面的循环退出后，把剩余的元素依次填入到temp中
			// 以下两个while只有一个会执行
			while (p1 <= mid) {
				temp[i++] = arr[p1++];
			}
			while (p2 <= R) {
				temp[i++] = arr[p2++];
			}
			// 把最终的排序的结果复制给原数组
			for (i = 0; i < temp.length; i++) {
				arr[L + i] = temp[i];
			}
		}

	}

	static int sum;

	// 最小和
	public void sort(int[] arr, int L, int R) {
		// 递归终点
		if (L == R) {
			return;
		}
		// 分解的子问题
		int mid = L + ((R - L) / 2);
		sort(arr, L, mid);
		sort(arr, mid + 1, R);
		merge(arr, L, mid, R);
	}

	public void merge(int[] arr, int L, int mid, int R) {
		int[] temp = new int[R - L + 1];
		int i = 0;
		int p1 = L;
		int p2 = mid + 1;
		// 比较左右两部分的元素，哪个小，把那个元素填入temp中
		while (p1 <= mid && p2 <= R) {
			// 最小和就改变了这个地方
			if (arr[p1] < arr[p2]) {
				temp[i++] = arr[p1];
				sum += (R - p2 + 1) * arr[p1];
				p1++;
			} else {
				temp[i++] = arr[p2++];
			}
			// temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		// 上面的循环退出后，把剩余的元素依次填入到temp中
		// 以下两个while只有一个会执行
		while (p1 <= mid) {
			temp[i++] = arr[p1++];
		}
		while (p2 <= R) {
			temp[i++] = arr[p2++];
		}
		// 把最终的排序的结果复制给原数组
		for (i = 0; i < temp.length; i++) {
			arr[L + i] = temp[i];
		}
	}

	public static void main(String[] args) {
		int a[] = { 1, 5, 9, 8, 4 };
		mergeSort demo = new mergeSort();
		demo.sort(a, 0, a.length - 1);
		for (int i : a) {
			System.out.println(i);
		}
		System.out.println(sum);

	}

}
