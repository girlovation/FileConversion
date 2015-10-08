package com.acn.file.conversion.tool.processor;

import org.springframework.batch.item.ItemProcessor;

import com.acn.file.conversion.tool.vo.DynamicJsonInVO;

public class JsonToCsvProcessor implements ItemProcessor<DynamicJsonInVO,DynamicJsonInVO> {

	public DynamicJsonInVO process(DynamicJsonInVO arg0) throws Exception {
		System.out.println("Inside processor");
		return arg0;
	}

}
