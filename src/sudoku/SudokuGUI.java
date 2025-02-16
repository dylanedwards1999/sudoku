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

	public JPanel newNorthPanel() {
		JPanel panelNorth = new JPanel();
		// create North panel and add a header label
		JLabel lblNewLabel = new JLabel("Sudoku Game");
		panelNorth.add(lblNewLabel);
		return panelNorth;
	}

	public JPanel newSouthPanel() {
		JPanel panelSouth = new JPanel();
		// create South panel and add a space for where buttons will eventually go
		JLabel lblNewLabel_1 = new JLabel("Buttons");
		panelSouth.add(lblNewLabel_1);
		return panelSouth;
	}

	public JPanel newCenterPanel() {
		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(new GridLayout(3, 3, 10, 10));
		createBlocks();
		int blockIndex = 0;
		int rowlimit, collimit;
		rowlimit = collimit = 3;
		while (blockIndex < 9) {
			for (int row = rowlimit - 3; row < rowlimit; ++row) {
				for (int col = collimit - 3; col < collimit; ++col) {
					Cell newcell = new Cell(row, col, blockIndex);
					int value = rand.nextInt(1, 10);
					newcell.setText(blockIndex + "");
					newcell.updateValue(value);
					cells[row][col] = newcell;
					blocks[blockIndex].addCell(newcell);
				}
			}
			if (blockIndex == 2 || blockIndex == 5) {
				rowlimit += 3;
				collimit = 3;
			}
			else {
				collimit += 3;
			}
			++blockIndex;
			
		}
		addCellsToPanel(panelCenter);
		return panelCenter;
	}

	// creates a 1-D array of CellBlocks, using 'i' to iterate through the array and
	// 'l' to iterate through the blockIDs that are assigned.
	private void createBlocks() {
		for (int i = 0; i < 9; ++i) {
			CellBlock block = new CellBlock(i);
			blocks[i] = block;
		}
	}

	// Takes in an individual Cell and returns its parent CellBlock.
	private CellBlock getParentBlock(Cell cell) {
		char blockID = cell.getID();

		for (CellBlock block : blocks) {
			if (block.getBlockID() == blockID) {
				return block;
			}
		}
	}

	private int assignValue(Cell cell) {
		// will choose a random int and verify that it's not already present in the
		// Cell's row, col, or block [use getParentBlock()]. If so, it will choose a new
		// int and retry. Once a unique int is found it will be assigned to the Cell's
		// value.
		return 0;
	}

	private void addCellsToPanel(JPanel panelCenter) {
	/* 	for (Cell[] row : cells) {
			for (Cell cell : row) {
				panelCenter.add(cell);
			}
			
		}
*/		for (CellBlock block : blocks) {
			panelCenter.add(block);	
		}
	}

}
