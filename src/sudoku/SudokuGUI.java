package sudoku;

import java.awt.EventQueue;
import java.awt.Graphics;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.util.Random;
import java.awt.BorderLayout;
import javax.swing.JLabel;

public class SudokuGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JLabel[][] cells = new JLabel[9][9];
	public Random rand = new Random();

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
		setBounds(100, 100, 450, 300);
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
		
		JLabel lblNewLabel = new JLabel("Sudoku Game");
		panelNorth.add(lblNewLabel);
		return panelNorth;
	}

	public JPanel newSouthPanel() {
		JPanel panelSouth = new JPanel();
		
		JLabel lblNewLabel_1 = new JLabel("Buttons");
		panelSouth.add(lblNewLabel_1);
		return panelSouth;
	}

	public JPanel newCenterPanel() {
		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(new GridLayout(9, 9, 0, 0));
		
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
				JLabel label = new JLabel("0");
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setText(rand.nextInt(1, 9) + "");
				if (i == 2) {
					
				}
				cells[i][j] = label;
				panelCenter.add(label);
			}
		}
		
		return panelCenter;
	}
	
	public void setValues() {
		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; j++) {
				JLabel label = cells[i][j];
				label.setText(rand.nextInt(1, 9) + "");
			}
		}
	}
	
 /**
     * Paints the maze onto the panel.
     * 
     * @param g standard Graphics object used for painting
     
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Draws each individual cell
        for (int i = 0; i < maze.size; ++i) {
            for (int j = 0; j < maze.size; ++j) {
                drawCell(g, maze.cells[i][j]);
            }
        }
        
        drawPath(g); // Draw path after maze is painted
    }
**/

}
