package fileManagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import accessFile.AccessFileView;

public class FileManagementView implements FileManagementViewCallBack {
	InputStreamReader i = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(i);
	Exception e;
	static FileManagementView fv = new FileManagementView();
	FileManagementControl control;
	
	public FileManagementView() {
		control = new FileManagementControl(this);
	
	}
	public static void main(String[] args) {
		fv.displayMenu();
	}
	public void displayMenu() {
		System.out.println("******Welcome to Notes Making Application*********");
		System.out.println("Press 1 to create a new file");
		System.out.println("Press 2 to access the existing file");
		int option=0;
		try {
			option=Integer.parseInt(br.readLine());
			if(option!=1 && option!=2) {
				throw e;
			}
		} catch (Exception e) {
			System.out.println("Please Enter valid option");
			fv.displayMenu();
		} 
		if(option==1) {
			System.out.println("Enter the file name");
			String filename =null;
			try {
				 filename = br.readLine();
				if(filename.contains(" "))
					throw e;
			} catch (Exception e) {
				System.out.println("Invalid File name");
				fv.displayMenu();
			}
			control.createfileControl(filename);
			fv.displayMenu();
		}
		if(option==2) {
			AccessFileView av = new AccessFileView();
			try {
				av.checkForFileView();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
