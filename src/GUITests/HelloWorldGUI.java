package GUITests;

import java.awt.EventQueue;
import Lab01.Greeter;

import javax.swing.JFrame;
import javax.swing.JLabel;
//import java.awt.BorderLayout;
//import javax.swing.SwingConstants;
//import java.awt.Font;
import javax.swing.JTextField;
//import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HelloWorldGUI {

	private JFrame frmAh;
	private JTextField tfName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelloWorldGUI window = new HelloWorldGUI();
					window.frmAh.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HelloWorldGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAh = new JFrame();
		frmAh.setTitle("Ah");
		frmAh.setBounds(100, 100, 450, 300);
		frmAh.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAh.getContentPane().setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome to the Greeter");
		lblWelcome.setBounds(148, 6, 146, 16);
		frmAh.getContentPane().add(lblWelcome);
		
		JLabel lblName = new JLabel("Enter Name:");
		lblName.setBounds(105, 56, 84, 16);
		frmAh.getContentPane().add(lblName);
		
		JLabel lblGreeting = new JLabel("New label");
		lblGreeting.setVisible(false);
		lblGreeting.setBounds(148, 189, 154, 16);
		frmAh.getContentPane().add(lblGreeting);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = tfName.getText();
				Greeter greet = new Greeter(name);
				greet.generateGreeting();
				lblGreeting.setText(greet.getGreeting());
				lblGreeting.setVisible(true);
			}
		});
		
		btnOk.setBounds(160, 106, 117, 29);
		frmAh.getContentPane().add(btnOk);
		
		tfName = new JTextField();
		tfName.setBounds(191, 51, 130, 26);
		frmAh.getContentPane().add(tfName);
		tfName.setColumns(10);
		
		
	}
}
