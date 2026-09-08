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
			int N = sc.nextInt();
			int arr[] = new int[N];
			int count=0;
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			for (int i = 1; i < arr.length-1; i++) {
				if(arr[i]>arr[i-1]) {
					if(arr[i]<arr[i+1]) {
						count++;
					}
				}
				if(arr[i-1]>arr[i]) {
					if(arr[i+1]<arr[i]) {
						count++;
					}
				}
			}
			System.out.println("#" +test_case + " " + count);
			
		}
	}
}