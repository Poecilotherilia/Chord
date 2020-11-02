package com.Chord.data;

import com.Chord.tool.SHA1;

public class File {
	public long local;
	public String fileName;
	public String fileInformation;
	public File(String fileName,String fileInformation) {
		this.fileName = fileName;
		this.fileInformation = fileInformation;
		this.local = SHA1.GetHash(fileName);
	}
}
