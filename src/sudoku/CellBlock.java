package sudoku;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class CellBlock extends JPanel {

	private static final long serialVersionUID = 1L;
	private int blockID;
	private Cell[] cells = new Cell[9];
	private int arrayIndex = 0;

	/**
	 * Create the panel.
	 */
	public CellBlock(int id) {
		setLayout(new GridLayout(3, 3, 0, 0));
		blockID = id;
	}

	public void addCell(Cell newCell) {
		cells[arrayIndex] = newCell;
		++arrayIndex;
		//repaint();
	}

	public int getBlockID() {
		return blockID;
	}

}
