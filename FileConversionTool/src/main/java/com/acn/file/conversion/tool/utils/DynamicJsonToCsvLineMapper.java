package com.acn.file.conversion.tool.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.tools.JavaFileObject;

import com.acn.file.conversion.tool.constants.FileConversionConstants;
import com.acn.file.conversion.tool.utils.DynamicCompiler.InMemoryJavaFileObject;

public class DynamicJsonToCsvLineMapper {

	public JavaFileObject generateJavaLineMapper() {

		System.out.println("in DynamicJsonToCsvLineMapper");
		StringBuffer classContent = new StringBuffer(
				"package com.acn.file.conversion.tool.utils; \n import java.util.LinkedHashMap; \n import org.springframework.batch.item.file.LineMapper; \n import org.springframework.batch.item.file.mapping.JsonLineMapper; \n  import com.acn.file.conversion.tool.vo.DynamicJsonInVO; \n public class JsonToCsvLineMapper implements LineMapper<DynamicJsonInVO> { \n private JsonLineMapper delegate; \n public JsonLineMapper getDelegate() { \n 	return delegate; \n } \n public void setDelegate(JsonLineMapper delegate) { \n this.delegate = delegate; \n } \n public DynamicJsonInVO mapLine(String line, int lineNumber) throws Exception { \n LinkedHashMap<String, Object> recordAsMap = (LinkedHashMap<String, Object>) delegate.mapLine(line, lineNumber); \n return DynamicJsonInVO.setAllFields(recordAsMap); \n }}");

		JavaFileObject javaFileObj = null;

		try {

			File file = new File(
					FileConversionConstants.JSON_INPUT_LINE_MAPPER_PATH);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(classContent.toString());
			bw.close();

			javaFileObj = new InMemoryJavaFileObject(
					"com.acn.file.conversion.tool.utils.JsonToCsvLineMapper",
					classContent.toString());

		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return javaFileObj;
	}

}
