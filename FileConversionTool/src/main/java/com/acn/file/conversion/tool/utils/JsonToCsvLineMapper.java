package com.acn.file.conversion.tool.utils;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.JsonLineMapper;

import com.acn.file.conversion.tool.vos.JsonToCsvInputVO;

public class JsonToCsvLineMapper implements LineMapper<JsonToCsvInputVO> {
	// private static final Logger LOGGER =
	// Logger.getLogger(JsonToCsvLineMapper.class);
	private JsonLineMapper delegate;

	public JsonLineMapper getDelegate() {
		return delegate;
	}

	public void setDelegate(JsonLineMapper delegate) {
		this.delegate = delegate;
	}

	public JsonToCsvInputVO mapLine(String line, int lineNumber)
			throws Exception {

		LinkedHashMap<String, Object> recordAsMap = (LinkedHashMap<String, Object>) delegate
				.mapLine(line, lineNumber);

		/*for (Map.Entry<String, Object> entry : recordAsMap.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
			
		}*/

		Set<String> keys = recordAsMap.keySet();

		JsonToCsvInputVO jsonToCsvInputVO = new JsonToCsvInputVO();

		if (recordAsMap.get("modified") == null) {
			keys.remove("modified");
			jsonToCsvInputVO.setModified("null");
		} else {
			jsonToCsvInputVO
					.setModified(recordAsMap.get("modified").toString());
		}

		if (recordAsMap.get("identifier") == null) {
			jsonToCsvInputVO.setIdentifier("null");
		} else {
			jsonToCsvInputVO.setIdentifier(recordAsMap.get("identifier")
					.toString());
		}

		if (recordAsMap.get("brand") == null) {
			jsonToCsvInputVO.setBrand("null");
		} else {
			jsonToCsvInputVO.setBrand(recordAsMap.get("brand").toString());
		}

		return jsonToCsvInputVO;
	}
}
