import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
public class YunSuan {
	static Random R;
	public static void main(String[] args) {
		R=new Random();
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入学号：");
		String id=sc.nextLine();
		System.out.println("请输入题目数量：");
		int all=sc.nextInt();
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter("result.txt"));
			bw.write(id+"\n");
            bw.write(all+"\n");
		} catch (IOException e2) {
			// TODO Auto-generated catch block
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
			title=title+"=";
			try {
	        	bw.write(title);
	        	bw.write("\n");
	            
	        } catch (IOException e1) {
	            // TODO Auto-generated catch block
	            e1.printStackTrace();
	        }
			System.out.println(title);
		}
		try {
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
