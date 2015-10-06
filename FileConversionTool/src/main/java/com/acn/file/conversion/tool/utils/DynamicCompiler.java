package com.acn.file.conversion.tool.utils;

import java.util.Arrays;
import java.util.Locale;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticListener;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import com.acn.file.conversion.tool.constants.FileConversionConstants;

public class DynamicCompiler {
	
	/** compile your files by JavaCompiler */
	public void compile(Iterable<? extends JavaFileObject> files) {
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
	

}
