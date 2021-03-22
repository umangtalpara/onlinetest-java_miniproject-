
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.*;

class OnlineTest extends JFrame implements ActionListener {
	
	JLabel label;
	JRadioButton radioButton[] = new JRadioButton[5];
	JButton btnNext, btnBookmark,extra,bk[] = new JButton[9];
	ButtonGroup bg;
	int count = 0, current = 0, x = 1, y = 1, now = 0,z=0;
	int m[] = new int[10];

	OnlineTest(String s) {
		super(s);
		label = new JLabel();
		add(label);
		bg = new ButtonGroup();
		for (int i = 0; i < 5; i++) {
			radioButton[i] = new JRadioButton();
			add(radioButton[i]);
			bg.add(radioButton[i]);
		}
		btnNext = new JButton("Next");
		btnBookmark = new JButton("Bookmark");
		extra =new JButton();
		extra.setBounds(500,40,100,20);
		extra.setVisible(false);
		add(extra);
		
		btnNext.addActionListener(this);
		btnBookmark.addActionListener(this);
		add(btnNext);
		add(btnBookmark);
		set();
		label.setBounds(30, 40, 450, 20);
		radioButton[0].setBounds(50, 80, 200, 20);
		radioButton[1].setBounds(50, 110, 200, 20);
		radioButton[2].setBounds(50, 140, 200, 20);
		radioButton[3].setBounds(50, 170, 200, 20);
		btnNext.setBounds(100, 240, 100, 30);
		btnBookmark.setBounds(270, 240, 100, 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(1000, 1000);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNext) {
			if (check())
				count = count + 1;
			current++;
			set();
			if (current == 9) {
				btnNext.setEnabled(false);
				btnBookmark.setText("Result");
			}
		}
		if (e.getActionCommand().equals("Bookmark")) {
			 
			 bk[z] = new JButton("Bookmark" + x);
			bk[z].setBounds(500, 20 + 40 * x, 100, 30);
			extra.setText("jay");
			//extra.setVisible(true);
			//getContentPane().add(bk);
			bk[z].addActionListener(this);
			getContentPane().add(bk[z]);
			z++;
			m[x] = current;
			x++;
			current++;
			set();
			if (current == 9)
				btnBookmark.setText("Result");
			repaint();
		}
		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("Bookmark" + y)) {
				if (check())
					count = count + 1;
				now = current;
				current = m[y];
				set();
				((JButton) e.getSource()).setEnabled(false);
				current = now;
			}
		}

		if (e.getActionCommand().equals("Result")) {
			if (check())
				count = count + 1;
			current++;
			JOptionPane.showMessageDialog(this, "correct answers= " + count);
			System.exit(0);
		}
	}

	void set() {
		radioButton[4].setSelected(true);
		if (current == 0) {
			label.setText("Que1:  Where is Bose Institute ?");
			radioButton[0].setText("gujrat");
			radioButton[1].setText("Kolkata");
			radioButton[2].setText("New Delhi");
			radioButton[3].setText("Dispur");
		}
		if (current == 1) {
			label.setText("Que2: World Tourism Day is celebrated on-");
			radioButton[0].setText(" September 27");
			radioButton[1].setText("September 12");
			radioButton[2].setText("September 25");
			radioButton[3].setText("September 29t");
		}
		if (current == 2) {
			label.setText("Que3: When is the International Yoga Day celebrated ?");
			radioButton[0].setText("June 20");
			radioButton[1].setText("June 21");
			radioButton[2].setText(" April 22");
			radioButton[3].setText("May 31");
		}
		if (current == 3) {
			label.setText("Que4:  'Line of Blood' is a book written by whom?");
			radioButton[1].setText("Bairaj Khanna");
			radioButton[0].setText("Ursula Vernon");
			radioButton[2].setText("Amal EI-Mohtar");
			radioButton[3].setText("Diksha Basu");
		}
		if (current == 4) {
			label.setText("Que5:  ........... is the first woman to head a public sector bank?");
			radioButton[0].setText(" Usha Ananthasubramanyan");
			radioButton[1].setText("Bairaj Khanna");
			radioButton[2].setText("Shikha Sharma");
			radioButton[3].setText("Arundhati Bhattacharya");
		}
		if (current == 5) {
			label.setText("Que6:  Indian Army celebrated the Poonch Link-up Day on which date?");
			radioButton[0].setText("November 21");
			radioButton[1].setText("November 25");
			radioButton[2].setText("November 24");
			radioButton[3].setText("November 23");
		}
		if (current == 6) {
			label.setText("Que7:  The first Indian State to go wholley organic is -?");
			radioButton[0].setText(" Sikkim");
			radioButton[1].setText("Meghalaya");
			radioButton[2].setText("Manipur");
			radioButton[3].setText("Kerala");
		}
		if (current == 7) {
			label.setText("Que8:  What is the name of Indira Gandhi's Samadhi?");
			radioButton[0].setText("Shakti Sthal");
			radioButton[1].setText(" Shanti Van");
			radioButton[2].setText(" Shanti Sthal");
			radioButton[3].setText(" Shanti Sthal");
		}
		if (current == 8) {
			label.setText("Que9: Dallol Geothermal Field belongs to which country?");
			radioButton[0].setText("Ethiopia");
			radioButton[1].setText(" Sudan");
			radioButton[2].setText("Norway");
			radioButton[3].setText("Russia");
		}
		if (current == 9) {
			label.setText("Que10:  In which state living root bridges are found?");
			radioButton[0].setText("Meghalaya");
			radioButton[1].setText("Assam");
			radioButton[2].setText("Manipur");
			radioButton[3].setText(" Odisha");
		}
		
		
	}

	
	boolean check() {
		if (current == 0)
			return (radioButton[1].isSelected());
		if (current == 1)
			return (radioButton[0].isSelected());
		if (current == 2)
			return (radioButton[1].isSelected());
		if (current == 3)
			return (radioButton[1].isSelected());
		if (current == 4)
			return (radioButton[3].isSelected());
		if (current == 5)
			return (radioButton[0].isSelected());
		if (current == 6)
			return (radioButton[1].isSelected());
		if (current == 7)
			return (radioButton[2].isSelected());
		if (current == 8)
			return (radioButton[0].isSelected());
		if (current == 9)
			return (radioButton[0].isSelected());
		return false;
	}

	public static void main(String s[]) {
		new OnlineTest("Online Test App");
	}

}