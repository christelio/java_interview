package summer.holiday.array;

public class arrayMaxHeap {
	
	public static int findMax(int[] arr, int k) {
		// 1.�����󶥶�
		for (int i = arr.length / 2 - 1; i >= 0; i--) {
			// �ӵ�һ����Ҷ�ӽ��������ϣ�������������ṹ
			adjustHeap(arr, i, arr.length);
		}
		// 2.�����ѽṹ+�����Ѷ�Ԫ����ĩβԪ��
		for (int j = arr.length - 1; j > 0; j--) {
			swap(arr, 0, j);// ���Ѷ�Ԫ����ĩβԪ�ؽ��н���
			adjustHeap(arr, 0, j);// ���¶Զѽ��е���
		}
		return arr[arr.length - k];
	}

	/**
	 * �����󶥶ѣ����ǵ������̣������ڴ󶥶��ѹ����Ļ����ϣ�
	 * 
	 * @param arr
	 * @param i
	 * @param length
	 */
	public static void adjustHeap(int[] arr, int i, int length) {
		int temp = arr[i];// ��ȡ����ǰԪ��i
		for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {// ��i�������ӽ�㿪ʼ��Ҳ����2i+1����ʼ
			if (k + 1 < length && arr[k] < arr[k + 1]) {// ������ӽ��С�����ӽ�㣬kָ�����ӽ��
				k++;
			}
			if (arr[k] > temp) {// ����ӽڵ���ڸ��ڵ㣬���ӽڵ�ֵ�������ڵ㣨���ý��н�����
				arr[i] = arr[k];
				i = k;
			} else {
				System.out.println("a");
				break;
			}
		}
		arr[i] = temp;// ��tempֵ�ŵ����յ�λ��
	}

	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	public static void main(String[] args)
	{
		int nums[]= {1,9,5,6,8,3,2,4,7,13,14,15,16,18};
		findMax(nums, 3);
		
}
}
