package trainingday1;
import java.util.*;



public class Main {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		/*
		String [] tags = { "king", "og"};
		int i=0;
		
		while(i!=-1) {
			System.out.println("Enter to get your title");
			
			i=sc.nextInt();
			Random rand=new Random();
			int b=(rand.nextInt(2));
			System.out.println("You are "+ tags[b]);
		}
		*/
		System.out.println("Enter the size of the array?");
		int size=sc.nextInt();
		int [] a=new int[size];
		for(int i=0; i<size; i++) {
			a[i]=sc.nextInt();
		}
		try {
		System.out.println(a[a.length-2]);
		}
		catch(Exception e){
		System.out.println(e.getMessage());
		}
		
		
		
		
		

	}

}
