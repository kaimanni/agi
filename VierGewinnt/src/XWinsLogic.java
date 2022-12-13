import java.util.ArrayList;

public class XWinsLogic {
	
	private int boardColumns;
	private int boardRows;
	private int xWins;
	
	private Chip[][] board;

	public XWinsLogic() {
		this.boardRows = 6;
		this.boardColumns = 7;
		this.xWins = 4;
		board = new Chip[boardColumns][boardRows];
	}
	
	public XWinsLogic(int height, int width, int xWins) {
		this.boardRows = height;
		this.boardColumns = width;
		this.xWins = xWins;
		board = new Chip[boardColumns][boardRows];
	}

	private boolean checkValidColumn(int column) {
		if (column < 0 || column > boardColumns - 1)
			return false;
		return true;
	}
	
	private boolean checkValidRow(int row) {
		if (row < 0 || row > boardRows - 1)
			return false;
		return true;
	}
	
	private boolean checkOccupied(int column, int row) {
		var place = board[column][row];
		if (place != null)
			return true;
		return false;
	}

	private boolean checkFullColumn(int column) {
		return getColumnStack(column) >= boardRows;
	}

	private boolean checkWinAllDirections(int column, int row) {
		if (checkWin(column, row, 0, 1))
			return true;
		if (checkWin(column, row, 1, 0))
			return true;
		if (checkWin(column, row, 1, 1))
			return true;
		if (checkWin(column, row, 1, -1))
			return true;
		return false;
	}

	private boolean checkWin(int column, int row, int x_dir, int y_dir) {
		int start_column = column;
		int start_row = row;
		var first = board[column][row];
		while (true) {
			start_column -= x_dir;
			start_row -= y_dir;
			if (!checkNextChip(start_column, start_row, first))
				break;
		}
		for (int i = 0; i < xWins; i++) {
			start_column += x_dir;
			start_row += y_dir;
			if (!checkNextChip(start_column, start_row, first))
				return false;
		}
		return true;
	}
	
	private int getColumnStack(int column) {
		var column_list = board[column];
		for (int i = boardRows - 1; i >= 0; i--) {
			var place = column_list[i];
			if (place != null)
				return i + 1;
		}
		return 0;
	}

	private boolean checkNextChip(int column, int row, Chip first) {
		if (column < 0 || column > boardColumns - 1 || row > boardRows - 1 || row < 0)
			return false;
		var column_list = board[column];
		if (getColumnStack(column) <= row)
			return false;
		var chip = column_list[row];
		if (first != chip)
			return false;
		return true;
	}

	private boolean checkDraw() {
		for (int i = 0; i < boardColumns; i++) {
			for (int j = 0; j < boardRows; j++) {
				var place = board[i][j];
				if (place == null)
					return false;
			}
		}
		return true;
	}

	public Result throwChip(Chip chip, int column) {
		if (!checkValidColumn(column))
			return Result.INVALID;
		if (checkFullColumn(column))
			return Result.INVALID;
		int row = getColumnStack(column);
		board[column][row] = chip;
		if (checkWinAllDirections(column, row))
			return chip == Chip.RED ? Result.REDWIN : Result.YELLOWWIN;
		if (checkDraw())
			return Result.DRAW;
		return Result.NEXTMOVE;
	}
	
	public Result setChip(Chip chip, int column, int row) {
		if (!checkValidColumn(column))
			return Result.INVALID;
		if (!checkValidRow(row))
			return Result.INVALID;
		if (checkOccupied(column, row))
			return Result.INVALID;
		board[column][row] = chip;
		if (checkWinAllDirections(column, row))
			return chip == Chip.RED ? Result.REDWIN : Result.YELLOWWIN;
		if (checkDraw())
			return Result.DRAW;
		return Result.NEXTMOVE;
	}
	
}
