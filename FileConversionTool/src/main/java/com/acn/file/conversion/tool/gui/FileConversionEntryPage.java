package com.acn.file.conversion.tool.gui;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class FileConversionEntryPage extends JPanel {

	JFrame jframe ;
  public FileConversionEntryPage() {
	  
	   jframe = new JFrame();
	   jframe.getContentPane().add(this);

	    jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    jframe.setSize(300,300);
	    jframe.setVisible(true);
	    jframe.setResizable(false);
	  
	 JLabel fileConversionToolLabel = new JLabel("Next frame",
				SwingConstants.CENTER);
	 
	 JLabel selectionTypeLabel = new JLabel("Helloooooooo",
				SwingConstants.CENTER);
	 
	  
    JRadioButton csvToXmlRadio = new JRadioButton("CSV to XML", true);
    JRadioButton xmlToCsvRadio = new JRadioButton("XML to CSV", false);
    JRadioButton jsonToCsvRadio = new JRadioButton("Json to CSV", false);
    
    JButton submitButton  = new JButton("Submit");
    

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
    
    fileConversionToolLabel.setFont(new Font(font.getFontName(), Font.BOLD, 15));
    

    fileConversionToolLabel.setBounds(50,10,200,20);
    selectionTypeLabel.setBounds(20,70,150,20);
    csvToXmlRadio.setBounds(30, 100, 100, 20);
    xmlToCsvRadio.setBounds(30, 130, 100, 20);
    jsonToCsvRadio.setBounds(30, 160, 100, 20);
    submitButton.setBounds(100,210,80,20);

  }

 

}
