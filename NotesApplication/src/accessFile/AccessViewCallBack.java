package accessFile;

import java.io.File;
import java.io.IOException;

public interface AccessViewCallBack {
	void checkForFileView() throws IOException;
	void displayAccess(String filename) throws IOException;
	 void witeFile(String filename);
	 void searchTextFile(String filename) throws IOException;
	 void deleteFileView(String filename);
	 void renameFileView(String filename);
	 void editTextFileView(String filename) throws IOException ;	
}
