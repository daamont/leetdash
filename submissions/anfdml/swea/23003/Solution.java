import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String color1 = sc.next();
			String color2 = sc.next();
			int color11 = 0;
			int color22 = 0;
			
			String []arr = {"red","orange","yellow","green","blue","purple"};
			for (int i = 0; i < arr.length; i++) {
				if(arr[i].equals(color1)) {
					color11 = i;
				}
				if(arr[i].equals(color2)) {
					color22 = i;
				}
				
			}
			if(color11==color22) {
				System.out.println("E");
			}else if(Math.abs(color11-color22)==5||Math.abs(color11-color22)==1) {
				System.out.println("A");
			}else if(Math.abs(color11-color22)==3) {
				System.out.println("C");
			}else {
				System.out.println("X");
			}
		
			
			
			
		}
	}
}