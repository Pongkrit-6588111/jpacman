package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

/**
 * Test for verifying that a Board is correctly initialized.
 */
class BoardTest {

    @Test
    void testValidBoardCreation() {
        // Create a 1x1 grid of Squares
        Square[][] grid = new Square[1][1];
        grid[0][0] = new BasicSquare();

        Board board = new Board(grid);
        assertThat(board.getWidth()).isEqualTo(1);
        assertThat(board.getHeight()).isEqualTo(1);
        assertThat(board.squareAt(0, 0)).isEqualTo(grid[0][0]);
        assertThat(board.invariant()).isTrue();
    }
    @Test
    void testBoardWithNullSquare() {
        // Create a 2x1 grid with one null square
        Square[][] grid = new Square[2][1];
        grid[0][0] = new BasicSquare();
        grid[1][0] = null; // Introduce a null square

        // Board creation should fail due to invariant violation
        assertThatThrownBy(() -> new Board(grid))
            .isInstanceOf(AssertionError.class)
            .hasMessageContaining("Initial grid cannot contain null squares");
    }
}
