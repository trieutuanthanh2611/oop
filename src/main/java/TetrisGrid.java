public class TetrisGrid {
	private boolean[][] grid;

	/**
	 * Constructs a new instance with the given grid.
	 * Does not make a copy.
	 */
	public TetrisGrid(boolean[][] grid) {
		this.grid = grid;
	}

	/**
	 * Does row-clearing on the grid.
	 */
	public void clearRows() {
		int height = grid[0].length;
		int width = grid.length;

		int writeRow = 0;
		for (int readRow = 0; readRow < height; readRow++) {
			boolean full = true;
			for (int x = 0; x < width; x++) {
				if (!grid[x][readRow]) {
					full = false;
					break;
				}
			}
			if (!full) {
				for (int x = 0; x < width; x++) {
					grid[x][writeRow] = grid[x][readRow];
				}
				writeRow++;
			}
		}

		for (int y = writeRow; y < height; y++) {
			for (int x = 0; x < width; x++) {
				grid[x][y] = false;
			}
		}
	}

	/**
	 * Returns the internal 2d grid array.
	 */
	boolean[][] getGrid() {
		return grid;
	}
}
