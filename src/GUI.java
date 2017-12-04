import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;
import java.io.*;

public class GUI extends JFrame implements java.io.Serializable{

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		Quiz quiz = new Quiz(100);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 857, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblQuizMaker = new JLabel("Quiz Maker 5000");
		lblQuizMaker.setBounds(347, 13, 110, 16);
		contentPane.add(lblQuizMaker);
		
		JLabel lblAddQuestion = new JLabel("Add Question: ");
		lblAddQuestion.setBounds(26, 113, 85, 16);
		contentPane.add(lblAddQuestion);
		
		textField = new JTextField();
		textField.setBounds(118, 110, 349, 47);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblChooseAnswerType = new JLabel("Choose Answer Type");
		lblChooseAnswerType.setBounds(55, 205, 131, 16);
		contentPane.add(lblChooseAnswerType);
		
		textField_1 = new JTextField();
		textField_1.setBounds(130, 246, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		
		JLabel lblShortAnswer = new JLabel("Short Answer:");
		lblShortAnswer.setBounds(12, 249, 99, 16);
		contentPane.add(lblShortAnswer);
		ButtonGroup group = new ButtonGroup();
		ButtonGroup group2 = new ButtonGroup();
		
		
		JRadioButton rdbtnShortAnswer = new JRadioButton("Short Answer");
		rdbtnShortAnswer.setBounds(245, 201, 127, 25);
		contentPane.add(rdbtnShortAnswer);
		
		JRadioButton rdbtnMulitpleChoice = new JRadioButton("Mulitple Choice ");
		rdbtnMulitpleChoice.setBounds(381, 201, 127, 25);
		contentPane.add(rdbtnMulitpleChoice);
		
		JRadioButton rdbtnMultipleAnswer = new JRadioButton("Multiple answer");
		rdbtnMultipleAnswer.setBounds(522, 201, 127, 25);
		contentPane.add(rdbtnMultipleAnswer);
		
		group.add(rdbtnMultipleAnswer);
		group.add(rdbtnMulitpleChoice);
		group.add(rdbtnShortAnswer);
		
		JRadioButton radioButton = new JRadioButton("");
		radioButton.setBounds(163, 310, 127, 25);
		contentPane.add(radioButton);
		
		JRadioButton rdbt = new JRadioButton("");
		rdbt.setBounds(293, 310, 127, 25);
		contentPane.add(rdbt);
		
		JRadioButton radioButton_1 = new JRadioButton("");
		radioButton_1.setBounds(424, 310, 127, 25);
		contentPane.add(radioButton_1);
		
		JRadioButton radioButton_2 = new JRadioButton("");
		radioButton_2.setBounds(563, 310, 127, 25);
		contentPane.add(radioButton_2);
		
		group2.add(radioButton_1);
		group2.add(radioButton_2);
		group2.add(rdbt);
		group2.add(radioButton);
		
		String question = textField.getText();
		String answer;
		
		
		
		JButton btnAddQuestionWhen = new JButton("ADD Question when done");
		btnAddQuestionWhen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(group.getSelection() == rdbtnMultipleAnswer) {
					// about to kms 
				}
				else if(group.getSelection()==rdbtnMulitpleChoice) {
					String[] answersArr = new String[4];
					answersArr[0]=textField_6.getText();
					answersArr[1]=textField_7.getText();
					answersArr[2]=textField_8.getText();
					answersArr[3]=textField_9.getText();
					if(group2.getSelection()==radioButton) {
						quiz.add(new MultipleChoiceQuestion(question,textField_6.getText(),answersArr));
					}
					else if(group2.getSelection()== rdbt) {
						quiz.add(new MultipleChoiceQuestion(question,textField_7.getText(),answersArr));
					}
					else if(group2.getSelection()==radioButton_1) {
						quiz.add(new MultipleChoiceQuestion(question,textField_8.getText(),answersArr));
					}
					else {
						quiz.add(new MultipleChoiceQuestion(question,textField_9.getText(),answersArr));
					}
					//quiz.add(new MulitpleChoiceQuesiton(question,));
				}
				else {
				quiz.add(new Question(question,textField.getText()));
				
				}
				
				group.clearSelection();
				group2.clearSelection();
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");
				textField_9.setText("");

				// add question to quiz here
				// clear console 
			}
		});
		btnAddQuestionWhen.setBounds(326, 421, 198, 25);
		contentPane.add(btnAddQuestionWhen);
			
		JButton btnWhenDoneWith = new JButton("When done with Entire Quiz");
		btnWhenDoneWith.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FileOutputStream fos = null;
				try {
					fos = new FileOutputStream("test3.bin");
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				try {
					ObjectOutputStream oos = new ObjectOutputStream(fos);
					oos.writeObject(quiz);
					oos.close();
					System.exit(0); 
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//load quiz into a binary file :(
			}
		});
		btnWhenDoneWith.setBounds(26, 450, 220, 25);
		contentPane.add(btnWhenDoneWith);
		
		JLabel lblMultipleChoice = new JLabel("Multiple Choice:");
		lblMultipleChoice.setBounds(12, 295, 99, 16);
		contentPane.add(lblMultipleChoice);
		
		textField_2 = new JTextField();
		textField_2.setBounds(130, 292, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(258, 292, 116, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(392, 292, 116, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(533, 292, 116, 22);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblMultipleAnswer = new JLabel("Multiple Answer:");
		lblMultipleAnswer.setBounds(12, 347, 99, 16);
		contentPane.add(lblMultipleAnswer);
		
		textField_6 = new JTextField();
		textField_6.setBounds(130, 344, 116, 22);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(258, 344, 116, 22);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(392, 344, 116, 22);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		textField_9.setBounds(533, 344, 116, 22);
		contentPane.add(textField_9);
		textField_9.setColumns(10);
		
		JLabel lblIfCorrect = new JLabel("If Correct:");
		lblIfCorrect.setBounds(26, 372, 71, 16);
		contentPane.add(lblIfCorrect);
		
		JCheckBox checkBox = new JCheckBox("");
		checkBox.setBounds(152, 368, 113, 25);
		contentPane.add(checkBox);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBounds(268, 368, 113, 25);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox checkBox_1 = new JCheckBox("");
		checkBox_1.setBounds(402, 368, 113, 25);
		contentPane.add(checkBox_1);
		
		JCheckBox checkBox_2 = new JCheckBox("");
		checkBox_2.setBounds(536, 368, 113, 25);
		contentPane.add(checkBox_2);
		
		JLabel lblChooseCorrect = new JLabel("Choose Correct:");
		lblChooseCorrect.setBounds(26, 310, 116, 16);
		contentPane.add(lblChooseCorrect);
		
		// if statement asking which choice was selected then making a question based on info 
	}
}
