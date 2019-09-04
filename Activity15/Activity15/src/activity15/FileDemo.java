package activity15;
import java.io.*;



public class FileDemo {

	
	
	public void demo(){
		
		try{
			String path="D:\\Baitap";
			
			File f= new File(path);
			
			System.out.println("Name: " +f.getName());
			System.out.println("Parent: " +f.getParent());
			// liet ke tat ca thu muc con va file 
			
			File[] names =  f.listFiles();
			
			for(File s : names){
			
				if( s.isFile()){
					System.out.println(s.getName() + "--> is File" + s.getAbsolutePath());
					
				}else{
					System.out.println(s.getName() + "--> is Directory" +s.getAbsolutePath());
				}
				
				
				// tao file trong thu muc s
				
				String fileName="file.txt";
				
				File ff =new File(s.getAbsolutePath() + "\\"+fileName);
				boolean flag= ff.createNewFile();
				
				
				// 
				if(flag){
					//write
					
					FileWriter fw =new FileWriter(ff);
					BufferedWriter bw =new BufferedWriter(fw);
					bw.write("Virus...");
					bw.newLine();
					
					bw.close();
					fw.close();
				}
				
			}
			
		}catch (Exception e) {
			
			
			
		}
	}
	
	public static void main(String[] args) {
		
		FileDemo d=new FileDemo();
		d.demo();
		
		

	}

}
