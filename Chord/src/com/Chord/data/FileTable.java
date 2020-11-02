package com.Chord.data;

import java.sql.Ref;
import java.util.HashMap;

import com.Chord.tool.SHA1;

public class FileTable {
	HashMap<Long,File> files = new HashMap<Long,File>();
	public FileTable(){}
	public void AddFile(String fileName ,String fileInformation) {
		files.put(SHA1.GetHash(fileName),new File(fileName,fileInformation));
	}
	public void DeleteFile(long fileLocal) {
		files.remove(fileLocal);
	}
	
	public File FindFile(long fileLocal) {
		if(files.containsKey(fileLocal)) {
			return files.get(fileLocal);
		}else {
			return null;
		}
	}
}