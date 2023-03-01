package fileManagement;

import java.io.File;
import java.io.IOException;

public class FileManagementModel implements FileManagementModelCallBack {
	FileManagementControlCallBack control;
	public FileManagementModel(FileManagementControl fileManagementControl) {
		// TODO Auto-generated constructor stub
		control = fileManagementControl;
	}

	public void createFileDB(String filename) {
		String filepath = "C:\\Users\\Saara\\NotesApplication\\src\\repository\\"+filename;
		File f = new File(filepath);
		try {
			if(f.createNewFile()) {
				System.out.println("File created "+ f.getName());
			}
			else {
				System.out.println("File Already Exits");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
