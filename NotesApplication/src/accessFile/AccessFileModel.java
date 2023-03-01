package accessFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccessFileModel implements AccessModelCallBack {
	static AccessFileModel am = new AccessFileModel();
	AccessControlCallBack controller;
	BufferedWriter bw ;
	FileWriter writer ;
	public AccessFileModel() {
		// TODO Auto-generated constructor stub
	}
		public AccessFileModel(AccessControlCallBack accessFileController) {
		// TODO Auto-generated constructor stub
			controller = accessFileController;
	}

		public boolean checkDB(String filename) {
			String filepath = "C:\\Users\\Saara\\NotesApplication\\src\\repository\\"+filename;
			File file = new File(filepath);
			if(file.exists())
				return true;
			return false;
		}
		public void writetoFile(String filename,String text) {
			
			String filepath = "C:\\Users\\Saara\\NotesApplication\\src\\repository\\"+filename;
			File file = new File(filepath);
			try {
			   writer = new FileWriter(file,true);
				bw = new BufferedWriter(writer);
				bw.write(text);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					bw.close();
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		public List<String> searchFileDB(String filename,String searchKey) throws IOException{
			List<String> ls = new ArrayList<>();
			String filepath = "C:\\Users\\Saara\\NotesApplication\\src\\repository\\"+filename;
			File file = new File(filepath);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String str;
			try {
				while((str=br.readLine())!=null) {
					if(str.contains(searchKey)) {
						ls.add(str);
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				br.close();
				fr.close();
			}
			return ls;
		}
		public boolean deleteFileDB(String filename) {
			String filepath = "C:\\Users\\Saara\\NotesApplication\\src\\repository\\"+filename;
			File file = new File(filepath);
			System.out.println(file.getAbsolutePath());
			if(file.delete()) {
				System.out.println("Deleted");
				return true;
			}
			return false;
		}
		public boolean renameFileDB(String filename,String filename1) {
			String file1path ="C:\\Users\\Saara\\NotesApplication\\src\\repository\\"+filename;
			String file2path ="C:\\Users\\Saara\\NotesApplication\\src\\repository\\"+filename1;
			File file1 = new File(file1path);
			File file2 = new File(file2path);
			return file1.renameTo(file2);
			
		}
		public boolean editTextFileDB(String oldtext,String newText,String filename) throws IOException {
			String filepath ="C:\\Users\\Saara\\NotesApplication\\src\\repository\\"+filename;
			StringBuffer buffer = new StringBuffer();
			Scanner sc = new Scanner(new File(filepath));
			while (sc.hasNextLine()) {
		         buffer.append(sc.nextLine()+System.lineSeparator());
		      }
			String fileContents = buffer.toString();
			 sc.close();
			 fileContents = fileContents.replaceAll(oldtext, newText);
			 FileWriter writer = new FileWriter(filepath);
			 writer.append(fileContents);
		      writer.flush();
			 return true;
			
		}
		
}
