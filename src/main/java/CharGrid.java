// HW1 2-d array Problems
// CharGrid encapsulates a 2-d grid of chars and supports
// a few operations on the grid.

public class CharGrid {
	private char[][] grid;

	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public CharGrid(char[][] grid) {
		this.grid = grid;
	}

	/**
	 * Returns the area for the given char in the grid. (see handout).
	 * @param ch char to look for
	 * @return area for given char
	 */
	public int charArea(char ch) {
		int minRow = grid.length, minCol = grid[0].length;
		int maxRow = -1, maxCol = -1;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == ch) {
					if (i < minRow) minRow = i;
					if (j < minCol) minCol = j;
					if (i > maxRow) maxRow = i;
					if (j > maxCol) maxCol = j;
				}
			}
		}

		if (maxRow == -1) return 0;

		return (maxRow - minRow + 1) * (maxCol - minCol + 1);
	}

	/**
	 * Returns the count of '+' figures in the grid (see handout).
	 * @return number of + in grid
	 */
	public int countPlus() {
		int count = 0;
		int rows = grid.length;
		int cols = grid[0].length;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == '+') {
					int up = armLength(i, j, -1, 0);
					int down = armLength(i, j, 1, 0);
					int left = armLength(i, j, 0, -1);
					int right = armLength(i, j, 0, 1);

					if (up > 0 && up == down && up == left && up == right) {
						count++;
					}
				}
			}
		}

		return count;
	}

	private int armLength(int row, int col, int dRow, int dCol) {
		int length = 0;
		int r = row + dRow;
		int c = col + dCol;
		while (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == '+') {
			length++;
			r += dRow;
			c += dCol;
		}
		return length;
	}
}
