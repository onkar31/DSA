package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
    public static void main(String[] args) {
        int n = 15;
        List<String> res = fizzBuzz(n);
        System.out.println(res);
    }

    public static List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1, fizz = 0, buzz = 0 ; i <= n; i++) {
            fizz++;
            buzz++;
            if( fizz % 3 == 0 && buzz % 5 == 0){
                res.add("FizzBuzz");
            }else if(fizz % 3 == 0){
                res.add("Fizz");
            }else if(buzz % 5 == 0){
                res.add("Buzz");
            }else {
                res.add(Integer.toString(i));
            }
        }
        return res;
    }
}
