package sudoku;

public class Cell {
    public int row, col;

    /**
     * Constructs a new Cell with the specified row and column position.
     * 
     * @param row the row index of the cell
     * @param col the column index of the cell
     */
    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
