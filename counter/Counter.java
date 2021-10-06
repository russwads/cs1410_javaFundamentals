package counter;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.Rectangle;
import javax.swing.JSeparator;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Counter extends JFrame {

	private JPanel contentPane;
	private Random rand = new Random();
	private int num = 0;
	private int redCount = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Counter frame = new Counter();
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
	public Counter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = labelRussellGui();
		contentPane.add(lblNewLabel, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_1 = labelRedCounter();
		contentPane.add(lblNewLabel_1, BorderLayout.WEST);
		
		JButton btnNewButton = buttonClickMe(lblNewLabel_1);
		contentPane.add(btnNewButton, BorderLayout.CENTER);
	}

	/**
	 * Creates the button "Click Me" and implements functionality.
	 * @return
	 */
	private JButton buttonClickMe(JLabel counter) {
		JButton btnNewButton = new JButton("Click me!");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 0, 255));
		btnNewButton.setFont(new Font("Copperplate Gothic Bold", Font.BOLD | Font.ITALIC, 30));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton.setBackground(getColor(num)); //Sets button to new color
				counter.setText("Red Counter: " + String.format("%02d", redCount)); //Updates visible red counter text
			}
		});
		return btnNewButton;
	}

	/**
	 * Creates the label "Red Counter" with a double-digit running total.
	 * @return
	 */
	private JLabel labelRedCounter() {
		JLabel lblNewLabel_1 = new JLabel("Red Counter: " + String.format("%02d", redCount));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBackground(new Color(211, 211, 211));
		lblNewLabel_1.setFont(new Font(Font.MONOSPACED,Font.PLAIN,25));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setPreferredSize(new Dimension(225, 23));
		return lblNewLabel_1;
	}

	/**
	 * Creates the bottom label "Russell's GUI."
	 * @return
	 */
	private JLabel labelRussellGui() {
		JLabel lblNewLabel = new JLabel("Russell's GUI");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setPreferredSize(new Dimension(63, 42));
		lblNewLabel.setFont(new Font("Cambria Math", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		return lblNewLabel;
	}

	/**
	 * Retrieves a new color when the button "Click Me" is pressed.
	 * @return
	 */
	private Color getColor(int index) {
		int i = 0;
		ArrayList<Color> colors = new ArrayList<Color> ();
		Color red = new Color(255,0,0);
		colors.add(red); //Red
		colors.add(new Color(0,0,255)); //Blue
		colors.add(new Color(0,128,0)); //Green
		colors.add(new Color(255,165,0)); //Orange
		colors.add(new Color(255,0,255)); //Magenta
		
		// Choosing background at random; keeping number in bounds
		i = rand.nextInt(5);
		if (i == index) {
			i++;
			if (i > 4) {
				i--;
				i--;
			}
		}
		num = i;
		
		// Checks for red and increases red count
		if (colors.get(i) == red) {
			redCount++;
		}
		return colors.get(i);
	}
}
