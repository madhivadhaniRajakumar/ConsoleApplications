package accessFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface AccessControlCallBack {
	boolean fileExistControl(String filename);
	void writeFile(String filename,String text);
	List<String> searchFile(String filename,String searchKey) throws FileNotFoundException, IOException;
	boolean deleteFile(String filename);
	boolean renameFile(String name1,String name2);
	 boolean editTextControl(String oldname,String newname,String fname) throws IOException;
}
