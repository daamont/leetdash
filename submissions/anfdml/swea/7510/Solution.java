import java.util.Iterator;
import java.util.Scanner;

class Solution
{
	static int count;
	
	static int N;
	
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N=sc.nextInt();
			count = 0;
			for (int i = 1; i <= N; i++) {
				dfs(0,i);
			}
			
			System.out.println("#"+test_case+" "+count);
		}
	}
	static void dfs(int sum, int num) {
		if(sum ==N) {
			count++;
			return;
		}	
		if(sum>N) {
			return;
		}
		dfs(sum+num, num+1);
	}
}