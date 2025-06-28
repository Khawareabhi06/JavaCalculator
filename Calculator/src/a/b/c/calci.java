package a.b.c;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class calci {

	private JFrame frame;
	private JTextField textField;
	double first = 0;
	double second = 0;
	double result = 0;
	String operation = null;
	String answer;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					calci window = new calci();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public calci() {
		initialize();
	}
	private void performOperation() {
		switch (operation) {
			case "+":
				result = first + second;
				break;
			case "-":
				result = first - second;
				break;
			case "*":
				result = first * second;
				break;
			case "/":
				result = first / second;
				break;
			case "%":
				result = first % second;
				break;
		}
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 293, 369);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 17));
		textField.setBounds(10, 11, 254, 58);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JButton btnBackspace = new JButton("\u2190");
		btnBackspace.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String backspace = null;
				if (textField.getText().length() > 0) {
					StringBuilder str = new StringBuilder(textField.getText());
					str.deleteCharAt(textField.getText().length() - 1);
					backspace = str.toString();
					textField.setText(backspace);
				}
			}
		});
		btnBackspace.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnBackspace.setBounds(10, 80, 63, 47);
		frame.getContentPane().add(btnBackspace);

		JButton btnClear = new JButton("C");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				first = second = result = 0;
				operation = null;
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnClear.setBounds(73, 80, 63, 47);
		frame.getContentPane().add(btnClear);

		JButton btn00 = new JButton("00");
		btn00.addActionListener(e -> textField.setText(textField.getText() + btn00.getText()));
		btn00.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn00.setBounds(137, 80, 63, 47);
		frame.getContentPane().add(btn00);

		JButton btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField.getText().isEmpty()) {
					if (operation != null) {
						second = Double.parseDouble(textField.getText());
						performOperation();
						textField.setText(String.format("%.2f", result));
						first = result;
					} else {
						first = Double.parseDouble(textField.getText());
					}
				}
				operation = "+";
				textField.setText("");
			}
		});
		btnPlus.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnPlus.setBounds(201, 80, 63, 47);
		frame.getContentPane().add(btnPlus);

		JButton btn7 = new JButton("7");
		btn7.addActionListener(e -> textField.setText(textField.getText() + btn7.getText()));
		btn7.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn7.setBounds(10, 127, 63, 47);
		frame.getContentPane().add(btn7);

		JButton btn8 = new JButton("8");
		btn8.addActionListener(e -> textField.setText(textField.getText() + btn8.getText()));
		btn8.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn8.setBounds(73, 127, 63, 47);
		frame.getContentPane().add(btn8);

		JButton btn9 = new JButton("9");
		btn9.addActionListener(e -> textField.setText(textField.getText() + btn9.getText()));
		btn9.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn9.setBounds(137, 127, 63, 47);
		frame.getContentPane().add(btn9);

		JButton btnSub = new JButton("-");
		btnSub.addActionListener(e -> {
			if (!textField.getText().isEmpty()) {
				if (operation != null) {
					second = Double.parseDouble(textField.getText());
					performOperation();
					textField.setText(String.format("%.2f", result));
					first = result;
				} else {
					first = Double.parseDouble(textField.getText());
				}
			}
			operation = "-";
			textField.setText("");
		});
		btnSub.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSub.setBounds(201, 127, 63, 47);
		frame.getContentPane().add(btnSub);

		JButton btn4 = new JButton("4");
		btn4.addActionListener(e -> textField.setText(textField.getText() + btn4.getText()));
		btn4.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn4.setBounds(10, 175, 63, 47);
		frame.getContentPane().add(btn4);

		JButton btn1 = new JButton("1");
		btn1.addActionListener(e -> textField.setText(textField.getText() + btn1.getText()));
		btn1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn1.setBounds(10, 224, 63, 47);
		frame.getContentPane().add(btn1);

		JButton btn0 = new JButton("0");
		btn0.addActionListener(e -> textField.setText(textField.getText() + btn0.getText()));
		btn0.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn0.setBounds(10, 273, 63, 47);
		frame.getContentPane().add(btn0);

		JButton btn5 = new JButton("5");
		btn5.addActionListener(e -> textField.setText(textField.getText() + btn5.getText()));
		btn5.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn5.setBounds(73, 175, 63, 47);
		frame.getContentPane().add(btn5);

		JButton btn6 = new JButton("6");
		btn6.addActionListener(e -> textField.setText(textField.getText() + btn6.getText()));
		btn6.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn6.setBounds(137, 175, 63, 47);
		frame.getContentPane().add(btn6);

		JButton btnMul = new JButton("*");
		btnMul.addActionListener(e -> {
			if (!textField.getText().isEmpty()) {
				if (operation != null) {
					second = Double.parseDouble(textField.getText());
					performOperation();
					textField.setText(String.format("%.2f", result));
					first = result;
				} else {
					first = Double.parseDouble(textField.getText());
				}
			}
			operation = "*";
			textField.setText("");
		});
		btnMul.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnMul.setBounds(201, 175, 63, 47);
		frame.getContentPane().add(btnMul);

		JButton btn2 = new JButton("2");
		btn2.addActionListener(e -> textField.setText(textField.getText() + btn2.getText()));
		btn2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn2.setBounds(73, 224, 63, 47);
		frame.getContentPane().add(btn2);

		JButton btn3 = new JButton("3");
		btn3.addActionListener(e -> textField.setText(textField.getText() + btn3.getText()));
		btn3.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn3.setBounds(137, 224, 63, 47);
		frame.getContentPane().add(btn3);

		JButton btnDivide = new JButton("/");
		btnDivide.addActionListener(e -> {
			if (!textField.getText().isEmpty()) {
				if (operation != null) {
					second = Double.parseDouble(textField.getText());
					performOperation();
					textField.setText(String.format("%.2f", result));
					first = result;
				} else {
					first = Double.parseDouble(textField.getText());
				}
			}
			operation = "/";
			textField.setText("");
		});
		btnDivide.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDivide.setBounds(201, 224, 63, 47);
		frame.getContentPane().add(btnDivide);

		JButton btnDot = new JButton(".");
		btnDot.addActionListener(e -> textField.setText(textField.getText() + btnDot.getText()));
		btnDot.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnDot.setBounds(73, 273, 63, 47);
		frame.getContentPane().add(btnDot);

		JButton btnEqual = new JButton("=");
		btnEqual.addActionListener(e -> {
			if (!textField.getText().isEmpty() && operation != null) {
				second = Double.parseDouble(textField.getText());
				performOperation();
				answer = String.format("%.2f", result);
				textField.setText(answer);
				first = result;
				operation = null;
			}
		});
		btnEqual.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnEqual.setBounds(137, 273, 63, 47);
		frame.getContentPane().add(btnEqual);

		JButton btnPercent = new JButton("%");
		btnPercent.addActionListener(e -> {
			if (!textField.getText().isEmpty()) {
				if (operation != null) {
					second = Double.parseDouble(textField.getText());
					performOperation();
					textField.setText(String.format("%.2f", result));
					first = result;
				} else {
					first = Double.parseDouble(textField.getText());
				}
			}
			operation = "%";
			textField.setText("");
		});
		btnPercent.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnPercent.setBounds(201, 273, 63, 47);
		frame.getContentPane().add(btnPercent);
	}
}
