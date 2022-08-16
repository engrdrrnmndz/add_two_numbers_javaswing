import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LAB_4F {

	private JFrame frame;
	private JTextField FirstNumber;
	private JTextField SecondNumber;
	private JTextField Result;
	

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LAB_4F window = new LAB_4F();
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
	public LAB_4F() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	

	private void initialize() {
		ImageIcon icon = new ImageIcon(".//Icon//181_Java_logo_logos-512.png");
		frame = new JFrame();
		frame.setIconImage(icon.getImage());
		frame.setTitle("My Calculator");
		frame.setBounds(100, 100, 460, 374);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFirstNumber = new JLabel("First Number");
		lblFirstNumber.setFont(new Font("Arial", Font.BOLD, 14));
		lblFirstNumber.setBounds(15, 45, 104, 21);
		frame.getContentPane().add(lblFirstNumber);
		
		JLabel lblSecondNumber = new JLabel("Second Number");
		lblSecondNumber.setFont(new Font("Arial", Font.BOLD, 14));
		lblSecondNumber.setBounds(15, 83, 117, 21);
		frame.getContentPane().add(lblSecondNumber);
		
		JLabel lblResult = new JLabel("Result");
		lblResult.setFont(new Font("Arial", Font.BOLD, 14));
		lblResult.setBounds(15, 121, 117, 21);
		frame.getContentPane().add(lblResult);
		
		FirstNumber = new JTextField();
		FirstNumber.setBounds(137, 43, 209, 27);
		frame.getContentPane().add(FirstNumber);
		FirstNumber.setColumns(10);
		
		SecondNumber = new JTextField();
		SecondNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (SecondNumber.getText().length()>0) {;
					Result.setEnabled(false);
					String num1 = FirstNumber.getText();
					int a = Integer.parseInt(num1);
					String num2 = SecondNumber.getText();
					int b = Integer.parseInt(num2);
					int result = a + b;
					Result.setText(Integer.toString(result));
				}
			}
		});
		SecondNumber.setColumns(10);
		SecondNumber.setBounds(137, 81, 209, 27);
		frame.getContentPane().add(SecondNumber);
		
		Result = new JTextField();
		Result.setEnabled(false);
		Result.setColumns(10);
		Result.setBounds(137, 119, 209, 27);
		frame.getContentPane().add(Result);
		
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				String num1 = FirstNumber.getText();
				int a = Integer.parseInt(num1);
				String num2 = SecondNumber.getText();
				int b = Integer.parseInt(num2);
				int result = a + b;
				Result.setText(Integer.toString(result));
				Result.setEnabled(true);
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Enter the second number!");
				}
			}
		});
		btnNewButton.setBounds(137, 157, 70, 27);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FirstNumber.setText("");
				SecondNumber.setText("");
				Result.setText("");
			}
		});
		btnNewButton_1.setBounds(230, 157, 70, 27);
		frame.getContentPane().add(btnNewButton_1);
	}
}
