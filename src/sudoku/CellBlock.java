package sudoku;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class CellBlock extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public CellBlock() {
		setLayout(new GridLayout(3, 3, 0, 0));
		
		for (int i = 0; i < 9; ++i) {
			JLabel label = new JLabel("0");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			add(label);
		}
		
/**		JLabel lblA1 = new JLabel("0");
		add(lblA1);
		
		JLabel lblB1 = new JLabel("0");
		add(lblB1);
		
		JLabel lblC1 = new JLabel("0");
		add(lblC1);
		
		JLabel lblA2 = new JLabel("0");
		add(lblA2);
		
		JLabel lblB2 = new JLabel("0");
		add(lblB2);
		
		JLabel lblC2 = new JLabel("0");
		add(lblC2);
		
		JLabel lblA3 = new JLabel("0");
		lblA3.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblA3);
		
		JLabel lblB3 = new JLabel("0");
		add(lblB3);
		
		JLabel lblC3 = new JLabel("0");
		add(lblC3);
**/
	}

}
