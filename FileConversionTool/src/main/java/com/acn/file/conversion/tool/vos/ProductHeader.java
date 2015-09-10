package com.acn.file.conversion.tool.vos;

import java.io.IOException;
import java.io.Writer;

import org.springframework.batch.item.file.FlatFileHeaderCallback;

public class ProductHeader implements FlatFileHeaderCallback {

	public void writeHeader(Writer writer) throws IOException {
		 writer.write("identifier,brand,description,finalOfferDescription,merchandiseHierarchy/segmentId,merchandiseHierarchy/segment,merchandiseHierarchy/familyId,merchandiseHierarchy/family,merchandiseHierarchy/classId,merchandiseHierarchy/class,merchandiseHierarchy/brickId,merchandiseHierarchy/brick,merchandiseHierarchy/subBrickId,merchandiseHierarchy/subBrick,subTeamId,size,uom");
	}

}
