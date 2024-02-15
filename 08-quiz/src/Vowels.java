import java.util.Set;

public class Vowels {
    private static final Set<String> vowels = Set.of("a","e","i","o", "u");
        
    public static int countVowels(String str){
        int count = 0;
        for(int i=0; i < str.length(); i ++){
            if(vowels.contains(Character.toString(str.charAt(i)))){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countVowels("Hello World"));
    }
}