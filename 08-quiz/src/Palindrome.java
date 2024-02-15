/**
 * Palindrome
 */
public class Palindrome {

    public String input;

    public static boolean isPalindrome(String str){
        String check = "";

        for(int i=0; i < str.length(); i ++){
            check = Character.toString(str.charAt(i)) + check;
        }
       
        return check.equals(str);
    }

    public static void main(String[] args) {
        String input = "abba";

        System.out.println(isPalindrome(input));
    }
}