import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLayeredPane;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField_3;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private Quiz quiz;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI2 frame = new GUI2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public GUI2() throws IOException, ClassNotFoundException {
		 
		
		

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 956, 879);
		contentPane =  new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLoadQuizWith = new JLabel("Load Quiz with name:");
		lblLoadQuizWith.setBounds(12, 13, 141, 16);
		contentPane.add(lblLoadQuizWith);
		
		
		
		JLabel lblQuestion = new JLabel("Question:");
		lblQuestion.setBounds(34, 126, 56, 16);
		contentPane.add(lblQuestion);
		
		JLabel label = new JLabel("");
		label.setBounds(138, 126, 288, 77);
		contentPane.add(label);
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 303, 317, 355);
		contentPane.add(panel);
		panel.setVisible(false);
		panel.setLayout(null);

		
		JLabel lblShortAnswer = new JLabel("Short Answer:");
		lblShortAnswer.setBounds(29, 13, 132, 16);
		panel.add(lblShortAnswer);
		
		textField_1 = new JTextField();
		textField_1.setBounds(12, 42, 293, 199);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(316, 303, 336, 355);
		contentPane.add(panel_1);
		panel_1.setVisible(false);
		panel_1.setLayout(null);
		
		textField_3 = new JTextField();
		textField_3.setBounds(22, 54, 200, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		String fileName = textField_3.getText() ;
		fileName+=".bin";
		
		
		
		JButton btnLoad = new JButton("Load");

		btnLoad.setBounds(380, 9, 97, 25);
		contentPane.add(btnLoad);
		
		btnLoad.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String fileName = textField_3.getText() ;
				fileName+=".bin";
				FileInputStream fstream = null;
				try {
					fstream = new FileInputStream(fileName);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ObjectInputStream ostream = null;
				try {
					ostream = new ObjectInputStream(fstream);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					quiz = (Quiz) ostream.readObject();
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					fstream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(quiz.get(0).askQuestion());
				label.setText(quiz.get(0).askQuestion());
			}
		});
		
		JLabel lblMultipleChoice = new JLabel("Multiple Choice:");
		lblMultipleChoice.setBounds(12, 13, 112, 16);
		panel_1.add(lblMultipleChoice);
		
		ButtonGroup group = new ButtonGroup();
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBounds(22, 78, 127, 25);
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_1.setBounds(22, 139, 127, 25);
		panel_1.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_2.setBounds(22, 215, 127, 25);
		panel_1.add(rdbtnNewRadioButton_2);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_3.setBounds(22, 284, 127, 25);
		panel_1.add(rdbtnNewRadioButton_3);
		group.add(rdbtnNewRadioButton_3);
		group.add(rdbtnNewRadioButton_2);
		group.add(rdbtnNewRadioButton_1);
		group.add(rdbtnNewRadioButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(653, 302, 285, 356);
		contentPane.add(panel_2);
		panel_2.setVisible(false);
		panel_2.setLayout(null);
		
		
		JLabel lblMultipleAnswers = new JLabel("Multiple Answers:");
		lblMultipleAnswers.setBounds(12, 13, 128, 16);
		panel_2.add(lblMultipleAnswers);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		chckbxNewCheckBox.setBounds(12, 88, 113, 25);
		panel_2.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("New check box");
		chckbxNewCheckBox_1.setBounds(12, 155, 113, 25);
		panel_2.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("New check box");
		chckbxNewCheckBox_2.setBounds(12, 227, 113, 25);
		panel_2.add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("New check box");
		chckbxNewCheckBox_3.setBounds(12, 299, 113, 25);
		panel_2.add(chckbxNewCheckBox_3); 
		int score = 0;
		/*for (int i =0;i<quiz.length();i++) {
			if(quiz.get(i) instanceof MultipleChoiceQuestion) {
				panel_1.setVisible(true);
				//load question into 
				//score ++
			}
			else if(quiz.get(i) instanceof MultipleAnswer) {
				panel_2.setVisible(true);
				//load Question info 
			}
		}*/
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(401, 711, 97, 25);
		contentPane.add(btnNext);
		// clear console present next question
		// check score
		
		JButton btnCheckScore = new JButton("Check Score");
		btnCheckScore.setBounds(510, 711, 113, 25);
		contentPane.add(btnCheckScore);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(635, 711, 97, 25);
		contentPane.add(btnExit);
		
			}
}
