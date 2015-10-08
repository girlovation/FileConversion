package com.acn.file.conversion.tool.listeners;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepListener;
import org.springframework.batch.core.listener.ItemListenerSupport;

import com.acn.file.conversion.tool.vo.DynamicJsonInVO;

public class CustomReadListener extends ItemListenerSupport<DynamicJsonInVO, DynamicJsonInVO> implements StepListener {

    public void beforeStep(StepExecution stepExecution) {
    }

    public void afterRead(DynamicJsonInVO item) {
        System.out.println("Called after read");
    }
}
