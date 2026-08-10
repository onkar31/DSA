package leetcode;

public class ConvertStringToLowerCase {
    public static void main(String[] args) {
        String str = "Hello There";
        System.out.println(toLowerCase(str));
    }

    public static String toLowerCase(String str){
        String result = "";
        for (char c: str.toCharArray()){
            if(Character.isUpperCase(c)){
                result = result + (char)(c + 32);
            }else {
                result = result + c;
            }
        }
        return result;
    }
}
