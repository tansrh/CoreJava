package trainingday1;
import java.util.*;
public class equaltest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		int a=5, b=5;
		String s="ab", t="ab";
		String p=new String("ab");
		String q=new String("ab");
		System.out.println(t==s);
		*/
		Scanner sc= new Scanner(System.in);
		String a, b;
		System.out.println("Enter string a");
		a=sc.next();
		System.out.println("Enter string b");
		b=sc.next();
		
		int arr[]=new int[26];
		for(int i=0; i<a.length(); i++) {
			if(a.charAt(i)>=65 && a.charAt(i)<=90) {
				arr[a.charAt(i)-'A']++;
			}
			else {
				arr[a.charAt(i)-'a']++;
			}
			
		}
		for(int i=0; i<b.length(); i++) {
			if(b.charAt(i)>=65 && b.charAt(i)<=90) {
				arr[b.charAt(i)-'A']--;
			}
			else {
				arr[b.charAt(i)-'a']--;
			}
			
		}
		boolean flag=true;
		for(int i=0; i<26; i++) {
			if(arr[i]!=0) {
				flag=false;
				break;
			}
		}
		System.out.println("Result: "+flag);
		

	}

}