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
	private JLabel outerLabelPageName;
	private JLabel insideLabelSelectionType;


	public void start() 
	{ 
		JFrame frame=new JFrame(); 
		//Add Jlabel
		outerLabelPageName = new JLabel("File Conversion Tool",SwingConstants.CENTER);
		outerLabelPageName.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 2));
		insideLabelSelectionType = new JLabel("Select File Comversion Type",SwingConstants.RIGHT);
		outerLabelPageName.add(insideLabelSelectionType);
       //Add Radio Button
		buttonPanel  = new JPanel();
	    group = new ButtonGroup();

	      addRadioButton("JSONToCSV", 8);
	      addRadioButton("XMLToCSV", 8);
	      addRadioButton("CSVToXML", 8);
	     
	      outerLabelPageName.add(buttonPanel,BorderLayout.CENTER);
	      
	      
		frame.getContentPane().add(outerLabelPageName); 
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
