/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/

public class Solution {
    public int evalRPN(String[] exp) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
         Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < exp.length; i++) {
            if (exp[i].matches("-?[\\d]+")) {
                stack.push(Integer.parseInt(exp[i]));
            } else {
                int op2 = stack.pop();
                int op1 = stack.pop();
                int result = 0;
                String operator = exp[i];
                if (operator.equals("+")) result = op1 + op2;
                else if (operator.equals("-")) result = op1 - op2;
                else if (operator.equals("*")) result = op1 * op2;
                else if (operator.equals("/")) result = op1 / op2;
                stack.push(result);
            }
        }
        return stack.pop();
    }
}