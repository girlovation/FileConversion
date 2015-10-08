package com.acn.file.conversion.tool.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticListener;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import com.acn.file.conversion.tool.constants.FileConversionConstants;
import com.acn.file.conversion.tool.utils.DynamicCompiler.InMemoryJavaFileObject;

public class CreateDynamicClass {

	public JavaFileObject generateJava(String className, Map<String, Object> map) {

		StringBuffer classContent = new StringBuffer(
				"package com.acn.file.conversion.tool.vo; \n import java.util.LinkedHashMap; \n  public class ")
				.append(className).append(" {\n");

		// first fields
		for (Entry<String, Object> field : map.entrySet()) {
			String name = field.getKey();
			String type = field.getValue().getClass().getName();
			classContent.append("\tprivate ").append(type).append(" ")
					.append(name).append(";\n");
		}

		// then getters and setters
		for (Entry<String, Object> field : map.entrySet()) {
			String name = field.getKey();
			String type = field.getValue().getClass().getName();
			classContent.append("\n\n");

			// getter.

			classContent.append("\tpublic ").append(type).append(" get")
					.append(name.substring(0, 1).toUpperCase())
					.append(name.substring(1)).append("() {\n\t\t");
			classContent.append("return this.").append(name).append(";\n\t}");

			// setter.
			classContent.append("\tpublic void").append(" set")
					.append(name.substring(0, 1).toUpperCase())
					.append(name.substring(1)).append("(").append(type)
					.append(" ").append(name).append(") {\n\t\t");
			classContent.append("this.").append(name).append(" = ")
					.append(name).append(";\n\t}");
		}

		// hardcoded method signature

		classContent
				.append("\n\n\t public static DynamicJsonInVO setAllFields(LinkedHashMap<String, Object> valueMap) { \n\t\t DynamicJsonInVO tempDynamicObj = new DynamicJsonInVO();\n");

		for (Entry<String, Object> field : map.entrySet()) {
			String fieldName = field.getKey();

			classContent
					.append("\t\t\t tempDynamicObj.set")
					.append(fieldName.substring(0, 1).toUpperCase())
					.append(fieldName.substring(1))
					.append("(valueMap.get(\"" + fieldName
							+ "\").toString()); \n");
		}

		classContent.append(" \t\t return tempDynamicObj; \n } \n }");

		System.out.println("value=" + classContent);
		JavaFileObject javaFileObj = null;

		try {

			File file = new File(FileConversionConstants.JSON_INPUT_VO_PATH);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(classContent.toString());
			bw.close();

			javaFileObj = new InMemoryJavaFileObject(
					"com.acn.file.conversion.tool.vo.DynamicJsonInVO",
					classContent.toString());

		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return javaFileObj;
	}


	public static class MyDiagnosticListener implements
			DiagnosticListener<JavaFileObject> {
		public void report(Diagnostic<? extends JavaFileObject> diagnostic) {

			System.out.println("Line Number->" + diagnostic.getLineNumber());
			System.out.println("code->" + diagnostic.getCode());
			System.out.println("Message->"
					+ diagnostic.getMessage(Locale.ENGLISH));
			System.out.println("Source->" + diagnostic.getSource());
			System.out.println(" ");
		}
	}


	public void compile(Iterable<? extends JavaFileObject> files){
		// get system compiler:
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

		// for compilation diagnostic message processing on compilation
		// WARNING/ERROR
		MyDiagnosticListener diagnosticListner = new MyDiagnosticListener();
		StandardJavaFileManager fileManager = compiler.getStandardFileManager(
				diagnosticListner, Locale.ENGLISH, null);
		// specify classes output folder
		Iterable options = Arrays.asList("-d",
				FileConversionConstants.CLASS_FOLDER_PATH);
		
		JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager,
				diagnosticListner, options, null, files);
		Boolean result = task.call();
		if (result == true) {
			System.out.println("Succeeded");
		}
	}

	public void compileNonDynamicClass(File file, String JavaClassName){
		
		File root = new File(FileConversionConstants.CLASS_FOLDER_PATH + "\\com\\acn\\file\\conversion\\tool\\utils\\");
		// Compile source file.
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		int i = compiler.run(null, null, null, file.getAbsolutePath());

		// Load and instantiate compiled class.
		URLClassLoader classLoader;
		Class<?> cls;
		Object instance = null;
		try {
			classLoader = URLClassLoader.newInstance(new URL[] { root.toURI().toURL() });
			cls = Class.forName(JavaClassName);
			instance = cls.newInstance();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}
	
}
