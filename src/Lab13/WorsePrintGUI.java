package Lab13;

import java.awt.EventQueue;
import Lab05.PrintOrder;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class WorsePrintGUI {

	private JFrame frame;
	private JTextField tbPageCount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WorsePrintGUI window = new WorsePrintGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WorsePrintGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 411, 402);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPageNumber = new JLabel("Enter Number of Pages");
		lblPageNumber.setBounds(89, 37, 150, 16);
		frame.getContentPane().add(lblPageNumber);
		
		tbPageCount = new JTextField();
		tbPageCount.setBounds(246, 32, 47, 26);
		frame.getContentPane().add(tbPageCount);
		tbPageCount.setColumns(10);
		
		JLabel lblPaperType = new JLabel("Select Paper Type");
		lblPaperType.setBounds(142, 88, 121, 16);
		frame.getContentPane().add(lblPaperType);
		
		JRadioButton rdbtnGlossy = new JRadioButton("Glossy");
		rdbtnGlossy.setBounds(189, 116, 74, 23);
		rdbtnGlossy.setActionCommand("Glossy");
		frame.getContentPane().add(rdbtnGlossy);
		
		JRadioButton rdbtnMatte = new JRadioButton("Matte");
		rdbtnMatte.setSelected(true);
		rdbtnMatte.setActionCommand("Matte");
		rdbtnMatte.setBounds(109, 116, 67, 23);
		frame.getContentPane().add(rdbtnMatte);
		
		ButtonGroup paperTypes = new ButtonGroup();
		paperTypes.add(rdbtnMatte);
		paperTypes.add(rdbtnGlossy);
		
		JLabel lblColorType = new JLabel("Select Color Type");
		lblColorType.setBounds(142, 159, 121, 16);
		frame.getContentPane().add(lblColorType);
		
		JRadioButton rdbtnGs = new JRadioButton("GrayScale");
		rdbtnGs.setBounds(20, 187, 92, 23);
		rdbtnGs.setActionCommand("gs");
		rdbtnGs.setSelected(true);
		frame.getContentPane().add(rdbtnGs);
		
		JRadioButton rdbtnP1 = new JRadioButton("Pantone 1");
		rdbtnP1.setActionCommand("p1");
		rdbtnP1.setBounds(109, 187, 104, 23);
		frame.getContentPane().add(rdbtnP1);
		
		JRadioButton rdbtnP2 = new JRadioButton("Pantone 2");
		rdbtnP2.setActionCommand("p2");
		rdbtnP2.setBounds(206, 187, 104, 23);
		frame.getContentPane().add(rdbtnP2);
		
		JRadioButton rdbtnP3 = new JRadioButton("Pantone 3");
		rdbtnP3.setActionCommand("p3");
		rdbtnP3.setBounds(301, 187, 104, 23);
		frame.getContentPane().add(rdbtnP3);
		
		ButtonGroup colorTypes = new ButtonGroup();
		colorTypes.add(rdbtnGs);
		colorTypes.add(rdbtnP1);
		colorTypes.add(rdbtnP2);
		colorTypes.add(rdbtnP3);
		
		JLabel lblSidedness = new JLabel("Select Sidedness");
		lblSidedness.setBounds(142, 222, 110, 16);
		frame.getContentPane().add(lblSidedness);
		
		JRadioButton rdbtnSingle = new JRadioButton("Single Sided");
		rdbtnSingle.setActionCommand("single");
		rdbtnSingle.setBounds(89, 250, 110, 23);
		rdbtnSingle.setSelected(true);
		frame.getContentPane().add(rdbtnSingle);
		
		JRadioButton rdbtnDouble = new JRadioButton("Double Sided");
		rdbtnDouble.setActionCommand("double");
		rdbtnDouble.setBounds(195, 250, 121, 23);
		frame.getContentPane().add(rdbtnDouble);
		
		ButtonGroup sidedTypes = new ButtonGroup();
		sidedTypes.add(rdbtnSingle);
		sidedTypes.add(rdbtnDouble);
		
		JLabel lblOutput = new JLabel("Total Cost is: $cost");
		lblOutput.setVisible(false);
		lblOutput.setBounds(122, 339, 141, 16);
		frame.getContentPane().add(lblOutput);
		
		JLabel lblError = new JLabel("Page Number must be a number greater than 0");
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setVisible(false);
		lblError.setBounds(44, 60, 308, 16);
		frame.getContentPane().add(lblError);
		
		JButton btnCalculateTotalCost = new JButton("Calculate");
		btnCalculateTotalCost.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int pageCount;
				lblError.setVisible(false);
				lblOutput.setVisible(false);

				try {
					pageCount = Integer.parseInt(tbPageCount.getText());
					if (pageCount <= 0) throw new Exception();
				}
				catch(Exception ex) {
					lblError.setVisible(true);
					return;
				}
				String color = colorTypes.getSelection().getActionCommand();
				String side = sidedTypes.getSelection().getActionCommand();
				String paper = paperTypes.getSelection().getActionCommand();
				PrintOrder order1 = new PrintOrder(color, paper, side, pageCount);
				order1.determineTotalCost();
				lblOutput.setText("Total Cost is: $" + Math.round(order1.getTotalCost()*100)/100.0);
				lblOutput.setVisible(true);
			}
		});
		btnCalculateTotalCost.setBounds(130, 285, 117, 29);
		frame.getContentPane().add(btnCalculateTotalCost);
		
		
	}
}
