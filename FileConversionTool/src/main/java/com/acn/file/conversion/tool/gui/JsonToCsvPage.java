package com.acn.file.conversion.tool.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.acn.file.conversion.tool.constants.FileConversionConstants;
import com.acn.file.conversion.tool.utils.FormatJSONFile;

public class JsonToCsvPage extends JPanel implements ActionListener{

	JFrame jsonToCsvFrame;
	JTextField inputFilePathTextField;
	JTextField outputFilePathTextField ;

	public JsonToCsvPage() {

		jsonToCsvFrame = new JFrame();
		jsonToCsvFrame.getContentPane().add(this);
		jsonToCsvFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jsonToCsvFrame.setSize(550, 350);
		jsonToCsvFrame.setVisible(true);
		jsonToCsvFrame.setResizable(false);

		JLabel fileConversionToolLabel = new JLabel(
				FileConversionConstants.JSON_TO_CSV, SwingConstants.CENTER);

		 inputFilePathTextField = new JTextField();

		 outputFilePathTextField = new JTextField();

		JLabel inputFilePathLabel = new JLabel(
				FileConversionConstants.INPUT_FILE_PATH);

		JLabel outputFilePathLabel = new JLabel(
				FileConversionConstants.OUTPUT_FILE_PATH);

		JLabel outputOptionsLabel = new JLabel(
				FileConversionConstants.OUTPUT_OPTIONS);

		JLabel outputFieldSeparatorTextField = new JLabel(
				FileConversionConstants.FIELD_SEPARATOR);

		JRadioButton semiColon = new JRadioButton(
				FileConversionConstants.SEMICOLON, true);
		JRadioButton comma = new JRadioButton(FileConversionConstants.COMMA,
				false);
		JRadioButton colon = new JRadioButton(FileConversionConstants.COLON,
				false);

		JRadioButton wrapValuesRadioButton = new JRadioButton(
				FileConversionConstants.WRAP_VALUES, false);

		JRadioButton includeHeadersRadioButton = new JRadioButton(
				FileConversionConstants.INCLUDE_HEADERS, false);

		JButton jsonToCsvSubmitButton = new JButton("Submit");
		
		jsonToCsvSubmitButton.addActionListener(this);

		ButtonGroup fieldSeparatorRadioGroup = new ButtonGroup();

		fieldSeparatorRadioGroup.add(semiColon);
		fieldSeparatorRadioGroup.add(comma);
		fieldSeparatorRadioGroup.add(colon);

		setLayout(null);

		add(fileConversionToolLabel);
		add(inputFilePathLabel);
		add(outputFilePathLabel);
		add(outputOptionsLabel);
		add(outputFieldSeparatorTextField);
		add(semiColon);
		add(comma);
		add(colon);
		add(inputFilePathTextField);
		add(outputFilePathTextField);
		add(wrapValuesRadioButton);
		add(includeHeadersRadioButton);
		add(jsonToCsvSubmitButton);

		Font headerFont = fileConversionToolLabel.getFont();

		fileConversionToolLabel.setFont(new Font(headerFont.getFontName(), Font.BOLD,
				15));

		fileConversionToolLabel.setBounds(50, 10, 200, 20);
		inputFilePathLabel.setBounds(30, 70, 250, 20);
		inputFilePathTextField.setBounds(200, 70, 300, 20);
		outputFilePathLabel.setBounds(30, 100, 200, 20);
		outputFilePathTextField.setBounds(200, 100, 300, 20);
		outputOptionsLabel.setBounds(30, 130, 100, 20);
		outputFieldSeparatorTextField.setBounds(30, 160, 100, 20);
		semiColon.setBounds(140, 160, 100, 20);
		comma.setBounds(250, 160, 100, 20);
		colon.setBounds(350, 160, 100, 20);
		wrapValuesRadioButton.setBounds(30, 190, 280, 20);
		includeHeadersRadioButton.setBounds(30, 220, 280, 20);
		jsonToCsvSubmitButton.setBounds(220, 280, 100, 20);

	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(null !=inputFilePathTextField.getText() && !inputFilePathTextField.getText().equalsIgnoreCase("") &&
				null !=outputFilePathTextField.getText() && !outputFilePathTextField.getText().equalsIgnoreCase("")){
			
			FormatJSONFile formatJSONFileObj = new FormatJSONFile();
			formatJSONFileObj.formatJsonFile(inputFilePathTextField.getText(), outputFilePathTextField.getText());
		
		}else{
			JOptionPane.showMessageDialog(jsonToCsvFrame,"Please enter both Input and Output file Paths");
		}
	
		
	}

}
