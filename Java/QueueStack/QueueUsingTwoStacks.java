import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class QueueUsingTwoStacks {
	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<Integer>();

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		for (int i = 0; i < n; i++) {
			int operation = scan.nextInt();
			if (operation == 1) { // enqueue
				queue.enqueue(scan.nextInt());
			} else if (operation == 2) { // dequeue
				queue.dequeue();
			} else if (operation == 3) { // print/peek
				System.out.println(queue.peek());
			}
		}
		scan.close();
	}
}

class MyQueue<T> {
	Stack<T> in = new Stack<T>();
	Stack<T> out = new Stack<T>();

	public void enqueue(T in_) {
		if (in_ != null) {
			in.push(in_);
		}
	}

	public T dequeue() {
		if (out.isEmpty()) {
			while (!in.empty()) {
				out.push(in.pop());
			}

		}
		return out.pop();

	}

	public T peek() {
		if (out.isEmpty()) {
			while (!in.empty()) {
				out.push(in.pop());
			}
		}

		return out.peek();
	}

}