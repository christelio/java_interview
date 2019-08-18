package summer.hoilday.macro;

public class orderToPrint {
	/*
	 * 
	 * Ðý×ª´òÓ¡¾ØÕó
	 */
	public static void print(int arr[][]) {
		if (arr.length == 0)
			return;
		int row1 = 0;
		int row2 = arr.length - 1;
		int col1 = 0;
		int col2 = arr[0].length - 1;
		recursion(arr, row1, row2, col1, col2);

	}

	public static void recursion(int arr[][], int row1, int row2, int col1, int col2) {

		if (row1 > row2 || col1 > col2) {
			return;
		}

		if (row1 == row2) {
			while (col1 != col2 + 1)
				System.out.print(arr[row1][col1++] + ",");
			return;
		} else if (col1 == col2) {
			while (row1 != row2 + 1)
				System.out.print(arr[row1++][col1] + ",");
			return;
		} else {
			int tempRow = row1;
			int tempCol = col1;
			while (col1 != col2) {
				System.out.print(arr[row1][col1++] + ",");
			}
			while (row1 != row2) {
				System.out.print(arr[row1++][col1] + ",");
			}
			while (col2 != tempCol) {
				System.out.print(arr[row2][col2--] + ",");
			}
			while (row2 != tempRow) {
				System.out.print(arr[row2--][col2] + ",");
			}
			recursion(arr, tempRow + 1, row1 - 1, tempCol + 1, col1 - 1);
		}
	}

	public static void main(String[] args) {
		int arr[][] = new int[][] { { 1, 2, 3 }, { 1, 2, 3 }, { 1, 2, 3 } };
		print(arr);
	}
}
