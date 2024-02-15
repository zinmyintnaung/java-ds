//   anagrams('rail safety', 'fairy tales') --> True
//   anagrams('RAIL! SAFETY!', 'fairy tales') --> True
//   anagrams('Hi there', 'Bye there') --> False

import java.util.Arrays;

public class Anagrams {
    

    public static boolean isAnagrams(String str1, String str2){
        
        if(str1.length() != str2.length()){
            return false;
        }

        String sorted1[] = new String[str1.length()];
        String sorted2[] = new String[str2.length()];
        for(int i=0; i < str1.length(); i++){
            sorted1[i] = Character.toString(str1.charAt(i)).toLowerCase();
        }
        for(int i=0; i < str2.length(); i++){
            sorted2[i] = Character.toString(str2.charAt(i)).toLowerCase();
        }
        Arrays.sort(sorted1);
        Arrays.sort(sorted2);
        
        return Arrays.equals(sorted1, sorted2);
    }

    public static void main(String[] args) {
        
        System.out.println(isAnagrams("rail safety", "fairy tales"));
        System.out.println(isAnagrams("RAIL SAFETY", "fairy tales"));
        System.out.println(isAnagrams("Hello", "World"));
       
    }
}
