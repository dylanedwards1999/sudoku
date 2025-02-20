package sudoku;

import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.util.Random;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;

public class SudokuGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public Random rand = new Random();
	private CellBlock[] blocks = new CellBlock[9];
	public Cell[][] cells = new Cell[9][9];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SudokuGUI frame = new SudokuGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SudokuGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panelNorth = newNorthPanel();
		contentPane.add(panelNorth, BorderLayout.NORTH);

		JPanel panelSouth = newSouthPanel();
		contentPane.add(panelSouth, BorderLayout.SOUTH);

		JPanel panelCenter = newCenterPanel();
		contentPane.add(panelCenter, BorderLayout.CENTER);

	}

	/**
	 * 
	 * @return
	 */
	public JPanel newNorthPanel() {
		JPanel panelNorth = new JPanel();
		// create North panel and add a header label
		JLabel lblNewLabel = new JLabel("Sudoku Game");
		panelNorth.add(lblNewLabel);
		return panelNorth;
	}

	/**
	 * 
	 * @return
	 */
	public JPanel newSouthPanel() {
		JPanel panelSouth = new JPanel();
		// create South panel and add a space for where buttons will eventually go
		JLabel lblNewLabel_1 = new JLabel("Buttons");
		panelSouth.add(lblNewLabel_1);
		return panelSouth;
	}

	/**
	 * 
	 * @return
	 */
	public JPanel newCenterPanel() {
		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(new GridLayout(3, 3, 10, 10));
		createBlocks();
		createCells();
		addBlocksToPanel(panelCenter);
		assignCellValues();
		return panelCenter;
	}

	/**
	 * Creates Cells for each CellBlock, in order from left to right.
	 */
	private void createCells() {
		int blockIndex = 0;
		int rowLimit, colLimit;
		rowLimit = colLimit = 3;
		while (blockIndex < 9) {
			for (int row = rowLimit - 3; row < rowLimit; ++row) {
				for (int col = colLimit - 3; col < colLimit; ++col) {
					Cell newCell = new Cell(row, col, blockIndex);
					// Currently only shows the Block index for testing purposes, will need to be
					// changed
					newCell.setText(blockIndex + "");
					cells[row][col] = newCell;
					blocks[blockIndex].addCell(newCell);
				}
			}
			if (blockIndex == 2 || blockIndex == 5) {
				rowLimit += 3;
				colLimit = 3;
			} else {
				colLimit += 3;
			}
			++blockIndex;
		}
	}

	/**
	 * Creates a 1-D array of CellBlocks.
	 */
	private void createBlocks() {
		for (int i = 0; i < 9; ++i) {
			CellBlock block = new CellBlock(i);
			blocks[i] = block;
		}
	}

	/**
	 * Assigns a random int (1-9) to a Cell. If that int is already present within
	 * the Cell's row, column or CellBlock, then a new int will be assigned until it
	 * finds one that hasn't already been used.
	 * 
	 * @param cell the Cell receiving a value
	 * @return the unique, random int
	 */
	private int findUnusedValue(Cell cell) {
		int value;
		int cellRow = cell.getRow();
		int cellCol = cell.getColumn();
		do {
			value = rand.nextInt(1, 10);
		}
		while (!(checkCellRow(cellRow, value) || checkCellCol(cellCol, value)
				|| checkCellBlock(value, getParentBlock(cell))));
		return value;
	}

	private boolean checkCellRow(int row, int value) {
		for (int i = 0; i < 9; ++i) {
			if (cells[row][i].getValue() == value)
				return false;
		}
		return true;
	}

	private boolean checkCellCol(int col, int value) {
		for (int i = 0; i < 9; ++i) {
			if (cells[i][col].getValue() == value)
				return false;
		}
		return true;
	}

	private boolean checkCellBlock(int value, CellBlock block) {
		return block.checkBlock(value);
	}

	private void addBlocksToPanel(JPanel panelCenter) {
		for (CellBlock block : blocks) {
			panelCenter.add(block);
		}
	}

	/**
	 * Takes in an individual Cell and returns its parent CellBlock.
	 * 
	 * @param cell the Cell to be analyzed
	 * @return the CellBlock that the Cell belongs to
	 */
	private CellBlock getParentBlock(Cell cell) {
		int blockID = cell.getBlockID();

		for (CellBlock block : blocks) {
			if (block.getBlockID() == blockID) {
				return block;
			}
		}
		return null;
	}

	private void assignCellValues() {
		for (Cell[] cellRow : cells) {
			for (Cell cell : cellRow) {
				cell.updateValue(findUnusedValue(cell));
			}
		}
	}

}
