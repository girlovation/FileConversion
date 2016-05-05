package com.acn.file.conversion.tool.constants;

import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.acn.file.conversion.tool.gui.FileConversionEntryPage;

public class FileConversionConstants {
	
	public static final String DOUBLE_QUOTE = "\"";
	
	public static final String BACK_SLASH = "\\";
	
	public static final String JSON_TO_CSV = "Json to CSV";
	
	public static final String INPUT_FILE_PATH = "Enter the Input File path:";
	
	public static final String OUTPUT_FILE_PATH = "Enter the Output File path:";
	
	public static final String OUTPUT_OPTIONS = "Output Options:";
	
	public static final String FIELD_SEPARATOR = "Field Separator:";
	
	public static final String WRAP_VALUES = "Force wrap values in double quotes";
	
	public static final String INCLUDE_HEADERS = "Includes Headers in First row";
	
	public static final String COMMA = "Comma";
	
	public static final String SEMICOLON = "Semicolon";
	
	public static final String COLON = "Colon";
	
	//public static final String CLASS_FOLDER_PATH = ".\\target\\classes";
	
	public static final String CLASS_FOLDER_PATH = FileSystems.getDefault().getPath(System.getProperty("user.home")).toString();

	
	public static final String JSON_INPUT_VO = "DynamicJsonInVO";
	
	public static final String JSON_INPUT_VO_PATH = FileSystems.getDefault().getPath(System.getProperty("user.home"),  "DynamicJsonInVO.java").toString();
	
	//public static final String JSON_LINE_MAPPER_PATH="src\\main\\java\\com\\acn\\file\\conversion\\tool\\utils\\JsonToCsvLineMapper.java";
	
	public static final String JSON_LINE_MAPPER_PATH = FileConversionConstants.class.getClassLoader().getResource("JsonToCsvLineMapper.java").getPath().toString();
	
	

}
