package easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class IsValid_20 {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<Character>();
        Map<Character,Character> map=new HashMap<Character, Character>(){{put('(',')');put('[',']');put('{','}');}};
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                stack.push(s.charAt(i));
            }
            else if(stack.size()==0||map.get(stack.pop())!=s.charAt(i)){
                return false;
            }
        }
        return stack.size()==0;
    }

    public static void main(String[] args) {
        System.out.println(new IsValid_20().isValid("[]"));
    }

}
