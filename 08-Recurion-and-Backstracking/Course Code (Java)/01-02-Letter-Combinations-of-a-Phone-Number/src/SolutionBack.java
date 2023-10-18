import java.util.ArrayList;
import java.util.List;

/// 17. Letter Combinations of a Phone Number
/// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

/**
 * 手机号码组成的 排列问题
 * 这其实是一种 暴力的解法
 */
/// 时间复杂度: for循环执行轮数  O(2^len(s)) ==  O( 2^len(digits) )
/// 空间复杂度: 递归深度        O(len(s)) ==  len(digits)
class SolutionBack {

    private String letterMap[] = {
                " ",    //0
                "",     //1
                "abc",  //2
                "def",  //3
                "ghi",  //4
                "jkl",  //5
                "mno",  //6
                "pqrs", //7
                "tuv",  //8
                "wxyz"  //9
    };

    private ArrayList<String> res;

    public List<String> letterCombinations(String digits) {

        res = new ArrayList<String>(); // 为存放结果的动态数组开辟空间

        if(digits.equals(""))  // 处理用户输入的特殊情况
            return res;

        findCombination(digits, 0, "");
        return res;
    }

    // s中保存了此时从digits[0...index-1]翻译得到的一个字母字符串
    // 寻找和digits[index]匹配的字母, 获得digits[0...index]翻译得到的解
    // digits: "234" 要处理的数字字符串
    // index : 数字字符串的第几位 
    // s ：已经处理的数字字符部分拼接起来的阶段性答案
    private void findCombination(String digits, int index, String s){

        System.out.println("数字字符串的第几位:"+index + " : " + s);
        if(index == digits.length()){
            res.add(s);
            System.out.println("get " + s + " , return");
            return;
        }

        Character c = digits.charAt(index);
        assert  c.compareTo('0') >= 0 &&
                c.compareTo('9') <= 0 &&
                c.compareTo('1') != 0; // 因为 按键1 什么也没有
        String letters = letterMap[c - '0']; // 获取单个键盘数字对应的字母字符串
        // 核心逻辑 digits（234 abc def ghi）letters（abc）每一轮都不一样 这里构成了一个排列问题
        // for 循环下有递归，其实这里会有好几轮 for 循环，轮数为递归的深度，深度为digits的长度
        for(int i = 0 ; i < letters.length() ; i ++){
            System.out.println("digits[" + index + "] = " + c +" , use " + letters.charAt(i));
            findCombination(digits, index+1, s + letters.charAt(i));
        }

        System.out.println("digits[" + index + "] = " + c + " complete, return");

        return;
    }

    private static void printList(List<String> list){
        for(String s: list)
            System.out.println(s);
    }

    public static void main(String[] args) {

        printList((new SolutionBack()).letterCombinations("23"));
    }
}
