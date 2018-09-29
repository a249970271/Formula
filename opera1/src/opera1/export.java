package opera1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class export {
	
	public static void main (String[] args) {
	}
	//创建文档
	public static void TextToFile(String strFilename, String strBuffer) {
		try {
			//创建文件
			File fileText = new File(strFilename);
			FileWriter fileWriter = new FileWriter(fileText);
			fileWriter.write(strBuffer);
			fileWriter.write("\n");
			//关闭输入流
			fileWriter.close();
		}catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	//类型转换
	public static String listostring(ArrayList<String> list) {
		if(list == null) {
			return null;
		}
		StringBuffer result = new StringBuffer();
		int i = 1; 
		for(String string : list) {
			result.append("[" + i++ + "]" +  string+System.getProperty("line.separator"));
		
		}
		return result.toString();
	}
	
	//读取文档
	public static ArrayList<String> getlines(String filename1) {
		File file = new File(filename1);
		ArrayList<String>Answer1=new ArrayList<String>();
		if(!file.exists()) {
			System.out.println("未找到目标文件。");//指定路径下的文件不存在则输出：未找到目标文件
		}else {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String linetext=null;		
			while ((linetext=br.readLine())!= null) {
				Answer1.add(linetext);
			}
			br.close();//关闭输入流
		
		}catch (IOException ex) {
			ex.printStackTrace();
		}
		}
		return Answer1;
      }
	
	//答案对比
	public  static StringBuffer  duibi (ArrayList<String> A , ArrayList<String> B) {
		StringBuffer Right = new StringBuffer(); //存正确的题号
		StringBuffer Fault = new StringBuffer();//存错误的题号
		StringBuffer Daan = new StringBuffer();//存错误的题号
		int r = 0;
		int f = 0;
		int j = 0;
		for(String i :  A) {
			if ((A.get(j).compareTo(B.get(j)) == 0)){
				r = r + 1;
				Right.append(j+1 + ",");
				}
			else {
				f = f + 1;
				Fault.append(j+1 + ",");
			}
			j++;
		}
		Daan.append("Correct:" + r +  "(" + Right + ")" + System.getProperty("line.separator"));
		Daan.append("Wrong:" + f + "(" + Fault + ")");
		System.out.println("Correct:" + r +  "(" + Right + ")");
		System.out.println("Wrong:" + f + "(" + Fault + ")");
		return Daan;
    	}
}