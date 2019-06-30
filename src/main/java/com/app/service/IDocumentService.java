package com.app.service;

import java.util.List;

import com.app.model.Document;

public interface IDocumentService {
	
	public Integer saveDocument(Document doc);
	public List<Object[]> getDocsIdAndNames();
	public Document getDocumentById(Integer id);

}
