package summer.holiday.sort;

import org.junit.Test;

public class Sort {
	// ֱ�Ӳ�������
	public void StraightInsertion(int[] arr) {
		int f, t;// fΪ������õ������ָ��,tΪδ����õ�ָ��
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
	//��������
	class Qksort {
		// Ѱ���м�ֵ
		public int partition(int[] arr, int left, int right) {
			int temp = arr[left];// temp��ѡȡֵ
			while (left < right) {
				// �����ߵĿ�
				while (left < right && arr[right] >= temp) {
					--right;
				}
				if (left < right) {
					arr[left] = arr[right];
					++left;
				}
				// Ȼ����ұߵĿ�
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

		// ���ŵĵݹ�
		public void quickSort(int[] arr, int left, int right) {
			if (arr == null || left >=right || arr.length <=1)
				return;
			int mid = partition(arr, left, right);
			quickSort(arr, left, mid);
			quickSort(arr, mid + 1, right);

		}
	}
	//ð������
	public  void bubbleSort1(int[] a, int n) {
		int i, j;

		for (i = 0; i < n; i++) {// ��ʾn��������̡�
			for (j = 1; j < n - i; j++) {
				if (a[j - 1] > a[j]) {// ǰ������ִ��ں�������־ͽ���
					// ����a[j-1]��a[j]
					int temp;
					temp = a[j - 1];
					a[j - 1] = a[j];
					a[j] = temp;
				}
			}
		}
	}

	// ���ַ�����
	public static int biSearch(int[] array, int a) {
		int lo = 0;
		int hi = array.length - 1;
		int mid;
		while (lo <= hi) {
			mid = (lo + hi) / 2;// �м�λ��
			if (array[mid] == a) {
				return mid + 1;
			} else if (array[mid] < a) { // ���Ҳ���
				lo = mid + 1;
			} else { // �������
				hi = mid - 1;
			}
		}
		return -1;
	}
		
		
		
		
		
		
		
		
		
		
		
		
	@Test
	public void demo()
	{
		Qksort a=new Qksort();
		int[] arr = {6, 4, 3, 2, 7, 9, 1, 8, 5};
		a.quickSort(arr,0,arr.length-1);
	//	System.out.print(arr);
		
	}
	

}
