package fileManagement;

public class FileManagementControl implements FileManagementControlCallBack{
	FileManagementModelCallBack modelback;
	FileManagementViewCallBack viewback;
	public FileManagementControl(FileManagementViewCallBack fileManagementView) {
		// TODO Auto-generated constructor stub
		viewback = fileManagementView;
		modelback = new FileManagementModel(this);
	}

	public void createfileControl(String filename) {
		String fname = filename+ ".txt";
		modelback.createFileDB(fname);
	}
}
