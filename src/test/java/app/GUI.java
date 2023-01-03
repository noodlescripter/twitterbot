package app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class GUI implements ActionListener {

	
	private static JLabel password1, label, tweetLabel, radioLabel1;
	private static JTextField username, tweetField, userNamePersonFiedl;
	private static JButton button;
	private static JPasswordField Password;
	private static JRadioButton radio1;

	private static String userName;
	private static String pass;
	private static int tweet;
	private static boolean isBackground;
	private static String target;

	public static void main(String[] args) {
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.CYAN);
		
		JFrame frame = new JFrame();
		frame.setTitle("TWITTER BOT -ELON MUSK-");
		frame.setLocation(new Point(500, 300));
		frame.add(panel);
		frame.setSize(new Dimension(400, 400));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		label = new JLabel("Username");
		label.setBounds(100, 8, 70, 20);
		panel.add(label);
		
		username = new JTextField();
		username.setBounds(100, 27, 193, 28);
		panel.add(username);
		
		password1 = new JLabel("Password");
		password1.setBounds(100, 55, 70, 20);
		panel.add(password1);
		
		Password = new JPasswordField();
		Password.setBounds(100, 75, 193, 28);
		panel.add(Password);
		
		tweetLabel = new JLabel("TIMES");
		tweetLabel.setBounds(100, 110, 70, 20);
		panel.add(tweetLabel);
		
		tweetField = new JTextField();
		tweetField.setBounds(100, 130, 40, 28);
		tweetField.setBackground(Color.yellow);
		panel.add(tweetField);
		
		radioLabel1 = new JLabel("RUN IN BACKGROUND");
		radioLabel1.setBounds(100, 170, 150, 20);
		panel.add(radioLabel1);

		radio1 = new JRadioButton();
		radio1.setBounds(250, 170, 20, 20);
		panel.add(radio1);

		button = new JButton("RUN");
		button.setBounds(100, 200, 90, 25);
		button.setForeground(Color.WHITE);
		button.setBackground(Color.BLACK);
		button.addActionListener((ActionListener) new GUI());
		panel.add(button);

		JLabel createdBY = new JLabel("Created by: @alamhamim");
		createdBY.setBounds(100, 300, 200, 20);
		createdBY.setForeground(Color.RED);
		panel.add(createdBY);
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		userName = username.getText();
		pass = String.valueOf(Password.getPassword());
		tweet = Integer.parseInt(tweetField.getText()); 
		isBackground = radio1.isSelected();
		
		try {
			MainAPP.twitterBOT(userName, pass, tweet, isBackground);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}

