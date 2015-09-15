package com.acn.file.conversion.tool.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.Reader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONObject;

public class FormatJSONFile {

	private static final Logger LOGGER = Logger
			.getLogger(FormatJSONFile.class);

	public Map<String, Object> formatJsonFile(String inputFilePath, String outputFilePath) {

		Map<String, Object> headerForInVoMap = new HashMap<String, Object>();
		try {
			
			System.out.println("Output File path = "+outputFilePath);
			System.out.println("Input File path = "+inputFilePath);
			
			
			File file = new File(inputFilePath);
			Reader reader = new FileReader(file);
			OutputStream out = new FileOutputStream(outputFilePath);
			char[] chars = new char[8192000];
			boolean isFirstLine = true;
			String firstAttribute = "";
			boolean isFirstAttribute = true;
			
			
			for (int len; (len = reader.read(chars)) > 0;) {
				// process chars.
				String s = new String(chars);

				if (isFirstAttribute) {
					int startIndex = s.indexOf("\"");
					int lastIndex = s.indexOf("\"", startIndex + 1);
					firstAttribute = s.substring(startIndex + 1, lastIndex);
					isFirstAttribute = false;
				}

				String searchString = ",\\{\"" + firstAttribute + "\"";
				String replaceString = "\n\\{\"" + firstAttribute + "\"";

				String s1 = s.replaceAll(searchString, replaceString);

				if (isFirstLine) {
					JSONObject jsonObject = new JSONObject(s1.substring(0,
							s1.indexOf("\n")));
					Iterator<String> iterator = jsonObject.keys();
					String outputHeader = "";
					
					
					while (iterator.hasNext()) {
						String key = (String) iterator.next();
						headerForInVoMap.put(key, "String");
						System.out.println(headerForInVoMap);
						if (!isFirstLine) {
							outputHeader = outputHeader.concat(",").concat(key);
							
						} else {
							outputHeader = key;
							isFirstLine = false;
						}

					}
					isFirstLine = false;
				}
				char ch = s1.toString().charAt(0);
				if (ch == '{') {
					StringBuffer sb = new StringBuffer(s1);
					s1 = sb.toString();
					out.write(s1.getBytes(), 0, len);
				}
			}
		
			out.close();
			reader.close();
		

		} catch (Exception e) {
			e.printStackTrace();
		}
		return headerForInVoMap;
	}
}
