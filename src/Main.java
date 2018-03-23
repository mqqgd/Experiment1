import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
public class Main {
	static Random R;
	static ArrayList<String> al;
	static ScriptEngineManager manager;
	static ScriptEngine se;
	public static void main(String[] args) {
		R=new Random();
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入学号：");
		String id=sc.nextLine();
		System.out.println("请输入题目数量：");
		int all=sc.nextInt();
		BufferedWriter bw = null;
		al=new ArrayList<String>();
		double result=0;
		manager = new ScriptEngineManager();
		se = manager.getEngineByName("js");
		try {
			bw = new BufferedWriter(new FileWriter("result.txt"));
			bw.write(id+"\n");
            bw.write(all+"\n");
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		for(int n=0;n<all;n++){
			String title="";
			int s=R.nextInt(3)+3;
			for(int i=0;i<s;i++){
				title=title+R.nextInt(100);
				if(i<s-1){
					title=title+type(R.nextInt(4)+1);
				}
			}
			
			try {
				result=Double.valueOf(se.eval(title).toString());
			} catch (NumberFormatException | ScriptException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(result<0||result>200||result%1!=0){
				n--;
				continue;
			}
			try {
	        	bw.write(title);
	        	bw.write("=");
	        	bw.write(String.valueOf((int)result));
	        	bw.write("\n");
	        } catch (IOException e1) {
	            e1.printStackTrace();
	        }
			
		}//over
		
		
		try {
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String type(int n){
		if(n==1){
			return "+";
		}
		else if(n==2){
			return "-";
		}
		else if(n==3){
			return "*";
		}
		else{
			return "/";
		}
	}
	
}
