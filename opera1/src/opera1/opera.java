package opera1;

import java.util.*;

import opera1.export;

public class opera {

	public static int[] fenshu(int range){//���ɷ���
		int[] a=new int[2];
		int q =1+(int)(Math.random()*range);//������ɷ���
		int Q =1+(int)(Math.random()*range);//������ɷ�ĸ
		if(q!=Q){//�����ӷ�ĸ���ʱΪ����
			a[0]=q;//����
			a[1]=Q;//��ĸ
		}
		else fenshu(range);
		return a;
	}
	public static int gongyueshu( int m, int n){ //շת�������m��n�Ĺ�Լ��
	    int r;
	    while (n!=0){
	        r=m % n;
	        m=n;
	        n=r;
	    }
	    return m;
	}
	public static int gongbeishu(int m,int n){ //��m��n����С������
	    return m*n/gongyueshu(m,n);
	}
	public static char yunsuanfu(){//������������
		char[] b=new char[4];
		int B=(int)(Math.random()*4);
		b[0]='+';b[1]='-';b[2]='x';b[3]='��';
		char n=b[B];
		return n;
	}
	public static int suijishu(int range){//�����������
		int n=1+(int)(Math.random()*range);
		return n;
	}
	public static int[] suiji(int range){//�������������������������������
		int count[]=new int[8];
		for(int p = 0;p<8;p=p+2){
			int b=1+(int)(Math.random()*2);
			if(b==1){
				count[p]=suijishu(range);
				count[p+1]=1;
			}else if(b==2){
				int[] d=new int[2];
				d=fenshu(range);
		        count[p]=d[0];
		        count[p+1]=d[1];
			}
		}
		return count;
	}
	public static String zhenfenshu(int m,int n){//���ٷ�����Ϊ�����
		int t=m;
		int i=1;
		while(t>n){
			t=m-(n*i);
			i++;
		}
		int[] d=new int[3];
		String b="";
		d[0]=i-1;
		d[1]=t;
		d[2]=n;
		if(d[0]==0){
			if(d[1]==d[2]){
			    b="1";	
			}else if((d[1]!=d[2])&&d[1]!=0){
				b=String.valueOf(t)+"/"+String.valueOf(n);
			}else if(d[1]==0){
				b="0";
			}
		}else if(d[0]!=0){
			if(d[1]==d[2]){
				b=String.valueOf(i);
			}else if(d[1]!=d[2]&&d[1]!=0){
				b=String.valueOf(i-1)+"��"+String.valueOf(t)+"/"+String.valueOf(n);
			}else if(d[1]==0){
				b="0";
			}
		}
		return b;
	}
	public static boolean duibi(ArrayList<String> Question){//����������ͬ��ʽ��
		for(int i=0;(i+1)<Question.size();i++){
			boolean x=Question.get(i).equals(Question.get(i+1));
			if(x==true){
				return x;}
		}
		return false;
	}
	public static void daan(String da,ArrayList<String>Answer){//�����
		Answer.add(da);
	}
	public static boolean danyunsuan(int a,int b,int c, int d,ArrayList<Integer>Answer1,ArrayList<String>Question1,char o)
	{//��ֻ��һ������������
		String d1="";
		String d2="";
		int[] count=new int[]{a,b,c,d};
		if(gongyueshu(count[0],count[1])==0||gongyueshu(count[2],count[3])==0){//�������Ϊ��
			return false;
		}
		int x=count[0]/gongyueshu(count[0],count[1]);
		int y=count[1]/gongyueshu(count[0],count[1]);
		int z=count[2]/gongyueshu(count[2],count[3]);
		int p=count[3]/gongyueshu(count[2],count[3]);
		d1=zhenfenshu(x,y);
		d2=zhenfenshu(z,p);
		int n1=gongbeishu(count[1],count[3]);
	    if(o=='-'){//�������Ϊ"-"��
	    	if(count[1]==0||count[3]==0){return false;}
		    int an1=(count[0]*(n1/count[1]))-(count[2]*(n1/count[3]));
		    if(an1>=0){
			    Question1.add(d1+" "+o+" "+d2);
			    Answer1.add(an1/gongyueshu(an1,n1));
			    Answer1.add(n1/gongyueshu(an1,n1));
		    }else{return false;}
		}else if(o=='��'){//�������Ϊ"��"��
		    if(count[2]==0){//����Ϊ0ʱ������
		    return false;
		    }else if(count[2]!=0){
			    int an2=count[0]*count[3];
			    int an3=count[1]*count[2];
			    Question1.add(d1+" "+o+" "+d2);
			    Answer1.add(an2/gongyueshu(an2,an3));
			    Answer1.add(an3/gongyueshu(an2,an3));
	        }
	    }else if(o=='+'){//�������Ϊ"+"��
		    if(count[1]==0||count[3]==0){return false;}
		    int an4=(count[0]*(n1/count[1]))+(count[2]*(n1/count[3]));
		    Question1.add(d1+" "+o+" "+d2);
			Answer1.add(an4/gongyueshu(an4,n1));
			Answer1.add(n1/gongyueshu(an4,n1));
		}else if(o=='x'){//�������Ϊ"x"��
		    int an5=count[0]*count[2];
		    int an6=count[1]*count[3];
		    Question1.add(d1+" "+o+" "+d2);
			Answer1.add(an5/gongyueshu(an5,an6));
			Answer1.add(an6/gongyueshu(an5,an6));
	    }
		return true;
	}
	public static void main(String args[]){//������
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		System.out.println("������������Ŀ����Myapp.exe -");
		int number=input.nextInt();//��Ŀ��
		System.out.println("�����빫ʽ��ֵ�Լ�������ĸ��Χ��Myapp.exe -");
		int range=input.nextInt();//��ֵ��Χ
		int[] count =new int[8];
		int i=0;
		ArrayList<String>Answer=new ArrayList<String>();//�����
		ArrayList<String>Question=new ArrayList<String>();//����ʽ��
		ArrayList<Integer>Answer1=new ArrayList<Integer>();//������������в����Ĵ�
		ArrayList<String>Question1=new ArrayList<String>();//���������������Ҫ��ʽ��
		while(i<number){
			Answer1.clear();
			Question1.clear();
			count=suiji(range);//�������������
		    int a=1+(int)(Math.random()*3);
		    while(a==1){//�������Ϊһλ
		        char o=yunsuanfu();
		    	boolean x=danyunsuan(count[0],count[1],count[2],count[3],Answer1,Question1,o);
		    	if(x==false){break;}
		    	Question.add(Question1.get(0));
		    	if(true==duibi(Question)){break;}//�ж�������ͬʽ��
		    	System.out.println("<"+(i+1)+"> "+Question1.get(0)+" =");
		    	if(Answer1.size()==0||Question1.size()==0){break;}
				int [] w=new int[]{Answer1.get(0),Answer1.get(1)};
				String da1="";
				da1=zhenfenshu(w[0]/gongyueshu(w[0],w[1]),w[1]/gongyueshu(w[0],w[1]));
				daan(da1,Answer);
				i++;
				Answer1.clear();
			    Question1.clear();//���list
			    break;
		    } 
		    while(a==2){//�������Ϊ��λ
			    int g=1+(int)(Math.random()*2);
			    char[] fuhao=new char[2];
			    fuhao[0]=yunsuanfu();
			    fuhao[1]=yunsuanfu();
			    Answer1.clear();
			    Question1.clear();
			    if(g==1){//(a[]b)[]c����
				    danyunsuan(count[0],count[1],count[2],count[3],Answer1,Question1,fuhao[0]);//��һ������
				    if(Answer1.size()==0||Question1.size()==0){break;}
				        int a1=Answer1.get(0);int a2=Answer1.get(1);
				        Answer1.clear();
				    boolean x=danyunsuan(a1,a2,count[4],count[5],Answer1,Question1,fuhao[1]);//�ڶ�������
				    if(x==false){break;}
				    String da="";
				    if(gongyueshu(count[4],count[5])==0){break;}
				        da=zhenfenshu(count[4]/gongyueshu(count[4],count[5]),count[5]/gongyueshu(count[4],count[5]));
				        Question.add(" ("+(Question1.get(0))+") "+fuhao[1]+" "+da);
		    	    if(true==duibi(Question)){break;}
				        System.out.println("<"+(i+1)+">"+" ("+(Question1.get(0))+") "+fuhao[1]+" "+da+" =");
				    if(Answer1.size()==0||Question1.size()==0){break;}
				        int[] w=new int[]{Answer1.get(0),Answer1.get(1)};
				    String da1="";
				    da1=zhenfenshu(w[0]/gongyueshu(w[0],w[1]),w[1]/gongyueshu(w[0],w[1]));
				    daan(da1,Answer);
				    i++;
				    Answer1.clear();
			        Question1.clear();
			        break;
				}else if(g==2){//a[](b[]c)����
					 boolean x1=danyunsuan(count[2],count[3],count[4],count[5],Answer1,Question1,fuhao[1]);//��һ������
					 if(x1==false){break;}
				     if(Answer1.size()==0||Question1.size()==0){break;}  
				         int a1=Answer1.get(0);int a2=Answer1.get(1);
				         Answer1.clear();
				     boolean x2=danyunsuan(count[0],count[1],a1,a2,Answer1,Question1,fuhao[0]);//�ڶ�������
				     if(x2==false){break;}
				     String da="";
				 	 if(gongyueshu(count[0],count[1])==0){break;}
				         da=zhenfenshu(count[0]/gongyueshu(count[0],count[1]),count[1]/gongyueshu(count[0],count[1]));
				         Question.add(da+" "+fuhao[0]+" ("+(Question1.get(0))+") ");
			    	 if(true==duibi(Question)){break;}
				         System.out.println("<"+(i+1)+"> "+da+" "+fuhao[0]+" ("+(Question1.get(0))+") "+"=");
				     if(Answer1.size()==0||Question1.size()==0){break;}
				     int [] w=new int[]{Answer1.get(0),Answer1.get(1)};
				     String da1="";
				     da1=zhenfenshu(w[0]/gongyueshu(w[0],w[1]),w[1]/gongyueshu(w[0],w[1]));
				     daan(da1,Answer);
				     i++;
				     Answer1.clear();
			         Question1.clear();
			         break;
				}
			}
	        while(a==3){//���������
	   		   int f=1+(int)(Math.random()*8);
	   		   char[] fuhao=new char[3];
			   fuhao[0]=yunsuanfu();
			   fuhao[1]=yunsuanfu();
			   fuhao[2]=yunsuanfu();
			   Answer1.clear();
			   Question1.clear();
	   		   if(f==1){//(a[]b)[]c[]d
	   			   boolean x1=danyunsuan(count[0],count[1],count[2],count[3],Answer1,Question1,fuhao[0]);//��һ������
	   			   if(x1==false){break;}
	   			   if(Answer1.size()==0||Question1.size()==0){break;}  
			           int a1=Answer1.get(0);int a2=Answer1.get(1);
			           Answer1.clear();
			       if((fuhao[2]=='+'||fuhao[2]=='-')||((fuhao[1]=='x'||fuhao[1]=='��')&&(fuhao[2]=='x'||fuhao[2]=='��'))){//���������
			    	   boolean x2=danyunsuan(a1,a2,count[4],count[5],Answer1,Question1,fuhao[1]);//�ڶ�������
			    	   if(x2==false){break;}
			    	   String da1="";
			    	   if(gongyueshu(count[4],count[5])==0){break;}
			    	       da1=zhenfenshu(count[4]/gongyueshu(count[4],count[5]),count[5]/gongyueshu(count[4],count[5]));
			    	   int a3=Answer1.get(0);int a4=Answer1.get(1);
			    	   Answer1.clear();
			    	   boolean x3=danyunsuan(a3,a4,count[6],count[7],Answer1,Question1,fuhao[2]);//����������
			    	   if(x3==false){break;}
			    	   String da2="";
			    	   if(gongyueshu(count[6],count[7])==0){break;}
			    	       da2=zhenfenshu(count[6]/gongyueshu(count[6],count[7]),count[7]/gongyueshu(count[6],count[7]));
			    	       Question.add(" ("+Question1.get(0)+") "+fuhao[1]+" "+da1+" "+fuhao[2]+" "+da2);
				       if(true==duibi(Question)){break;}
			    	       System.out.println("<"+(i+1)+">"+" ("+Question1.get(0)+") "+fuhao[1]+" "+da1+" "+fuhao[2]+" "+da2+" =");
			    	   if(Answer1.size()==0||Question1.size()==0){break;}
					       int [] w=new int[]{Answer1.get(0),Answer1.get(1)};
					   String da3="";
					   da3=zhenfenshu(w[0]/gongyueshu(w[0],w[1]),w[1]/gongyueshu(w[0],w[1]));
					   daan(da3,Answer);
					   i++;
					   Answer1.clear();
				       Question1.clear();
				       break;
			       }else if((fuhao[1]=='+'||fuhao[1]=='-')&&(fuhao[2]=='x'||fuhao[2]=='��')){
			    	   boolean x2=danyunsuan(count[4],count[5],count[6],count[7],Answer1,Question1,fuhao[2]);//�ڶ�������
			    	   if(x2==false){break;}
			    	   String da1="";
			    	   if(gongyueshu(count[4],count[5])==0){break;}
			    	       da1=zhenfenshu(count[4]/gongyueshu(count[4],count[5]),count[5]/gongyueshu(count[4],count[5])); 
			    	   String da2="";
			    	   if(0==gongyueshu(count[6],count[7])){break;}
			    	       da2=zhenfenshu(count[6]/gongyueshu(count[6],count[7]),count[7]/gongyueshu(count[6],count[7]));
			    	   int a3=Answer1.get(0);int a4=Answer1.get(1);
			    	   Answer1.clear();
			    	   boolean x3=danyunsuan(a1,a2,a3,a4,Answer1,Question1,fuhao[1]);//����������
			    	   if(x3==false){break;}
			    	   Question.add(" ("+Question1.get(0)+") "+fuhao[1]+" "+da1+" "+fuhao[2]+" "+da2);
				       if(true==duibi(Question)){break;}
			    	       System.out.println("<"+(i+1)+">"+" ("+Question1.get(0)+") "+fuhao[1]+" "+da1+" "+fuhao[2]+" "+da2+" =");
			    	   if(Answer1.size()==0||Question1.size()==0){break;}
					       int [] w=new int[]{Answer1.get(0),Answer1.get(1)};
					   String da3="";
					   da3=zhenfenshu(w[0]/gongyueshu(w[0],w[1]),w[1]/gongyueshu(w[0],w[1]));
					   daan(da3,Answer);
					   i++;
					   Answer1.clear();
				       Question1.clear();
				       break;
			       }
	   		   }else if(f==2){//a[](b[]c)[]d����
	   			   boolean x1=danyunsuan(count[2],count[3],count[4],count[5],Answer1,Question1,fuhao[1]);//��һ������
	 			   if(x1==false){break;}
	 			   if(Answer1.size()==0||Question1.size()==0){break;}  
			           int a1=Answer1.get(0);int a2=Answer1.get(1);
			           Answer1.clear();
			       if(fuhao[2]=='+'||fuhao[2]=='-'){
			    	   boolean x2=danyunsuan(count[0],count[1],a1,a2,Answer1,Question1,fuhao[0]);//�ڶ�������
			    	   if(x2==false){break;}
			    	   String da1="";
			    	   if(gongyueshu(count[0],count[1])==0){break;}
			    	       da1=zhenfenshu(count[0]/gongyueshu(count[0],count[1]),count[1]/gongyueshu(count[0],count[1]));
			    	   int a3=Answer1.get(0);int a4=Answer1.get(1);
			    	   Answer1.clear();
			    	   boolean x3=danyunsuan(a3,a4,count[6],count[7],Answer1,Question1,fuhao[2]);//����������
			    	   if(x3==false){break;}
			    	   String da2="";
			    	   if(gongyueshu(count[6],count[7])==0){break;}
			    	       da2=zhenfenshu(count[6]/gongyueshu(count[6],count[7]),count[7]/gongyueshu(count[6],count[7]));
			    	   Question.add(da1+" "+fuhao[0]+" ("+Question1.get(0)+") "+fuhao[2]+" "+da2);
				       if(true==duibi(Question)){break;}
			    	       System.out.println("<"+(i+1)+">"+da1+" "+fuhao[0]+" ("+Question1.get(0)+") "+fuhao[2]+" "+da2+" =");
			    	   if(Answer1.size()==0||Question1.size()==0){break;}
					       int [] w=new int[]{Answer1.get(0),Answer1.get(1)};
					   String da3="";
					   da3=zhenfenshu(w[0]/gongyueshu(w[0],w[1]),w[1]/gongyueshu(w[0],w[1]));
					   daan(da3,Answer);
					   i++;
					   Answer1.clear();
				       Question1.clear();
				       break;
			       }else if(fuhao[2]=='x'||fuhao[2]=='��'){
			    	   boolean x2=danyunsuan(a1,a2,count[6],count[7],Answer1,Question1,fuhao[2]);//�ڶ�������
			    	   if(x2==false){break;}
			    	   String da1="";
			    	   if(gongyueshu(count[0],count[1])==0){break;}
			    	       da1=zhenfenshu(count[0]/gongyueshu(count[0],count[1]),count[0]/gongyueshu(count[0],count[1])); 
			    	   String da2="";
			    	   if(0==gongyueshu(count[6],count[7])){break;}
			    	       da2=zhenfenshu(count[6]/gongyueshu(count[6],count[7]),count[7]/gongyueshu(count[6],count[7]));
			    	   int a3=Answer1.get(0);int a4=Answer1.get(1);
			    	   Answer1.clear();
			    	   boolean x3=danyunsuan(count[0],count[1],a3,a4,Answer1,Question1,fuhao[0]);//����������
			    	   if(x3==false){break;}
			    	   Question.add(da1+" "+fuhao[0]+" ("+Question1.get(0)+") "+fuhao[2]+" "+da2);
				       if(true==duibi(Question)){break;}
			    	       System.out.println("<"+(i+1)+">"+da1+" "+fuhao[0]+" ("+Question1.get(0)+") "+fuhao[2]+" "+da2+" =");
			    	   if(Answer1.size()==0||Question1.size()==0){break;}
					       int [] w=new int[]{Answer1.get(0),Answer1.get(1)};
					   String da3="";
					   da3=zhenfenshu(w[0]/gongyueshu(w[0],w[1]),w[1]/gongyueshu(w[0],w[1]));
					   daan(da3,Answer);
					   i++;
					   Answer1.clear();
				       Question1.clear();
				       break;
			       }
	   		   }else if(f==3){//a[]b[](c[]d)����
	   			   boolean x1=danyunsuan(count[4],count[5],count[6],count[7],Answer1,Question1,fuhao[2]);//��һ������
				   if(x1==false){break;}
				   if(Answer1.size()==0||Question1.size()==0){break;}  
			           int a1=Answer1.get(0);int a2=Answer1.get(1);
			           Answer1.clear();
			       if((fuhao[1]=='+'||fuhao[1]=='-')||((fuhao[0]=='x'||fuhao[0]=='��')&&(fuhao[1]=='x'||fuhao[1]=='��'))){
			    	   boolean x2=danyunsuan(count[0],count[1],count[2],count[3],Answer1,Question1,fuhao[0]);//�ڶ������� 
			    	   if(x2==false){break;}
			    	   String da1="";
			    	   if(gongyueshu(count[0],count[1])==0){break;}
			    	       da1=zhenfenshu(count[0]/gongyueshu(count[0],count[1]),count[1]/gongyueshu(count[0],count[1]));
			    	   int a3=Answer1.get(0);int a4=Answer1.get(1);
			    	   Answer1.clear();
			    	   boolean x3=danyunsuan(a3,a4,a1,a2,Answer1,Question1,fuhao[1]);//����������
			    	   if(x3==false){break;}
			    	   String da2="";
			    	   if(0==gongyueshu(count[2],count[3])){break;}
			    	       da2=zhenfenshu(count[2]/gongyueshu(count[2],count[3]),count[3]/gongyueshu(count[2],count[3]));
			    	   Question.add(da1+" "+fuhao[0]+" "+da2+" "+fuhao[1]+" ("+Question1.get(0)+")");
				       if(true==duibi(Question)){break;}
			    	       System.out.println("<"+(i+1)+">"+da1+" "+fuhao[0]+" "+da2+" "+fuhao[1]+" ("+Question1.get(0)+")"+" =");
			    	   if(Answer1.size()==0||Question1.size()==0){break;}
					       int [] w=new int[]{Answer1.get(0),Answer1.get(1)};
					   String da3="";
					   da3=zhenfenshu(w[0]/gongyueshu(w[0],w[1]),w[1]/gongyueshu(w[0],w[1]));
					   daan(da3,Answer);
					   i++;
					   Answer1.clear();
				       Question1.clear();
				       break;
			       }else if((fuhao[0]=='+'||fuhao[0]=='-')&&(fuhao[1]=='x'||fuhao[1]=='��')){
			    	   boolean x2=danyunsuan(count[2],count[3],a1,a2,Answer1,Question1,fuhao[1]);//�ڶ�������
			    	   if(x2==false){break;}
			    	   String da1="";
			    	   if(gongyueshu(count[0],count[1])==0){break;}
			    	       da1=zhenfenshu(count[0]/gongyueshu(count[0],count[1]),count[0]/gongyueshu(count[0],count[1])); 
			    	   String da2="";
			    	   if(0==gongyueshu(count[2],count[3])){break;}
			    	       da2=zhenfenshu(count[2]/gongyueshu(count[2],count[3]),count[3]/gongyueshu(count[2],count[3]));
			    	   int a3=Answer1.get(0);int a4=Answer1.get(1);
			    	   Answer1.clear();
			    	   boolean x3=danyunsuan(count[0],count[1],a3,a4,Answer1,Question1,fuhao[0]);//����������
			    	   if(x3==false){break;}
			    	   Question.add(da1+" "+fuhao[0]+" "+da2+" "+fuhao[1]+" ("+Question1.get(0)+")");
				       if(true==duibi(Question)){break;}
			    	       System.out.println("<"+(i+1)+">"+da1+" "+fuhao[0]+" "+da2+" "+fuhao[1]+" ("+Question1.get(0)+")"+" =");
			    	   if(Answer1.size()==0||Question1.size()==0){break;}
					       int [] w=new int[]{Answer1.get(0),Answer1.get(1)};
					   String da3="";
					   da3=zhenfenshu(w[0]/gongyueshu(w[0],w[1]),w[1]/gongyueshu(w[0],w[1]));
					   daan(da3,Answer);
					   i++;
					   Answer1.clear();
				       Question1.clear();
				       break;
			       }
	   		   }else if(f==4){//(a[]b)[](c[]d)����
	   			   boolean x1=danyunsuan(count[0],count[1],count[2],count[3],Answer1,Question1,fuhao[0]);//��һ������
				   if(x1==false){break;}
				   if(Answer1.size()==0||Question1.size()==0){break;}  
			           int a1=Answer1.get(0);int a2=Answer1.get(1);
			           Answer1.clear();
	   			   boolean x2=danyunsuan(count[4],count[5],count[6],count[7],Answer1,Question1,fuhao[2]);//�ڶ�������
		    	   if(x2==false){break;}
		    	   int a3=Answer1.get(0);int a4=Answer1.get(1);
		    	   Answer1.clear();
		    	   boolean x3=danyunsuan(a1,a2,a3,a4,Answer1,Question1,fuhao[1]);//����������
		    	   if(x3==false){break;}
		    	   Question.add(" ("+Question1.get(0)+") "+fuhao[1]+" ("+Question1.get(1)+")");
			       if(true==duibi(Question)){break;}
		    	       System.out.println("<"+(i+1)+">"+" ("+Question1.get(0)+") "+fuhao[1]+" ("+Question1.get(1)+")"+" =");
		    	   if(Answer1.size()==0||Question1.size()==0){break;}
				       int [] w=new int[]{Answer1.get(0),Answer1.get(1)};
				   String da3="";
				   da3=zhenfenshu(w[0]/gongyueshu(w[0],w[1]),w[1]/gongyueshu(w[0],w[1]));
				   daan(da3,Answer);
				   i++;
				   Answer1.clear();
			       Question1.clear();
			       break;
	   		   }else if(f==5){//((a[]b)[]c)[]d����
	   			   boolean x1=danyunsuan(count[0],count[1],count[2],count[3],Answer1,Question1,fuhao[0]);//��һ������
				   if(x1==false){break;}
				   if(Answer1.size()==0||Question1.size()==0){break;}  
			           int a1=Answer1.get(0);int a2=Answer1.get(1);
			           Answer1.clear();
			       boolean x2=danyunsuan(a1,a2,count[4],count[5],Answer1,Question1,fuhao[1]);//�ڶ�������
			       if(x2==false){break;}
			       String da1="";
			       if(gongyueshu(count[4],count[5])==0){break;}
			           da1=zhenfenshu(count[4]/gongyueshu(count[4],count[5]),count[5]/gongyueshu(count[4],count[5]));
			       int a3=Answer1.get(0);int a4=Answer1.get(1);
			       Answer1.clear();
			       boolean x3=danyunsuan(a3,a4,count[6],count[7],Answer1,Question1,fuhao[2]);//����������
			       if(x3==false){break;}
			       String da2="";
			       if(0==gongyueshu(count[6],count[7])){break;}
			    	   da2=zhenfenshu(count[6]/gongyueshu(count[6],count[7]),count[7]/gongyueshu(count[6],count[7]));
			       Question.add(" ("+Question1.get(0)+") "+fuhao[1]+" "+da1+" "+fuhao[2]+" "+da2);
				   if(true==duibi(Question)){break;}
			    	   System.out.println("<"+(i+1)+">"+" ("+Question1.get(0)+") "+fuhao[1]+" "+da1+" "+fuhao[2]+" "+da2+" =");
			       if(Answer1.size()==0||Question1.size()==0){break;}
					    int [] w=new int[]{Answer1.get(0),Answer1.get(1)};
				   String da3="";
				   da3=zhenfenshu(w[0]/gongyueshu(w[0],w[1]),w[1]/gongyueshu(w[0],w[1]));
				   daan(da3,Answer);
				   i++;
				   Answer1.clear();
				   Question1.clear();
				   break;
	   		   }else if(f==6){//(a[](b[]c))[]d����
	   			   boolean x1=danyunsuan(count[2],count[3],count[4],count[5],Answer1,Question1,fuhao[1]);//��һ������
				   if(x1==false){break;}
				   if(Answer1.size()==0||Question1.size()==0){break;}  
			           int a1=Answer1.get(0);int a2=Answer1.get(1);
			           Answer1.clear();
			       boolean x2=danyunsuan(count[0],count[1],a1,a2,Answer1,Question1,fuhao[0]);//�ڶ�������
			       if(x2==false){break;}
			       String da1="";
			       if(gongyueshu(count[0],count[1])==0){break;}
			    	   da1=zhenfenshu(count[0]/gongyueshu(count[0],count[1]),count[1]/gongyueshu(count[0],count[1]));
			       int a3=Answer1.get(0);int a4=Answer1.get(1);
			       Answer1.clear();
			       boolean x3=danyunsuan(a3,a4,count[6],count[7],Answer1,Question1,fuhao[2]);//����������
			       if(x3==false){break;}
			       String da2="";
			       if(0==gongyueshu(count[6],count[7])){break;}
			    	   da2=zhenfenshu(count[6]/gongyueshu(count[6],count[7]),count[7]/gongyueshu(count[6],count[7]));
			       Question.add(da1+" "+fuhao[0]+" ("+Question1.get(0)+") "+fuhao[2]+" "+da2);
				   if(true==duibi(Question)){break;}
			    	   System.out.println("<"+(i+1)+">"+da1+" "+fuhao[0]+" ("+Question1.get(0)+") "+fuhao[2]+" "+da2+" =");
			       if(Answer1.size()==0||Question1.size()==0){break;}
					    int [] w=new int[]{Answer1.get(0),Answer1.get(1)};
				   String da3="";
				   da3=zhenfenshu(w[0]/gongyueshu(w[0],w[1]),w[1]/gongyueshu(w[0],w[1]));
				   daan(da3,Answer);
				   i++;
				   Answer1.clear();
				   Question1.clear();
				   break;
	   		   }else if(f==7){//a[]((b[]c)[]d)����
	   			   boolean x1=danyunsuan(count[2],count[3],count[4],count[5],Answer1,Question1,fuhao[1]);//��һ������
				   if(x1==false){break;}
				   if(Answer1.size()==0||Question1.size()==0){break;}  
			           int a1=Answer1.get(0);int a2=Answer1.get(1);
			           Answer1.clear();
	   			   boolean x2=danyunsuan(a1,a2,count[6],count[7],Answer1,Question1,fuhao[2]);//�ڶ�������
		    	   if(x2==false){break;}
		    	   String da1="";
		    	   if(gongyueshu(count[0],count[1])==0){break;}
		    	       da1=zhenfenshu(count[0]/gongyueshu(count[0],count[1]),count[0]/gongyueshu(count[0],count[1])); 
		    	   String da2="";
		    	   if(0==gongyueshu(count[6],count[7])){break;}
		    	       da2=zhenfenshu(count[6]/gongyueshu(count[6],count[7]),count[7]/gongyueshu(count[6],count[7]));
		    	   int a3=Answer1.get(0);int a4=Answer1.get(1);
		    	   Answer1.clear();
		    	   boolean x3=danyunsuan(count[0],count[1],a3,a4,Answer1,Question1,fuhao[0]);//����������
		    	   if(x3==false){break;}
		    	   Question.add(da1+" "+fuhao[0]+" ("+Question1.get(0)+") "+fuhao[2]+" "+da2);
			       if(true==duibi(Question)){break;}
		    	       System.out.println("<"+(i+1)+">"+da1+" "+fuhao[0]+" ("+Question1.get(0)+") "+fuhao[2]+" "+da2+" =");
		    	   if(Answer1.size()==0||Question1.size()==0){break;}
				       int [] w=new int[]{Answer1.get(0),Answer1.get(1)};
				   String da3="";
				   da3=zhenfenshu(w[0]/gongyueshu(w[0],w[1]),w[1]/gongyueshu(w[0],w[1]));
				   daan(da3,Answer);
				   i++;
				   Answer1.clear();
			       Question1.clear();
			       break;
	   		   }else if(f==8){//a[](b[](c[]d))����
	   			   boolean x1=danyunsuan(count[4],count[5],count[6],count[7],Answer1,Question1,fuhao[2]);//��һ������
				   if(x1==false){break;}
				   if(Answer1.size()==0||Question1.size()==0){break;}  
			           int a1=Answer1.get(0);int a2=Answer1.get(1);
			           Answer1.clear();
		    	   boolean x2=danyunsuan(count[2],count[3],a1,a2,Answer1,Question1,fuhao[1]);//�ڶ�������
		    	   if(x2==false){break;}
		    	   String da1="";
		    	   if(gongyueshu(count[0],count[1])==0){break;}
		    	       da1=zhenfenshu(count[0]/gongyueshu(count[0],count[1]),count[0]/gongyueshu(count[0],count[1])); 
		    	   String da2="";
		    	   if(0==gongyueshu(count[2],count[3])){break;}
		    	       da2=zhenfenshu(count[2]/gongyueshu(count[2],count[3]),count[3]/gongyueshu(count[2],count[3]));
		    	   int a3=Answer1.get(0);int a4=Answer1.get(1);
		    	   Answer1.clear();
		    	   boolean x3=danyunsuan(count[0],count[1],a3,a4,Answer1,Question1,fuhao[0]);//����������
		    	   if(x3==false){break;}
		    	   Question.add(da1+" "+fuhao[0]+" "+da2+" "+fuhao[1]+" ("+Question1.get(0)+")");
			       if(true==duibi(Question)){break;}
		    	       System.out.println("<"+(i+1)+">"+da1+" "+fuhao[0]+" "+da2+" "+fuhao[1]+" ("+Question1.get(0)+")"+" =");
		    	   if(Answer1.size()==0||Question1.size()==0){break;}
				       int [] w=new int[]{Answer1.get(0),Answer1.get(1)};
				   String da3="";
				   da3=zhenfenshu(w[0]/gongyueshu(w[0],w[1]),w[1]/gongyueshu(w[0],w[1]));
				   daan(da3,Answer);
				   i++;
				   Answer1.clear();
			       Question1.clear();
			       break;
	   		   }
	       }
	}
		String shizi = export.listostring(Question);
	    String answer = export.listostring(Answer);
	    export.TextToFile("Exercises", shizi);
	    export.TextToFile("Answers", answer);
	    System.out.println("��������Ҫ���ĵ��ļ�����Myapp.exe -a ");
	    Scanner or =new Scanner(System.in);
		String file=or.nextLine();//�Ӽ����������ļ���
		ArrayList<String>Answer2 = export.getlines(file);
		String D = export.duibi(Answer, Answer2).toString();
		export.TextToFile("Grade1", D);
		int o = 1;
		while (o<10000) {
		o++;
		System.out.println("������һ����ҵ(Y/N)");
		Scanner a =new Scanner(System.in);
		String b=a.nextLine();
		if(b.trim().equals("Y")) {
			System.out.println("��������Ҫ���ĵ��ļ�����Myapp.exe -a ");
		    Scanner or1 =new Scanner(System.in);
			String file1=or1.nextLine();//�Ӽ����������ļ���
			ArrayList<String>Answer21 = export.getlines(file1);
			String D1 = export.duibi(Answer, Answer21).toString();
			export.TextToFile("Grade"+o, D1);
			
		}else {System.out.println("��л����ʹ�á�");break;}
		}
	} 
}
