import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BalancedBracket {

	public static boolean isBalanced(String expression) {
		if ((expression.length() % 2) == 1)
			return false;
		else {
			Stack<Character> s = new Stack<>();
			for (char bracket : expression.toCharArray())
				switch (bracket) {
				case '{':
					s.push('}');
					break;
				case '(':
					s.push(')');
					break;
				case '[':
					s.push(']');
					break;
				default:
					if (s.isEmpty() || bracket != s.peek()) {
						return false;
					}
					s.pop();
				}
			return s.isEmpty();
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		while (in.hasNext()) {

			String expression = in.next();
			System.out.println((isBalanced(expression)) ? "YES" : "NO");
		}

		/**
		 * int t = in.nextInt(); for (int a0 = 0; a0 < t; a0++) { String expression =
		 * in.next(); System.out.println( (isBalanced(expression)) ? "YES" : "NO" ); }
		 */
	}
}
