import java.util.ArrayList;
import java.util.Scanner;

class Solution
{
	static int[] arr;
	static ArrayList<Integer>[] ans;
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int K = sc.nextInt();
			int N=(int) Math.pow(2, K)-1;
			arr= new int[N];
			for (int i = 0; i < N; i++) {
				arr[i]= sc.nextInt();
			}
			ans=new ArrayList[K];
			for (int i = 0; i < K; i++) {
				ans[i]=new ArrayList<>();
			}
			dfs(0,N-1,0);
			
			System.out.print("#"+test_case+" ");
			
			for (int i = 0; i < K; i++) {
				for (int j = 0; j < ans[i].size(); j++) {
					System.out.print(ans[i].get(j)+" ");
				}
				System.out.println();
			}
			
		}
	}
	static void dfs(int start, int end,int depth) {
		if(start>end) {
			return;
		}
		
		
		int mid = (start+end)/2;
		
		ans[depth].add(arr[mid]);
		
		dfs(start,mid-1,depth+1);
		
		dfs(mid+1,end,depth+1);
		
	}
}