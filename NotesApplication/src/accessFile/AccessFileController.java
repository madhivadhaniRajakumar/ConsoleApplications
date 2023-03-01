package accessFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AccessFileController implements AccessControlCallBack{

	AccessViewCallBack viewback;
	AccessModelCallBack modelback;
	public AccessFileController(AccessViewCallBack accessFileView) {
		// TODO Auto-generated constructor stub
		viewback = accessFileView;
		modelback = new AccessFileModel(this);
	}

	public boolean fileExistControl(String filename) {
		String fname = filename+".txt";
		if(modelback.checkDB(fname))
			return true;
		return false;
	}
	public void writeFile(String filename,String text) {
		String fname = filename+".txt";
		modelback.writetoFile(fname, text);
	}
	public List<String> searchFile(String filename,String searchKey) throws IOException{
		String fname = filename+ ".txt";
		List<String> ls=modelback.searchFileDB(fname, searchKey);
		return ls;
	}
	
	public boolean deleteFile(String filename) {
		String fname = filename+".txt";
		if(modelback.deleteFileDB(fname))
			return true;
		return false;
	}

	public boolean renameFile(String name1,String name2) {
		String file1name = name1+".txt";
		String file2name = name2+".txt";
		if(modelback.renameFileDB(file1name, file2name)) {
			return true;
		}
		return false;
	}
	public boolean editTextControl(String oldname,String newname,String fname) throws IOException {
		String filename = fname+".txt";
		if(modelback.editTextFileDB(oldname, newname, filename)) {
			return true;
		}
		return false;
	}
	
}
