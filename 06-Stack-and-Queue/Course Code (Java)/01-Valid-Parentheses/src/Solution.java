import java.util.Stack;
// 20. Valid Parentheses
// https://leetcode.com/problems/valid-parentheses/description/

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 */
// 时间复杂度: O(n)
// 空间复杂度: O(n)
public class Solution {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<Character>();
        for( int i = 0 ; i < s.length() ; i ++ )
            if( s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                stack.push(s.charAt(i));
            else{
                // 很多的代码写法都是先写这种特殊情况和退出条件
                // 栈中不是左边的括号，且空间不为 0
                if( stack.size() == 0 )
                    return false;

                Character c = stack.pop();

                Character match;
                if( s.charAt(i) == ')' )
                    match = '(';
                else if( s.charAt(i) == ']' )
                    match = '[';
                else{
                    assert s.charAt(i) == '}';
                    match = '{';
                }

                if(c != match)
                    return false;
            }
        // 右侧元素都匹配完了，左侧也应该没有元素了才对
        if( stack.size() != 0 )
            return false;

        return true;
    }

    private static void printBool(boolean b){
        System.out.println(b ? "True" : "False");
    }

    public static void main(String[] args) {

        printBool((new Solution()).isValid("()"));
        printBool((new Solution()).isValid("()[]{}"));
        printBool((new Solution()).isValid("(]"));
        printBool((new Solution()).isValid("([)]"));
    }
}
