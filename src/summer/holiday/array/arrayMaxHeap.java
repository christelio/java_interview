package summer.holiday.array;

public class arrayMaxHeap {

	public static int[] heapSort(int[] arr) {

		/*
		 * // 1.�����󶥶� ���ڵ�������ѵ�˼· for (int i = arr.length / 2 - 1; i >= 0; i--) { //
		 * �ӵ�һ����Ҷ�ӽ��������ϣ�������������ṹ headFy(arr, i, arr.length); }
		 */
		// 1.���ڶѵĲ����ʼ�������
		for (int j = 0; j < arr.length; j++) {
			heapInsert(arr, j);
		}
		// 2.�����ѽṹ+�����Ѷ�Ԫ����ĩβԪ��
		for (int j = arr.length - 1; j > 0; j--) {
			swap(arr, 0, j);// ���Ѷ�Ԫ����ĩβԪ�ؽ��н���
			headFy(arr, 0, j);// ���¶Զѽ��е���
		}
		return arr;
	}

	/* ���뽨������� */
	public static void heapInsert(int[] arr, int index) {
		while (arr[index] > arr[(index - 1) / 2])

		{
			swap(arr, index, (index - 1) / 2);
			index = (index - 1) / 2;
		}
	}

	/**
	 * �����󶥶ѣ����ǵ������̣������ڴ󶥶��ѹ����Ļ����ϣ�
	 * 
	 * @param arr
	 * @param i
	 * @param heapSize
	 */
	public static void headFy(int[] arr, int i, int heapSize) {
		for (int k = i * 2 + 1; k < heapSize; k = k * 2 + 1) {// ��i�������ӽ�㿪ʼ��Ҳ����2i+1����ʼ
			if (k + 1 < heapSize && arr[k] < arr[k + 1]) {// ������ӽ��С�����ӽ�㣬kָ�����ӽ��
				k++;
			}
			if (arr[k] > arr[i]) {// ����ӽڵ���ڸ��ڵ㣬���ӽڵ�ֵ�������ڵ㣨���ý��н�����
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
