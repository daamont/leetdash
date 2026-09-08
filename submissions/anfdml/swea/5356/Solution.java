import java.util.Iterator;
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
			String a = sc.next();
			String b = sc.next();
			String c = sc.next();
			String d = sc.next();
			String e = sc.next();//테스트 케이스당 5개 지정 
			System.out.print("#"+test_case+" ");
			for (int i = 0; i < 15; i++) { //1이상 15이하인 문자열이라 범위를1~15로 지정
				if(i<a.length()) {
					System.out.print(a.charAt(i));
				}if(i<b.length()) {
					System.out.print(b.charAt(i));
				}
				if(i<c.length()) {
					System.out.print(c.charAt(i));
				}
				if(i<d.length()) {
					System.out.print(d.charAt(i));
				}
				if(i<e.length()) {
					System.out.print(e.charAt(i));
				}
			}
			System.out.println();
			
		}
	}
}