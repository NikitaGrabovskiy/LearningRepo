package Examples.Repeat;

import java.util.*;

public class Example50GenerateParentheses {
    /*
    Generate Parentheses
    Medium
            Topics
    premium lock icon
            Companies
    Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

    Example 1:

    Input: n = 3
    Output: ["((()))","(()())","(())()","()(())","()()()"]
    Example 2:

    Input: n = 1
    Output: ["()"]


    Constraints:

            1 <= n <= 8*/



    public static void main(String[] args) {
        List<String> res = new ArrayList<>();
        dfs(3,0,0,new StringBuilder(),res);
        System.out.println(res);
    }


    private static void dfs(int n, int open, int close, StringBuilder cur, List<String> res) {
        if(cur.length() == n*2){
            res.add(cur.toString());
            return;
        }

        if(open<n){
            cur.append("(");
            dfs(n,open+1,close,cur,res);
            cur.deleteCharAt(cur.length()-1);
        }

        if(close<open){
            cur.append(")");
            dfs(n,open,close+1,cur,res);
            cur.deleteCharAt(cur.length()-1);
        }
    }


}
