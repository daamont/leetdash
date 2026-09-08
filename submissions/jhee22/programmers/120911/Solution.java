import java.util.*; 
class Solution {
    public String solution(String my_string) {
        // String객체.toLowerCase() -> String 객체에 붙여 써야함 
        my_string = my_string.toLowerCase(); 
        // Arrays 쓰려면 String -> char[] 로 만들어야함 
        char[] arr = my_string.toCharArray(); 
        Arrays.sort(arr); 
        
        // String() 으로 묶으면 됨! 
        return new String(arr); 
    }
}