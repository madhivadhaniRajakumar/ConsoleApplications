package accessFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface AccessModelCallBack {
	boolean checkDB(String filename);
	void writetoFile(String filename,String text) ;
	List<String> searchFileDB(String filename,String searchKey) throws FileNotFoundException, IOException;
	boolean deleteFileDB(String filename);
	boolean renameFileDB(String filename,String filename1);
	boolean editTextFileDB(String olldtext,String newText,String filename) throws IOException ;
}
