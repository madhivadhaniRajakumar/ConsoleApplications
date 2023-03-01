package accessFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import fileManagement.FileManagementView;

public class AccessFileView implements AccessViewCallBack{
	InputStreamReader i = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(i);
	static AccessFileView av = new AccessFileView();
	Exception e;
	
	AccessFileController controller ;
	public AccessFileView() {
		// TODO Auto-generated constructor stub
		controller = new AccessFileController(this);
	}
//	public static void main(String[] args) throws IOException {
//		av.checkForFileView();
//	}
   public void checkForFileView() throws IOException {
	   System.out.println("Enter the File Name");
	   String filename = null;
	   try {
		filename=br.readLine();
		if(filename.contains(" "))
			throw e;
	} catch (Exception e) {
		System.out.println("Enter Valid File Name");
		av.checkForFileView();
	}
	  if(controller.fileExistControl(filename))
		  av.displayAccess(filename);
	  else {
		System.out.println("File not available");
	  }
   }
   public void displayAccess(String filename) throws IOException {
	   System.out.println("Press 1 to write to your file");
	   System.out.println("Press 2 to search in your file");
	   System.out.println("Press 3 to delete your file");
	   System.out.println("Press 4 to rename your file");
	   System.out.println("Press 5 to Edit your file");;
	   
	   int option = 0;
	   try {
		   option = Integer.parseInt(br.readLine());
		   if(option!=1 && option!=2 && option!=3 && option!=4 && option!=5) {
			   throw e;
		   }
	   }
	   catch(Exception e) {
		   System.out.println("Enter Valid Option");
		   av.displayAccess(filename);
	   }
	   if(option==1) {
		   av.witeFile(filename);
		   av.displayAccess(filename);
	   }
	   if(option==2) {
		   av.searchTextFile(filename);
		   av.displayAccess(filename);
	   }
	   if(option==3) {
		   av.deleteFileView(filename);
		   FileManagementView fv = new FileManagementView();
		   fv.displayMenu();
	   }
	   if(option==4) {
		  av.renameFileView(filename);
		  av.displayAccess(filename);
	   }
	   if(option==5) {
		   av.editTextFileView(filename);
		   av.displayAccess(filename);
	   }
   }
   public void witeFile(String filename) {
	   System.out.println("Enter text");
	   try {
		   String text="";
		while(!text.equals("END_FILE_STOP")) {
			controller.writeFile(filename, text+"\n");
			text =br.readLine();
		}
		System.out.println("File Saved");
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
   }
   public void searchTextFile(String filename) throws IOException {
	   List<String> ls = new ArrayList<>();
	   System.out.println("Enter Search Key");
	   String key = br.readLine();
	   ls=controller.searchFile(filename, key);
	   if(ls.isEmpty()) {
		   System.out.println("No Match Found");
	   }
	   else {
		   for(int i=0;i<ls.size();i++) {
			   System.out.println(ls.get(i));
		   }
	   }
	   
   }
   public void deleteFileView(String filename) {
	   if(controller.deleteFile(filename))
		   System.out.println("File Deleted Successfully");
	   else
		   System.out.println("Unable to delete the file");
   }
   
   public void renameFileView(String filename) {
	   System.out.println("Enter the filename to replace");
	   String name2=null;
	try {
		name2 = br.readLine();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  if( controller.renameFile(filename, name2)) {
		  System.out.println("Successfully renamed the file");
	  }
	  else {
		  System.out.println("Failed to rename the file");
	  }
   }
   public void editTextFileView(String filename) throws IOException {
	  
	   List<String> ls = new ArrayList<>();
	   System.out.println("Enter a key to search for modification");
	   String key = br.readLine();
	   ls=controller.searchFile(filename, key);
	   if(ls.isEmpty()) {
		   System.out.println("No Match Found");
		   av.editTextFileView(filename);
	   }
	   else {
		   for(int i=0;i<ls.size();i++) {
			   System.out.println(ls.get(i));
		   }
	   }
	   System.out.println("Enter the string that you wish to modify");
	   String oldtext = br.readLine();
	   System.out.println("Enter the string for modification");
	   String newtext = br.readLine();
	   if(controller.editTextControl(oldtext, newtext, filename)) {
		   System.out.println("File edited");
	   }
	   else {
		   System.out.println("Unable to edit the file");
	   }
	   
   }
}
