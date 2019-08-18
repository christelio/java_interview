package summer.holiday.sort;

public class mergeSort {
	class Sort {
		public void sort(int[] arr, int L, int R) {
			// �ݹ��յ�
			if (L == R) {
				return;
			}
			// �ֽ��������
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
			// �Ƚ����������ֵ�Ԫ�أ��ĸ�С�����Ǹ�Ԫ������temp��
			while (p1 <= mid && p2 <= R) {
				temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
			}
			// �����ѭ���˳��󣬰�ʣ���Ԫ���������뵽temp��
			// ��������whileֻ��һ����ִ��
			while (p1 <= mid) {
				temp[i++] = arr[p1++];
			}
			while (p2 <= R) {
				temp[i++] = arr[p2++];
			}
			// �����յ�����Ľ�����Ƹ�ԭ����
			for (i = 0; i < temp.length; i++) {
				arr[L + i] = temp[i];
			}
		}

	}

	static int sum;

	// ��С��
	public void sort(int[] arr, int L, int R) {
		// �ݹ��յ�
		if (L == R) {
			return;
		}
		// �ֽ��������
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
		// �Ƚ����������ֵ�Ԫ�أ��ĸ�С�����Ǹ�Ԫ������temp��
		while (p1 <= mid && p2 <= R) {
			// ��С�;͸ı�������ط�
			if (arr[p1] < arr[p2]) {
				temp[i++] = arr[p1];
				sum += (R - p2 + 1) * arr[p1];
				p1++;
			} else {
				temp[i++] = arr[p2++];
			}
			// temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		// �����ѭ���˳��󣬰�ʣ���Ԫ���������뵽temp��
		// ��������whileֻ��һ����ִ��
		while (p1 <= mid) {
			temp[i++] = arr[p1++];
		}
		while (p2 <= R) {
			temp[i++] = arr[p2++];
		}
		// �����յ�����Ľ�����Ƹ�ԭ����
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
