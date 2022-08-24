package Lab13;

import Lab05.PrintOrder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSpinner;

public class PrintGUI {

	private JFrame frame;
	private JButton btnCalcCost;
	
	final String[] Colors = {"GS", "P1", "P2", "P3"};
	final String[] PaperTypes = {"GLOSSY", "MATTE"};
	final String[] Sidedness = {"SINGLE", "DOUBLE"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrintGUI window = new PrintGUI();
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
	public PrintGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 409, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
				
		JLabel lblTitle = new JLabel("Print Order GUI");
		lblTitle.setBounds(165, 6, 104, 16);
		frame.getContentPane().add(lblTitle);
		
		JLabel lblNumPages = new JLabel("Enter Number of Pages");
		lblNumPages.setBounds(46, 41, 143, 16);
		frame.getContentPane().add(lblNumPages);
		
		JLabel lblSidedness = new JLabel("Select Printing Sidedness");
		lblSidedness.setBounds(30, 78, 157, 16);
		frame.getContentPane().add(lblSidedness);
		
		JLabel lblColorType = new JLabel("Select Color Type");
		lblColorType.setBounds(72, 117, 117, 16);
		frame.getContentPane().add(lblColorType);
		
		JComboBox<String> cbSidedness = new JComboBox<>();
		cbSidedness.setMaximumRowCount(2);
		cbSidedness.setBounds(194, 74, 143, 27);
		cbSidedness.addItem("Single Sided");
		cbSidedness.addItem("Double Sided");
		frame.getContentPane().add(cbSidedness);
		
		JComboBox<String> cbColorType = new JComboBox<String>();
		cbColorType.setMaximumRowCount(4);
		cbColorType.setBounds(194, 113, 143, 27);
		cbColorType.addItem("GreyScale");
		cbColorType.addItem("Pantone 1");
		cbColorType.addItem("Pantone 2");
		cbColorType.addItem("Pantone 3");
		frame.getContentPane().add(cbColorType);
		
		JComboBox<String> cbPaperType = new JComboBox<String>();
		cbPaperType.setMaximumRowCount(2);
		cbPaperType.setBounds(194, 151, 143, 27);
		cbPaperType.addItem("Glossy");
		cbPaperType.addItem("Matte");
		frame.getContentPane().add(cbPaperType);
		
		JLabel lblPaperType = new JLabel("Select Paper Type");
		lblPaperType.setBounds(72, 155, 117, 16);
		frame.getContentPane().add(lblPaperType);
		
		
		SpinnerNumberModel value = new SpinnerNumberModel(1,1,10000,1);
		JSpinner PageCountSpinner = new JSpinner(value);
		PageCountSpinner.setBounds(194, 36, 56, 26);
		frame.getContentPane().add(PageCountSpinner);
		
		JLabel lblTotalCost = new JLabel("Total Cost is: $cost");
		lblTotalCost.setVisible(false);
		lblTotalCost.setBounds(121, 231, 188, 16);
		frame.getContentPane().add(lblTotalCost);
		
		btnCalcCost = new JButton("Calculate");
		btnCalcCost.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblTotalCost.setVisible(false);
				int pageCount = (int) PageCountSpinner.getValue();
				int paperType = cbPaperType.getSelectedIndex();
				int colorType = cbColorType.getSelectedIndex();
				int sidedness = cbSidedness.getSelectedIndex();
								
				PrintOrder order = new PrintOrder(Colors[colorType], PaperTypes[paperType], Sidedness[sidedness], pageCount);
				order.determineTotalCost();
				double totalCost = order.getTotalCost();
				
				lblTotalCost.setText("Total Cost is: $" + Math.round(totalCost*100)/100.0);
				lblTotalCost.setVisible(true);
			}
		});
		btnCalcCost.setBounds(133, 190, 117, 29);
		frame.getContentPane().add(btnCalcCost);
	}
}
