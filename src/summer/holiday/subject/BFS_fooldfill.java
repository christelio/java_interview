package summer.holiday.subject;

import java.util.LinkedList;
import java.util.Queue;

public class BFS_fooldfill {
	/*
	 * 给定一个由 '1'（陆地）和
	 * '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
	 * 
	 * 示例 1:
	 * 
	 * 输入: 11110 11010 11000 00000
	 * 
	 * 输出: 1
	 * 
	 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/number-of-islands
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	boolean[][] visited = null;
	public int numlslands(char[][] grid) {

		if (grid.length == 0) {
			return 0;
		}
		int row = grid.length;
		int column = grid[0].length;
		int result = 0;
		visited = new boolean[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (grid[i][j] == '1' && !visited[i][j]) {
					result++;
					bfs(grid, i, j);// 每一次for循环都是一次fooldfill
				}
			}

		}
		return result;
	}

//类似的
	public void bfs(char[][] grid, int row, int column) {
		if (row >= 0 && row < grid.length && column >= 0 && column < grid[0].length) {
			if (!visited[row][column] && grid[row][column] == '1') {
				visited[row][column] = true;
				bfs(grid, row - 1, column);
				bfs(grid, row + 1, column);
				bfs(grid, row, column - 1);
				bfs(grid, row, column + 1);
			}
		}
	}

}
