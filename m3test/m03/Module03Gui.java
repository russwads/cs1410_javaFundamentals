package m03;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Point;

public class Module03Gui extends JFrame {

	private JPanel contentPane;
	int index = 0;
	ArrayList<ImageIcon> seasons = new ArrayList<ImageIcon> ();
	ArrayList<String> list = new ArrayList<String> ();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Module03Gui frame = new Module03Gui();
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
	public Module03Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblSeasons = fourSeasonsLabel();
		contentPane.add(lblSeasons, BorderLayout.NORTH);		
		
		setSeasons();
		JLabel lblPicture = lblPicture();
		contentPane.add(lblPicture, BorderLayout.CENTER);
		
		JButton btnSeasons = asTimeMovesOn(lblSeasons, lblPicture);
		contentPane.add(btnSeasons, BorderLayout.SOUTH);
	}

	private JLabel lblPicture() {
		JLabel lblPicture = new JLabel("");
		lblPicture.setIcon(seasons.get(index));
		return lblPicture;
	}

	private void setSeasons() {
		seasons.add(new ImageIcon(Module03Gui.class.getResource("/Images/GUI-Fall.jpg")));
		seasons.add(new ImageIcon(Module03Gui.class.getResource("/Images/GUI-Winter.jpg")));
		seasons.add(new ImageIcon(Module03Gui.class.getResource("/Images/GUI-Spring.jpg")));
		seasons.add(new ImageIcon(Module03Gui.class.getResource("/Images/GUI-Summer.jpg")));
		
		list.add("Fall");
		list.add("Winter");
		list.add("Spring");
		list.add("Summer");
	}

	private JButton asTimeMovesOn(JLabel lblSeasons, JLabel picture) {
		JButton btnSeasons = new JButton("As Time Moves On...");
		btnSeasons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index = ++index % seasons.size();
				lblSeasons.setText(list.get(index));
				picture.setIcon(seasons.get(index));				
			}
		});
		btnSeasons.setFont(new Font("Georgia", Font.BOLD, 14));
		btnSeasons.setPreferredSize(new Dimension(131, 31));
		btnSeasons.setForeground(new Color(230,230,230));
		btnSeasons.setBackground(new Color(155,155,155));
		return btnSeasons;
	}

	private JLabel fourSeasonsLabel() {
		JLabel lblSeasons = new JLabel("Four Seasons");
		lblSeasons.setBackground(new Color(211,211,211));
		lblSeasons.setForeground(new Color(30,30,30));
		lblSeasons.setOpaque(true);
		lblSeasons.setPreferredSize(new Dimension(65, 36));
		lblSeasons.setFont(new Font("Georgia", Font.PLAIN, 18));
		lblSeasons.setHorizontalAlignment(SwingConstants.CENTER);
		return lblSeasons;
	}

}
