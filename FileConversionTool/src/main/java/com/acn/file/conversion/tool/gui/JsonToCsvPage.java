package com.acn.file.conversion.tool.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

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
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.springframework.batch.core.launch.support.CommandLineJobRunner;

import com.acn.file.conversion.tool.constants.FileConversionConstants;
import com.acn.file.conversion.tool.utils.DynamicCompiler;
import com.acn.file.conversion.tool.utils.DynamicCreateJsonToCsvInVo;
import com.acn.file.conversion.tool.utils.FormatJSONFile;

public class JsonToCsvPage extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1766080291530852959L;
	JFrame jsonToCsvFrame;
	JTextField inputFilePathTextField;
	JTextField outputFilePathTextField;
	ButtonGroup fieldSeparatorRadioGroup;
	private static boolean forceWrapInDoubleQuotes;
	JRadioButton wrapValuesRadioButton;

	/**
	 * @return the forceWrapInDoubleQuotes
	 */
	public static boolean isForceWrapInDoubleQuotes() {
		return forceWrapInDoubleQuotes;
	}

	/**
	 * @param forceWrapInDoubleQuotes
	 *            the forceWrapInDoubleQuotes to set
	 */
	public static void setForceWrapInDoubleQuotes(
			boolean forceWrapInDoubleQuotes) {
		JsonToCsvPage.forceWrapInDoubleQuotes = forceWrapInDoubleQuotes;
	}

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
				FileConversionConstants.COMMA, true);
		JRadioButton comma = new JRadioButton(
				FileConversionConstants.SEMICOLON, false);
		JRadioButton colon = new JRadioButton(FileConversionConstants.COLON,
				false);

		wrapValuesRadioButton = new JRadioButton(
				FileConversionConstants.WRAP_VALUES, false);

		JRadioButton includeHeadersRadioButton = new JRadioButton(
				FileConversionConstants.INCLUDE_HEADERS, false);

		JButton jsonToCsvSubmitButton = new JButton("Submit");

		jsonToCsvSubmitButton.addActionListener(this);

		fieldSeparatorRadioGroup = new ButtonGroup();

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

		fileConversionToolLabel.setFont(new Font(headerFont.getFontName(),
				Font.BOLD, 15));

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

	public String getSelectedButtonText(ButtonGroup buttonGroup) {
		for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons
				.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();

			if (button.isSelected()) {
				if (button.getText().equals(FileConversionConstants.SEMICOLON)) {
					return ";";
				} else if (button.getText().equals(
						FileConversionConstants.COMMA)) {
					return ",";
				} else {
					return ":";
				}
			}
		}

		return null;
	}

	public void actionPerformed(ActionEvent e) {

		if (null != inputFilePathTextField.getText()
				&& !inputFilePathTextField.getText().equalsIgnoreCase("")
				&& null != outputFilePathTextField.getText()
				&& !outputFilePathTextField.getText().equalsIgnoreCase("")) {

			String outputFieldSeperator = getSelectedButtonText(fieldSeparatorRadioGroup);

			if (wrapValuesRadioButton.isSelected()) {
				setForceWrapInDoubleQuotes(true);
			} else {
				setForceWrapInDoubleQuotes(false);
			}


			FormatJSONFile formatJSONFileObj = new FormatJSONFile();
			Map<String, Object> inputHeaderMap = formatJSONFileObj
					.formatJsonFile(inputFilePathTextField.getText(),
							inputFilePathTextField.getText() + ".formatted");

			// dynamiccaly create input VO
			DynamicCreateJsonToCsvInVo dynamicCreateJsonToCsvInVo = new DynamicCreateJsonToCsvInVo();
			DynamicCompiler dynamicCompiler = new DynamicCompiler();
			JavaFileObject javaFileObj = dynamicCreateJsonToCsvInVo.generateJava(
					FileConversionConstants.JSON_INPUT_VO, inputHeaderMap);

			Iterable<? extends JavaFileObject> files = Arrays
					.asList(javaFileObj);

			// Compile input VO by JavaCompiler
			dynamicCompiler.compile(files);

			// compile json line mapper
			File[] mapperFiles = { new File(
					FileConversionConstants.JSON_LINE_MAPPER_PATH) };
			JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
			StandardJavaFileManager fileManager = compiler
					.getStandardFileManager(null, null, null);

			Iterable<? extends JavaFileObject> compilationUnits1 = fileManager
					.getJavaFileObjectsFromFiles(Arrays.asList(mapperFiles));

			dynamicCompiler.compile(compilationUnits1);

			// run the spring batch
			try {
				CommandLineJobRunner.main(new String[] {
						"applicationContext.xml",
						"jsonToCsvBatchJob",
						"inputPath=" + inputFilePathTextField.getText()
								+ ".formatted",
						"outputPath=" + outputFilePathTextField.getText(),
						"outputHeaders=" + FormatJSONFile.outputHeader,
						"outputFieldSeperator=" + outputFieldSeperator });
			} catch (Exception ex) {
				ex.printStackTrace();

				JOptionPane.showMessageDialog(jsonToCsvFrame, ex.getMessage());
			}

		} else {
			JOptionPane.showMessageDialog(jsonToCsvFrame,
					"Please enter both Input and Output file Paths");
		}

	}

}
