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
		
		//�鲢����ĵݹ�
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
	    // �Ƚ����������ֵ�Ԫ�أ��ĸ�С�����Ǹ�Ԫ������temp��
	    while(p1 <= mid && p2 <= R) {
	        temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
	    }
	    // �����ѭ���˳��󣬰�ʣ���Ԫ���������뵽temp��
	    // ��������whileֻ��һ����ִ��
	    while(p1 <= mid) {
	        temp[i++] = arr[p1++];
	    }
	    while(p2 <= R) {
	        temp[i++] = arr[p2++];
	    }
	    // �����յ�����Ľ�����Ƹ�ԭ����
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
