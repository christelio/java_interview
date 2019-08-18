package summer.holiday.array;

public class arrayMaxHeap {

	public static int[] heapSort(int[] arr) {

		/*
		 * // 1.构建大顶堆 基于调整大根堆的思路 for (int i = arr.length / 2 - 1; i >= 0; i--) { //
		 * 从第一个非叶子结点从下至上，从右至左调整结构 headFy(arr, i, arr.length); }
		 */
		// 1.基于堆的插入初始化大根堆
		for (int j = 0; j < arr.length; j++) {
			heapInsert(arr, j);
		}
		// 2.调整堆结构+交换堆顶元素与末尾元素
		for (int j = arr.length - 1; j > 0; j--) {
			swap(arr, 0, j);// 将堆顶元素与末尾元素进行交换
			headFy(arr, 0, j);// 重新对堆进行调整
		}
		return arr;
	}

	/* 插入建立大根堆 */
	public static void heapInsert(int[] arr, int index) {
		while (arr[index] > arr[(index - 1) / 2])

		{
			swap(arr, index, (index - 1) / 2);
			index = (index - 1) / 2;
		}
	}

	/**
	 * 调整大顶堆（仅是调整过程，建立在大顶堆已构建的基础上）
	 * 
	 * @param arr
	 * @param i
	 * @param heapSize
	 */
	public static void headFy(int[] arr, int i, int heapSize) {
		for (int k = i * 2 + 1; k < heapSize; k = k * 2 + 1) {// 从i结点的左子结点开始，也就是2i+1处开始
			if (k + 1 < heapSize && arr[k] < arr[k + 1]) {// 如果左子结点小于右子结点，k指向右子结点
				k++;
			}
			if (arr[k] > arr[i]) {// 如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
				swap(arr, i, k);
				i = k;
			} else {
				break;
			}
		}

	}

	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static void main(String[] args) {
		int nums[] = { 1, 9, 5, 6, 8, 3, 2, 4, 7, 13, 14, 15, 16, 18 };
		heapSort(nums);
		for (int i : nums)
			System.out.println(i);

	}
}
