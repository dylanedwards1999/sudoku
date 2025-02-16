package sudoku;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Cell extends JLabel{
    private int row, col, value, blockID;

    /**
     * Constructs a new Cell with the specified row and column position.
     * 
     * @param row the row index of the cell
     * @param col the column index of the cell
     */
    public Cell(int row, int col, int blockID) {
        this.row = row;
        this.col = col;
        this.blockID = blockID;
        setHorizontalAlignment(SwingConstants.CENTER);
    }

    public void updateValue(int value) {
        this.value = value;
    }

    public int getBlockID() {
		return blockID;
	}

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return col;
    }
}
