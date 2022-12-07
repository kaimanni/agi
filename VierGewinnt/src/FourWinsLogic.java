import java.util.ArrayList;

public class FourWinsLogic {
	
	private ArrayList<ArrayList<Chip>> board = new ArrayList<>();
	
	public FourWinsLogic() {
		for (int i = 0; i < 7; i++) {
			var column = new ArrayList<Chip>();
			board.add(column);
		}
	}
	
	private boolean checkValidColumn(int column) {
		if (column < 0 || column > 6)
			return false;
		return true;
	}
	
	private boolean checkFullColumn(int column) {
		if (board.get(column).size() > 5)
			return false;
		return true;
	}
	
	private boolean checkWinAllDirections(int column) {
		int row = board.get(column).size() - 1;
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
		var first = board.get(column).get(row);
		while (true) {
			if (start_column - x_dir < 0 || start_row - y_dir < 0 || start_row - y_dir > 5)
				break;
			var column_list = board.get(start_column - x_dir);
			if (column_list.size() <= start_row - y_dir)
				break;
			var chip = column_list.get(start_row - y_dir);
			if (chip != first)
				break;
			start_column -= x_dir;
			start_row -= y_dir;
		}
		for (int i = 0; i < 3; i++) {
			start_column += x_dir;
			start_row += y_dir;
			if (start_column > 6 || start_row > 5 || start_row < 0)
				return false;
			var column_list = board.get(start_column);
			if (column_list.size() <= start_row)
				return false;
			var chip = column_list.get(start_row);
			if (first != chip)
				return false;
		}
		return true;
	}
	
	private boolean checkDraw() {
		for (int i = 0; i < 7; i++) {
			if (board.get(i).size() < 6)
				return false;
		}
		return true;
	}

	public Result throwChip(Chip chip, int column) {
		if (!checkValidColumn(column))
			return Result.INVALID;
		if (!checkFullColumn(column))
			return Result.INVALID;
		board.get(column).add(chip);
		if (checkWinAllDirections(column))
			return chip == Chip.RED ? Result.REDWIN : Result.YELLOWWIN;
		if (checkDraw())
			return Result.DRAW;
		return Result.NEXTMOVE;
	}
}
