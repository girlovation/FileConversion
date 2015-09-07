package com.acn.file.conversion.tool.gui;
/**
 * 
 */

/**
 * @author atasi.dutta
 *
 */
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class FileConversionEntryPage {
	
	
	public static final int DEFAULT_WIDTH = 400;
	public static final int DEFAULT_HEIGHT = 200;
	private JPanel buttonPanel;
	private ButtonGroup group;
	private static final int DEFAULT_SIZE = 12;
	private JLabel outsideLabel;
	private JLabel insideLabel;


	public void start() 
	{ 
		JFrame frame=new JFrame(); 
		//Add Jlabel
		outsideLabel = new JLabel("File Conversion Tool",SwingConstants.CENTER);
		outsideLabel.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 2));
		insideLabel = new JLabel("Select File Comversion Type",SwingConstants.RIGHT);
		outsideLabel.add(insideLabel);
       //Add Radio Button
		buttonPanel  = new JPanel();
	    group = new ButtonGroup();

	      addRadioButton("JSONToCSV", 8);
	      addRadioButton("XMLToCSV", 8);
	      addRadioButton("CSVToXML", 8);
	     
	      outsideLabel.add(buttonPanel,BorderLayout.CENTER);
	      
	      
		frame.getContentPane().add(outsideLabel); 
		frame.setSize(200,200); 
		frame.setVisible(true); 
		} 
	public static void main(String args[]) 
	{ 
		new FileConversionEntryPage().start(); 
		}

	   /**
	    * Adds a radio button that sets the font size of the sample text.
	    * @param name the string to appear on the button
	    * @param size the font size that this button sets
	    */
	   public void addRadioButton(String name, final int size)
	   {
	      boolean selected = size == DEFAULT_SIZE;
	      JRadioButton button = new JRadioButton(name, selected);
	      group.add(button);
	      buttonPanel.add(button);

	  
	   }

}
