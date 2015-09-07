package com.acn.file.conversion.tool.gui;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import com.sun.org.apache.regexp.internal.recompile;

public class TestPage extends JPanel {
	
	private static JFrame frame;

  public TestPage() {
	  
	 JLabel fileConversionToolLabel = new JLabel("File Conversion Tool",
				SwingConstants.CENTER);
	 
	 JLabel selectionTypeLabel = new JLabel("Select Converion Type",
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

    submitButton.addActionListener( new ActionListener() {
    	public void actionPerformed(java.awt.event.ActionEvent e) {
    		 
    		   frame.setVisible(false);
    		   frame.dispose();
    		   
    		   FileConversionEntryPage newFrameObj =  new FileConversionEntryPage();
    		   newFrameObj.jframe.repaint();
    		 
    		  
    		}
    });
    
    
  }

  public static void main(String[] args) {
    frame = new JFrame();
    frame.getContentPane().add(new TestPage());

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300,300);
    frame.setVisible(true);
    frame.setResizable(false);
  }
  
  
  
}
