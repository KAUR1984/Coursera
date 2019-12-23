package Coursera.AlgorithmsPart1.Week2;

//FIXME this is not working!! it just always taking the input!
import java.util.Scanner;
import java.util.Stack;

public class ArithmeticExpressionEvaluation {
    public static void main(String[] args) {

        Stack<Double> vals = new Stack<>();
        Stack<String> ops = new Stack<>();

        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String s = in.next();
            if(s.equals("("));
            else if(s.equals("+")) ops.push("+");
            else if(s.equals("*")) ops.push("*");
            else if(s.equals(")")) {
                String op = ops.pop();
                if(op.equals("+")) vals.push(vals.pop() + vals.pop());
                else if(op.equals("*")) vals.push(vals.pop() * vals.pop());
            }
            else{
                vals.push(Double.parseDouble(s));
            }
        }
        System.out.println(vals.pop());
    }
}
