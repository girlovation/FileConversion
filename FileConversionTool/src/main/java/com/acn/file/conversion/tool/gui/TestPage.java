package com.acn.file.conversion.tool.gui;
//Temp changes

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import com.sun.org.apache.regexp.internal.recompile;

public class TestPage extends JPanel implements ActionListener {

	JFrame frame;

	public TestPage() {

		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
		frame.setResizable(false);

		JLabel fileConversionToolLabel = new JLabel("File Conversion Tool",
				SwingConstants.CENTER);

		JLabel selectionTypeLabel = new JLabel("Select Converion Type",
				SwingConstants.CENTER);

		JRadioButton csvToXmlRadio = new JRadioButton("CSV to XML", true);
		JRadioButton xmlToCsvRadio = new JRadioButton("XML to CSV", false);
		JRadioButton jsonToCsvRadio = new JRadioButton("Json to CSV", false);

		JButton submitButton = new JButton("Submit");

		ButtonGroup radioGroup = new ButtonGroup();

		setLayout(null);

		add(fileConversionToolLabel);
		add(selectionTypeLabel);
		add(csvToXmlRadio);
		add(xmlToCsvRadio);
		add(jsonToCsvRadio);
		add(submitButton);

		radioGroup.add(csvToXmlRadio);
		radioGroup.add(xmlToCsvRadio);
		radioGroup.add(jsonToCsvRadio);

		Font font = fileConversionToolLabel.getFont();

		fileConversionToolLabel.setFont(new Font(font.getFontName(), Font.BOLD,
				15));

		fileConversionToolLabel.setBounds(50, 10, 200, 20);
		selectionTypeLabel.setBounds(20, 70, 150, 20);
		csvToXmlRadio.setBounds(30, 100, 100, 20);
		xmlToCsvRadio.setBounds(30, 130, 100, 20);
		jsonToCsvRadio.setBounds(30, 160, 100, 20);
		submitButton.setBounds(100, 210, 80, 20);

		submitButton.addActionListener(this);

	}

	public static void main(String[] args) {
		TestPage obj = new TestPage();
		obj.frame.getContentPane().add(obj);

		

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Action Performed = " + e.getSource());
		this.frame.setVisible(false);
		this.frame.dispose();

		FileConversionEntryPage newFrameObj = new FileConversionEntryPage();
		newFrameObj.setVisible(true);
		//newFrameObj.jframe.repaint();

	}

}
