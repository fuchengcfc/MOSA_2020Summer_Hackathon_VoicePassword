import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewuserWindow {

	private JFrame frmNewUser;

	/**
	 * Launch the application.
	 */
	public static void show() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewuserWindow window = new NewuserWindow();
					window.frmNewUser.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NewuserWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNewUser = new JFrame();
		frmNewUser.setTitle("New User");
		frmNewUser.setBounds(100, 100, 450, 300);
		frmNewUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnNewButton = new JButton("Record");
		
		JButton btnNewButton_1 = new JButton("Stop");
		
		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Please record your password");
		
		JButton btnNewButton_2 = new JButton("Back to menu");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmNewUser.setVisible(false);
			}
		});
		GroupLayout groupLayout = new GroupLayout(frmNewUser.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(106)
							.addComponent(btnNewButton)
							.addGap(73)
							.addComponent(btnNewButton_1))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(130)
							.addComponent(lblNewJgoodiesLabel)))
					.addContainerGap(121, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(169, Short.MAX_VALUE)
					.addComponent(btnNewButton_2)
					.addGap(166))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(68, Short.MAX_VALUE)
					.addComponent(lblNewJgoodiesLabel)
					.addGap(47)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_1)
						.addComponent(btnNewButton))
					.addGap(59)
					.addComponent(btnNewButton_2)
					.addContainerGap())
		);
		frmNewUser.getContentPane().setLayout(groupLayout);
	}
}
