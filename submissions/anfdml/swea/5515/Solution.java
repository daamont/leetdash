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
			int m = sc.nextInt();
			int d = sc.nextInt();
			
			int arr[] ={0 , 31 , 29 , 31 , 30 , 31 , 30 , 31 , 31 , 30 , 31 , 30 , 31};
			
			int sum= 0; 
			
			for (int i = 1; i < m; i++) {
				sum +=arr[i];
			}
			
			sum += d-1;
			int ans = (4+sum)%7;
			System.out.println("#" +test_case + " " + ans );
		}
	}
}