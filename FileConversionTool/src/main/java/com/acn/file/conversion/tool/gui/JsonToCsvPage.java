package com.acn.file.conversion.tool.gui;

import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import com.acn.file.conversion.tool.constants.FileConversionConstants;

public class JsonToCsvPage extends JPanel {

	JFrame jsonToCsvFrame;

	public JsonToCsvPage() {

		jsonToCsvFrame = new JFrame();
		jsonToCsvFrame.getContentPane().add(this);
		jsonToCsvFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jsonToCsvFrame.setSize(550, 350);
		jsonToCsvFrame.setVisible(true);
		jsonToCsvFrame.setResizable(false);

		JLabel fileConversionToolLabel = new JLabel(
				FileConversionConstants.JSON_TO_CSV, SwingConstants.CENTER);

		JTextField inputFilePathTextField = new JTextField();

		JTextField outputFilePathTextField = new JTextField();

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

		JButton submitButton = new JButton("Submit");

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
		submitButton.setBounds(100, 210, 80, 20);

	}

}
