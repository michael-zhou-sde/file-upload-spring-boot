package com.michael.model;

import javax.persistence.*;

@Entity
public class MetaData {
	
	@Id
	private String fileName;
	
	private String fileSize;
	
	private String uploadDate;
	
	public String getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}

	public MetaData(String fileName, String fileSize, String uploadDate){
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.uploadDate = uploadDate;
	}
	
	public MetaData(){
		
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

}
