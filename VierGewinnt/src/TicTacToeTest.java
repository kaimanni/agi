import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TicTacToeTest {

	@Test
	void firstSetRed() {
		var logic = new XWinsLogic(3, 3, 3);
		assertEquals(Result.NEXTMOVE, logic.setChip(Chip.RED, 1, 1));
	}
	
	@Test
	void firstSetYellow() {
		var logic = new XWinsLogic(3, 3, 3);
		assertEquals(Result.NEXTMOVE, logic.setChip(Chip.YELLOW, 1, 1));
	}
	
	@Test
	void invalidColumn1() {
		var logic = new XWinsLogic(3, 3, 3);
		assertEquals(Result.INVALID, logic.setChip(Chip.YELLOW, -1, 1));
	}
	
	@Test
	void invalidColumn2() {
		var logic = new XWinsLogic(3, 3, 3);
		assertEquals(Result.INVALID, logic.setChip(Chip.YELLOW, 3, 1));
	}
	
	@Test
	void invalidRow1() {
		var logic = new XWinsLogic(3, 3, 3);
		assertEquals(Result.INVALID, logic.setChip(Chip.YELLOW, 1, -1));
	}
	
	@Test
	void invalidRow2() {
		var logic = new XWinsLogic(3, 3, 3);
		assertEquals(Result.INVALID, logic.setChip(Chip.YELLOW, 1, 3));
	}
	
	@Test
	void occupiedSet() {
		var logic = new XWinsLogic(3, 3, 3);
		logic.setChip(Chip.YELLOW, 1, 1);
		assertEquals(Result.INVALID, logic.setChip(Chip.RED, 1, 1));
	}
	
	@Test
	void draw() {
		var logic = new XWinsLogic(3, 3, 3);
		logic.setChip(Chip.YELLOW, 0, 0);
		logic.setChip(Chip.YELLOW, 0, 1);
		logic.setChip(Chip.YELLOW, 1, 2);
		logic.setChip(Chip.YELLOW, 2, 0);
		logic.setChip(Chip.YELLOW, 2, 1);
		logic.setChip(Chip.RED, 0, 2);
		logic.setChip(Chip.RED, 1, 0);
		logic.setChip(Chip.RED, 1, 1);
		assertEquals(Result.DRAW, logic.setChip(Chip.RED, 2, 2));
	}
	
	@Test
	void falseDraw() {
		var logic = new XWinsLogic(3, 3, 3);
		logic.setChip(Chip.YELLOW, 1, 2);
		logic.setChip(Chip.RED, 0, 2);
		assertEquals(Result.NEXTMOVE, logic.setChip(Chip.RED, 2, 2));
	}

	@Test
	void yellowHorizontalWin() {
		var logic = new XWinsLogic(3, 3, 3);
		logic.setChip(Chip.YELLOW, 0, 0);
		logic.setChip(Chip.YELLOW, 1, 0);
		assertEquals(Result.YELLOWWIN, logic.setChip(Chip.YELLOW, 2, 0));
	}

	@Test
	void redHorizontalWin() {
		var logic = new XWinsLogic(3, 3, 3);
		logic.setChip(Chip.RED, 0, 0);
		logic.setChip(Chip.RED, 1, 0);
		assertEquals(Result.REDWIN, logic.setChip(Chip.RED, 2, 0));
	}
	
	@Test
	void yellowHorizontalWin2() {
		var logic = new XWinsLogic(3, 3, 3);
		logic.setChip(Chip.RED, 2, 2);
		logic.setChip(Chip.YELLOW, 0, 0);
		logic.setChip(Chip.YELLOW, 1, 0);
		assertEquals(Result.YELLOWWIN, logic.setChip(Chip.YELLOW, 2, 0));
	}

	@Test
	void yellowVerticalWin() {
		var logic = new XWinsLogic(3, 3, 3);
		logic.setChip(Chip.YELLOW, 1, 0);
		logic.setChip(Chip.YELLOW, 1, 1);
		assertEquals(Result.YELLOWWIN, logic.setChip(Chip.YELLOW, 1, 2));
	}

	@Test
	void redVerticalWin() {
		var logic = new XWinsLogic(3, 3, 3);
		logic.setChip(Chip.RED, 1, 0);
		logic.setChip(Chip.RED, 1, 1);
		assertEquals(Result.REDWIN, logic.setChip(Chip.RED, 1, 2));
	}

	@Test
	void yellowDiagonalWin() {
		var logic = new XWinsLogic(3, 3, 3);
		logic.setChip(Chip.YELLOW, 0, 0);
		logic.setChip(Chip.YELLOW, 1, 1);
		assertEquals(Result.YELLOWWIN, logic.setChip(Chip.YELLOW, 2, 2));
	}

	@Test
	void redDiagonalWin() {
		var logic = new XWinsLogic(3, 3, 3);
		logic.setChip(Chip.RED, 0, 0);
		logic.setChip(Chip.RED, 1, 1);
		assertEquals(Result.REDWIN, logic.setChip(Chip.RED, 2, 2));
	}
	
	@Test
	void yellowDiagonalWin2() {
		var logic = new XWinsLogic(3, 3, 3);
		logic.setChip(Chip.YELLOW, 2, 0);
		logic.setChip(Chip.YELLOW, 1, 1);
		assertEquals(Result.YELLOWWIN, logic.setChip(Chip.YELLOW, 0, 2));
	}

	@Test
	void redDiagonalWin2() {
		var logic = new XWinsLogic(3, 3, 3);
		logic.setChip(Chip.RED, 2, 0);
		logic.setChip(Chip.RED, 1, 1);
		assertEquals(Result.REDWIN, logic.setChip(Chip.RED, 0, 2));
	}

}
