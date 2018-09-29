package opera;
import java.awt.List;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import opera.Export;

public class opera {

    public static int[] fenshu(int range){//分数
	    int[] a=new int[2];
	    int q =1+(int)(Math.random()*range);
	    int Q =1+(int)(Math.random()*range);
	    if(q!=Q){
	     	a[0]=q;
	    	a[1]=Q;
	    }
	    else fenshu(range);
	    return a;
    }
    public static int gongyueshu( int m, int n) //辗转相除法求m/n的公约数
    {
        int r;
        while (n!=0)
        {
            r=m % n;
            m=n;
            n=r;
        }
        return m;
    }
    public static int gongbeishu(int m,int n) //最小公倍数
    {
        return m*n/gongyueshu(m,n);
    }
    public static char yunsuanfu(){//随机运算符
    	char[] b=new char[4];
    	int B=(int)(Math.random()*4);
    	b[0]='+';b[1]='-';b[2]='x';b[3]='÷';
    	char n=b[B];
    	return n;
    }
    public static int suijishu(int range){//随机整数
    	int n=1+(int)(Math.random()*range);
    	return n;
    }
    public static int[] suiji(int range){//返回随机数（包括分数、整数）
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
    public static int[] zhenfenshu(int m,int n){
    	int t=m;
    	int i=1;
     	while(t>n){
    		t=m-(n*i);
    		i++;
	    }
    	int[] d=new int[3];
    	d[0]=i-1;
    	d[1]=t;
    	d[2]=n;
    	if(t!=n){
    		return d;
    	}
	     return d;
    }
/*public static  int[] daan(int m,int n,int number){
    int[][] da=new int[number][3];
    for(int i=0;i<da.length;i=i+3){
    	int[] a=new int[3];
    	a=zhenfenshu(m,n);
    	da[i]=a[0];
    	da[i+1]=a[1];
    	da[i+2]=a[2];
    }
    return da;
   } */
    public static void main(String args[]){//主函数
    	@SuppressWarnings("resource")
    	Scanner input=new Scanner(System.in);
    	System.out.println("请输入生成题目数：Myapp.exe -");
    	int number=input.nextInt();//题目数
    	System.out.println("请输入公式数值以及分数分母范围：Myapp.exe -");
	    int range=input.nextInt();//数值范围
	    int[] count =new int[8];
	    int i=0;
    	int[] da=new int[3*number];
    	ArrayList<String>Answer=new ArrayList<String>();
    	
    	ArrayList<String>Shizi=new ArrayList<String>();
    	
    	while(i<number){
	    	int[] arr1 = new int[6];
	    	count=suiji(range);
	        int a=1+(int)(Math.random()*3);
	        while(a==1){//当运算符为一位
	        	int[] d1=new int[3];
	        	int[] d2=new int[3];
	        	if(gongyueshu(count[0],count[1])==0||gongyueshu(count[2],count[3])==0){break;}
	        	int x=count[0]/gongyueshu(count[0],count[1]);
		    	int y=count[1]/gongyueshu(count[0],count[1]);
		    	int z=count[2]/gongyueshu(count[2],count[3]);
		    	int p=count[3]/gongyueshu(count[2],count[3]);
	        	d1=zhenfenshu(x,y);
	         	d2=zhenfenshu(z,p);
	        	int n1=gongbeishu(count[1],count[3]);
		        if(yunsuanfu()=='-'){//当运算符为"-"号
		        	if(count[1]==0||count[3]==0){break;}
		    	int an1=(count[0]*(n1/count[1]))-(count[2]*(n1/count[3]));
			    if(an1>=0){//减法结果不能为负数	
				    int[] arr2 = new int[] { count[0], count[1],count[2],count[4],an1,n1 };
				    if(Arrays.equals(arr1,arr2)==true){break;}
				    else{
				    if(gongyueshu(count[0],count[1])==count[1]&&gongyueshu(count[2],count[3])==count[3]){
					
					 
				    	System.out.println("<"+(i+1)+"> "+(x/y)+" - "+(z/p)+" =");
				    	Shizi.add(+(x/y)+" - "+(z/p)+" =");
			    	}
				    else if(gongyueshu(count[0],count[1])==count[1]&&gongyueshu(count[2],count[3])!=count[3]){ 
				    	if(d2[0]==0){
						
				    		System.out.println("<"+(i+1)+"> "+(x/y)+" - "+d2[1]+"/"+d2[2]+" =");
				    		Shizi.add(+(x/y)+" - "+d2[1]+"/"+d2[2]+" =");
				    	}else{
						
					    System.out.println("<"+(i+1)+"> "+(x/y)+" - "+d2[0]+"^"+d2[1]+"/"+d2[2]+" =");
					    Shizi.add(+(x/y)+" - "+d2[0]+"^"+d2[1]+"/"+d2[2]+" =");
					     }
				    }
				    else if(gongyueshu(count[0],count[1])!=count[1]&&gongyueshu(count[2],count[3])==count[3]){
				    	if(d1[0]==0){
	
						
						    System.out.println("<"+(i+1)+"> "+d1[1]+"/"+d1[2]+" - "+(z/p)+" =");
						    Shizi.add(+d1[1]+"/"+d1[2]+" - "+(z/p)+" =");
					    }else{
						 
						
				    	System.out.println("<"+(i+1)+"> "+d1[0]+"^"+d1[1]+"/"+d1[2]+" - "+(z/p)+" =");
				    	Shizi.add(+d1[0]+"^"+d1[1]+"/"+d1[2]+" - "+(z/p)+" =");
			 	    	}
				    }
				    else if(gongyueshu(count[0],count[1])!=count[1]&&gongyueshu(count[2],count[3])!=count[3]){
				    	if(d1[0]==0&&d2[0]==0){
						 
						
					    	System.out.println("<"+(i+1)+"> "+d1[1]+"/"+d1[2]+" - "+d2[1]+"/"+d2[2]+" =");
					    	Shizi.add(+d1[1]+"/"+d1[2]+" - "+d2[1]+"/"+d2[2]+" =");
				    	}else if(d1[0]!=0&&d2[0]==0){
						 
						
					    	System.out.println("<"+(i+1)+"> "+d1[0]+"^"+d1[1]+"/"+d1[2]+" - "+d2[1]+"/"+d2[2]+" =");
					    	Shizi.add(+d1[0]+"^"+d1[1]+"/"+d1[2]+" - "+d2[1]+"/"+d2[2]+" =");
				    	}else if(d1[0]==0&&d2[0]!=0){
						 
						
					    	System.out.println("<"+(i+1)+"> "+d1[1]+"/"+d1[2]+" - "+d2[0]+"^"+d2[1]+"/"+d2[2]+" =");
					    	Shizi.add(d1[1]+"/"+d1[2]+" - "+d2[0]+"^"+d2[1]+"/"+d2[2]+" =");
					    }else if(d1[0]!=0&&d2[0]!=0){
						 
						
				     	System.out.println("<"+(i+1)+"> "+d1[0]+"^"+d1[1]+"/"+d1[2]+" - "+d2[0]+"^"+d2[1]+"/"+d2[2]+" =");
				     	Shizi.add(d1[0]+"^"+d1[1]+"/"+d1[2]+" - "+d2[0]+"^"+d2[1]+"/"+d2[2]+" =");
					    }
				    }
				    System.arraycopy(arr2, 0, arr1, 0, arr1.length);
				    //daan(an1,n1,number);
				    Answer.add(an1+"/"+n1);
			    	i++;
				    break;
			    	}
		     	}else if(an1<0){break;}
		}
		/*else if(yunsuanfu()=='÷'){//当运算符为"÷"号
			if(count[2]==0){//除数为0时无意义
			    break;
			}  
			else if(count[2]!=0){
				int an2=count[0]*count[3];//错误
				int an3=count[1]*count[2];
				if(count[1]==1&&count[3]==1){
					System.out.println("<"+(i+1)+"> "+count[0]+"÷"+count[2]+"="+an2+"/"+an3);
				}
				else if(count[1]==1&&count[3]!=1){ 
					System.out.println("<"+(i+1)+"> "+count[0]+"÷"+count[2]+"/"+count[3]+"="+an2+"/"+an3);
				}
				else if(count[1]!=1&&count[3]==1){
					System.out.println("<"+(i+1)+"> "+count[0]+"/"+count[1]+"÷"+count[2]+"="+an2+"/"+an3);
				}
				else if(count[1]!=1&&count[3]!=1){
					System.out.println("<"+(i+1)+"> "+count[0]+"/"+count[1]+"÷"+count[2]+"/"+count[3]+"="+an2+"/"+an3);
				}
				System.out.println(n1);
			    i++;
			    break;
			}
		}
		else if(yunsuanfu()=='+'){//当运算符为"+"号
		    int an4=(count[0]*(n1/count[1]))+(count[2]*(n1/count[3]));
			if(count[1]==1&&count[3]==1){
				System.out.println("<"+(i+1)+"> "+count[0]+"+"+count[2]+"="+an4+"/"+n1);
			}
			else if(count[1]==1&&count[3]!=1){ 
				System.out.println("<"+(i+1)+"> "+count[0]+"+"+count[2]+"/"+count[3]+"="+an4+"/"+n1);
			}
			else if(count[1]!=1&&count[3]==1){
				System.out.println("<"+(i+1)+"> "+count[0]+"/"+count[1]+"+"+count[2]+"="+an4+"/"+n1);
			}
			else if(count[1]!=1&&count[3]!=1){
				System.out.println("<"+(i+1)+"> "+count[0]+"/"+count[1]+"+"+count[2]+"/"+count[3]+"="+an4+"/"+n1);
			}
			System.out.println(n1);
			i++;
		}
		else if(yunsuanfu()=='x'){//当运算符为"x"号
			int an5=count[0]*count[2];
			int an6=count[1]*count[3];
			if(count[1]==1&&count[3]==1){
				System.out.println("<"+(i+1)+"> "+count[0]+"x"+count[2]+"="+an5+"/"+an6);
			}
			else if(count[1]==1&&count[3]!=1){ 
				System.out.println("<"+(i+1)+"> "+count[0]+"x"+count[2]+"/"+count[3]+"="+an5+"/"+an6);
			}
			else if(count[1]!=1&&count[3]==1){
				System.out.println("<"+(i+1)+"> "+count[0]+"/"+count[1]+"x"+count[2]+"="+an5+"/"+an6);
			}
			else if(count[1]!=1&&count[3]!=1){
				System.out.println("<"+(i+1)+"> "+count[0]+"/"+count[1]+"x"+count[2]+"/"+count[3]+"="+an5+"/"+an6);
			}
			System.out.println(n1);
			i++;
		}*/
	    }
	/*while(a==2){
		
	}*/
    }
	//da=daan()
	    System.out.println(Answer);
	    String shizi = Export.listostring(Shizi);
	    String answer = Export.listostring(Answer);
	    Export.TextToFile("Exercises", shizi);
	    Export.TextToFile("Answers", answer);
   }
    
    

}

