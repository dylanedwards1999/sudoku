package sudoku;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
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
		blockID = id;
		setLayout(new GridLayout(3, 3, 0, 0));
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}

	public void addCell(Cell newCell) {
		cells[arrayIndex] = newCell;
		add(newCell);
		++arrayIndex;
	}

	public int getBlockID() {
		return blockID;
	}

	public boolean checkBlock(int value) {
		for (Cell cell : cells) {
			if (cell.getValue() == value) {
				return false;
			}
		}
		return true; 
	}

}
