import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;

public class LoginWindow {

	private JFrame frmLogIn;

	/**
	 * Launch the application.
	 */
	public static void show() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow window = new LoginWindow();
					window.frmLogIn.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogIn = new JFrame();
		frmLogIn.setTitle("Log in");
		frmLogIn.setBounds(100, 100, 450, 300);
		frmLogIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Recorder.record("try.wav");
				boolean checkTwoFiles = Comparer.compareTwoFile("password.wav", "try.wav");
				if (!checkTwoFiles) {
					JOptionPane.showMessageDialog(null,"unload unsuccessful, please try again");
					System.out.println("Please try again");
				}
				else {
					JOptionPane.showMessageDialog(null,"unload successful");
					System.out.println("unload successful");
				}
			}
		});
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Please sing to log in");
		GroupLayout groupLayout = new GroupLayout(frmLogIn.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(135)
							.addComponent(lblNewJgoodiesLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(165)
							.addComponent(btnNewButton)))
					.addContainerGap(183, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(63, Short.MAX_VALUE)
					.addComponent(lblNewJgoodiesLabel)
					.addGap(40)
					.addComponent(btnNewButton)
					.addGap(109))
		);
		frmLogIn.getContentPane().setLayout(groupLayout);
	}
}
