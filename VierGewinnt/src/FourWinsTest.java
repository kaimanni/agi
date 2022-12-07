import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FourWinsTest {

	@Test
	void firstMoveLeftRed() {
		var logic = new FourWinsLogic();
		assertEquals(Result.NEXTMOVE, logic.throwChip(Chip.RED, 0));
	}
	
	@Test
	void firstMoveLeftYellow() {
		var logic = new FourWinsLogic();
		assertEquals(Result.NEXTMOVE, logic.throwChip(Chip.YELLOW, 0));
	}
	
	@Test
	void firstMoveRightRed() {
		var logic = new FourWinsLogic();
		assertEquals(Result.NEXTMOVE, logic.throwChip(Chip.RED, 6));
	}
	
	@Test
	void firstMoveRightYellow() {
		var logic = new FourWinsLogic();
		assertEquals(Result.NEXTMOVE, logic.throwChip(Chip.YELLOW, 6));
	}
	
	@Test
	void secondMoveHorizontal() {
		var logic = new FourWinsLogic();
		logic.throwChip(Chip.YELLOW, 0);
		assertEquals(Result.NEXTMOVE, logic.throwChip(Chip.RED, 1));
	}
	
	@Test
	void invalidColumn1() {
		var logic = new FourWinsLogic();
		assertEquals(Result.INVALID, logic.throwChip(Chip.YELLOW, -1));
	}
	
	@Test
	void invalidColumn2() {
		var logic = new FourWinsLogic();
		assertEquals(Result.INVALID, logic.throwChip(Chip.YELLOW, 7));
	}
	
	@Test
	void fullColumn() {
		var logic = new FourWinsLogic();
		logic.throwChip(Chip.YELLOW, 0);
		logic.throwChip(Chip.YELLOW, 0);
		logic.throwChip(Chip.YELLOW, 0);
		logic.throwChip(Chip.YELLOW, 0);
		logic.throwChip(Chip.YELLOW, 0);
		logic.throwChip(Chip.YELLOW, 0);
		assertEquals(Result.INVALID, logic.throwChip(Chip.YELLOW, 0));
	}
	
	@Test
	void redWinVertical() {
		var logic = new FourWinsLogic();
		logic.throwChip(Chip.RED, 0);
		logic.throwChip(Chip.RED, 0);
		logic.throwChip(Chip.RED, 0);
		assertEquals(Result.REDWIN, logic.throwChip(Chip.RED, 0));
	}
	
	@Test
	void yellowNoWinVertical1() {
		var logic = new FourWinsLogic();
		logic.throwChip(Chip.YELLOW, 0);
		logic.throwChip(Chip.YELLOW, 0);
		assertEquals(Result.NEXTMOVE, logic.throwChip(Chip.YELLOW, 0));
	}
	
	@Test
	void yellowNoWinVertical2() {
		var logic = new FourWinsLogic();
		logic.throwChip(Chip.YELLOW, 0);
		logic.throwChip(Chip.YELLOW, 0);
		logic.throwChip(Chip.RED, 0);
		assertEquals(Result.NEXTMOVE, logic.throwChip(Chip.YELLOW, 0));
	}
	
	@Test
	void yellowNoWinVertical() {
		var logic = new FourWinsLogic();
		logic.throwChip(Chip.YELLOW, 0);
		logic.throwChip(Chip.YELLOW, 0);
		logic.throwChip(Chip.YELLOW, 0);
		assertEquals(Result.YELLOWWIN, logic.throwChip(Chip.YELLOW, 0));
	}
	
	@Test
	void yellowNoWinHorizontal1() {
		var logic = new FourWinsLogic();
		logic.throwChip(Chip.YELLOW, 1);
		logic.throwChip(Chip.YELLOW, 2);
		assertEquals(Result.NEXTMOVE, logic.throwChip(Chip.YELLOW, 0));
	}
	
	@Test
	void yellowDoesntWinHorizontal2() {
		var logic = new FourWinsLogic();
		logic.throwChip(Chip.RED, 1);
		logic.throwChip(Chip.YELLOW, 0);
		logic.throwChip(Chip.YELLOW, 2);
		assertEquals(Result.NEXTMOVE, logic.throwChip(Chip.YELLOW, 3));
	}
	
	@Test
	void yellowWinHorizontalStart() {
		var logic = new FourWinsLogic();
		logic.throwChip(Chip.YELLOW, 3);
		logic.throwChip(Chip.YELLOW, 1);
		logic.throwChip(Chip.YELLOW, 2);
		assertEquals(Result.YELLOWWIN, logic.throwChip(Chip.YELLOW, 0));
	}
	
	@Test
	void yellowWinHorizontalEnd() {
		var logic = new FourWinsLogic();
		logic.throwChip(Chip.YELLOW, 0);
		logic.throwChip(Chip.YELLOW, 1);
		logic.throwChip(Chip.YELLOW, 2);
		assertEquals(Result.YELLOWWIN, logic.throwChip(Chip.YELLOW, 3));
	}
	
	@Test
	void yellowWinHorizontalMiddle() {
		var logic = new FourWinsLogic();
		logic.throwChip(Chip.YELLOW, 0);
		logic.throwChip(Chip.YELLOW, 1);
		logic.throwChip(Chip.YELLOW, 3);
		assertEquals(Result.YELLOWWIN, logic.throwChip(Chip.YELLOW, 2));
	}
	
	@Test
	void yellowWinDiagonalLeftToRight() {
		var logic = new FourWinsLogic();
		logic.throwChip(Chip.YELLOW, 0);
		logic.throwChip(Chip.RED, 1);
		logic.throwChip(Chip.YELLOW, 1);
		logic.throwChip(Chip.RED, 2);
		logic.throwChip(Chip.RED, 2);
		logic.throwChip(Chip.RED, 3);
		logic.throwChip(Chip.RED, 3);
		logic.throwChip(Chip.RED, 3);
		logic.throwChip(Chip.YELLOW, 3);
		assertEquals(Result.YELLOWWIN, logic.throwChip(Chip.YELLOW, 2));
	}
	
	@Test
	void yellowWinDiagonalRightToLeft() {
		var logic = new FourWinsLogic();
		logic.throwChip(Chip.RED, 5);
		logic.throwChip(Chip.YELLOW, 5);
		logic.throwChip(Chip.RED, 4);
		logic.throwChip(Chip.RED, 4);
		logic.throwChip(Chip.RED, 3);
		logic.throwChip(Chip.RED, 3);
		logic.throwChip(Chip.RED, 3);
		logic.throwChip(Chip.YELLOW, 3);
		logic.throwChip(Chip.YELLOW, 4);
		assertEquals(Result.YELLOWWIN, logic.throwChip(Chip.YELLOW, 6));
	}
	
	@Test
	void draw() {
		var logic = new FourWinsLogic();
		logic.throwChip(Chip.RED, 0);
		logic.throwChip(Chip.RED, 1);
		logic.throwChip(Chip.RED, 2);
		logic.throwChip(Chip.YELLOW, 3);
		logic.throwChip(Chip.RED, 4);
		logic.throwChip(Chip.RED, 5);
		logic.throwChip(Chip.RED, 6);
		logic.throwChip(Chip.YELLOW, 0);
		logic.throwChip(Chip.YELLOW, 1);
		logic.throwChip(Chip.YELLOW, 2);
		logic.throwChip(Chip.RED, 3);
		logic.throwChip(Chip.YELLOW, 4);
		logic.throwChip(Chip.YELLOW, 5);
		logic.throwChip(Chip.YELLOW, 6);
		logic.throwChip(Chip.RED, 0);
		logic.throwChip(Chip.RED, 1);
		logic.throwChip(Chip.RED, 2);
		logic.throwChip(Chip.YELLOW, 3);
		logic.throwChip(Chip.RED, 4);
		logic.throwChip(Chip.RED, 5);
		logic.throwChip(Chip.RED, 6);
		logic.throwChip(Chip.YELLOW, 0);
		logic.throwChip(Chip.YELLOW, 1);
		logic.throwChip(Chip.YELLOW, 2);
		logic.throwChip(Chip.RED, 3);
		logic.throwChip(Chip.YELLOW, 4);
		logic.throwChip(Chip.YELLOW, 5);
		logic.throwChip(Chip.YELLOW, 6);
		logic.throwChip(Chip.RED, 0);
		logic.throwChip(Chip.RED, 1);
		logic.throwChip(Chip.RED, 2);
		logic.throwChip(Chip.YELLOW, 3);
		logic.throwChip(Chip.RED, 4);
		logic.throwChip(Chip.RED, 5);
		logic.throwChip(Chip.RED, 6);
		logic.throwChip(Chip.YELLOW, 0);
		logic.throwChip(Chip.YELLOW, 1);
		logic.throwChip(Chip.YELLOW, 2);
		logic.throwChip(Chip.RED, 3);
		logic.throwChip(Chip.YELLOW, 4);
		logic.throwChip(Chip.YELLOW, 5);
		assertEquals(Result.DRAW, logic.throwChip(Chip.YELLOW, 6));
	}

}
