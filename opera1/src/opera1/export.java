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
	//�����ĵ�
	public static void TextToFile(String strFilename, String strBuffer) {
		try {
			//�����ļ�
			File fileText = new File(strFilename);
			FileWriter fileWriter = new FileWriter(fileText);
			fileWriter.write(strBuffer);
			fileWriter.write("\n");
			//�ر�������
			fileWriter.close();
		}catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	//����ת��
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
	
	//��ȡ�ĵ�
	public static ArrayList<String> getlines(String filename1) {
		File file = new File(filename1);
		ArrayList<String>Answer1=new ArrayList<String>();
		if(!file.exists()) {
			System.out.println("δ�ҵ�Ŀ���ļ���");//ָ��·���µ��ļ��������������δ�ҵ�Ŀ���ļ�
		}else {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String linetext=null;		
			while ((linetext=br.readLine())!= null) {
				Answer1.add(linetext);
			}
			br.close();//�ر�������
		
		}catch (IOException ex) {
			ex.printStackTrace();
		}
		}
		return Answer1;
      }
	
	//�𰸶Ա�
	public  static StringBuffer  duibi (ArrayList<String> A , ArrayList<String> B) {
		StringBuffer Right = new StringBuffer(); //����ȷ�����
		StringBuffer Fault = new StringBuffer();//���������
		StringBuffer Daan = new StringBuffer();//���������
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