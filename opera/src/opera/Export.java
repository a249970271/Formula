package opera;

import java.awt.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;

public class Export {
	
	public static void main (String[] args) {
	}
	
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

}
