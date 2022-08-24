package Lab12;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.SystemColor;
//import javax.swing.border.LineBorder;

import numeric.Numeric;

public class LawnGUI {

	private JFrame frame;
	private JTextField tbXdimen;
	private JTextField tbYdimen;
	private JTextField tbSodSize;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LawnGUI window = new LawnGUI();
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
	public LawnGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 640, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		tbXdimen = new JTextField();
		tbXdimen.setBounds(186, 52, 130, 26);
		frame.getContentPane().add(tbXdimen);
		tbXdimen.setColumns(10);
		
		JLabel lblXdimen = new JLabel("Enter Lawn Width:");
		lblXdimen.setBounds(53, 57, 130, 16);
		frame.getContentPane().add(lblXdimen);
		
		JLabel lblYdimen = new JLabel("Enter Lawn Length:");
		lblYdimen.setBounds(53, 84, 130, 16);
		frame.getContentPane().add(lblYdimen);
		
		tbYdimen = new JTextField();
		tbYdimen.setColumns(10);
		tbYdimen.setBounds(186, 79, 130, 26);
		frame.getContentPane().add(tbYdimen);
		
		JLabel lblSodSize = new JLabel("Enter Sod Block Size:");
		lblSodSize.setBounds(53, 112, 130, 16);
		frame.getContentPane().add(lblSodSize);
		
		tbSodSize = new JTextField();
		tbSodSize.setColumns(10);
		tbSodSize.setBounds(186, 107, 130, 26);
		frame.getContentPane().add(tbSodSize);
		
		JLabel lblOutput = new JLabel("example text");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setVisible(false);
		lblOutput.setBounds(53, 189, 263, 16);
		frame.getContentPane().add(lblOutput);
		
		JTextArea taInputError = new JTextArea();
		taInputError.setText("filler text to show that theres actually a \ncomponent here");
		taInputError.setBackground(SystemColor.window);
		taInputError.setForeground(Color.RED);
		taInputError.setRows(3);
		taInputError.setVisible(false);
		taInputError.setBounds(52, 222, 397, 76);
		frame.getContentPane().add(taInputError);
		
		JButton btnConfirm = new JButton("Calculate Number of Sod Blocks");
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double lawnWidth, lawnLength, sodSize;
				tbXdimen.setBackground(Color.WHITE);
				tbYdimen.setBackground(Color.WHITE);
				tbSodSize.setBackground(Color.WHITE);


				taInputError.setVisible(false);
				lblOutput.setVisible(false);
				try {
					lawnWidth = Double.parseDouble(tbXdimen.getText());
					lawnLength = Double.parseDouble(tbYdimen.getText());
					sodSize = Double.parseDouble(tbSodSize.getText());
					if ((lawnWidth < 0) || (lawnLength < 0) || (sodSize <= 0))
						throw new NumberFormatException();
					}
				catch (NumberFormatException d) {
					String errorText = "Error: ";
					if (Numeric.isNumeric(tbXdimen.getText()) == false) {
						errorText += "lawn width must be numerical and positive\n";
						tbXdimen.setBackground(Color.RED);
					}
					if (Numeric.isNumeric(tbYdimen.getText()) == false) {
						errorText += "lawn length must be numerical and positive \n";
						tbYdimen.setBackground(Color.RED);
					}
					if (Numeric.isNumeric(tbSodSize.getText()) == false) {
						errorText += "Sod Size must be numercial and positive";
						tbSodSize.setBackground(Color.RED);
					}
					taInputError.setText(errorText);
					taInputError.setVisible(true);
					return;
				}
				Lawn lawn1 = new Lawn(sodSize, lawnWidth, lawnLength);
				lawn1.calculateLawnArea();
				lawn1.calculateSodBlocks();
				lblOutput.setText("You will need " + lawn1.getNumSodBlocks() + " sod blocks.");
				lblOutput.setVisible(true);
			}
		});
		btnConfirm.setBounds(63, 140, 239, 29);
		frame.getContentPane().add(btnConfirm);			
	}	
}
