import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
	    /* 입력 및 변수 초기화 */
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    toPostfix(br.readLine());
	}

	/* Stack : 중위표기식으로 후위표기식 구하기 */
	private static void toPostfix(String infix) {
	    StringBuilder sb = new StringBuilder();
	    Stack<Character> stack = new Stack<>();
	    for(char ex : infix.toCharArray()) {
	    	if(ex >= 'A') {
	    		sb.append(ex);
	    		continue;
	    	}
	    	
	        if(ex == '(') {
	            stack.add(ex);
	            continue;
	        }

	        if(ex == ')') {
	            while(!stack.isEmpty()) {
	            	if(stack.peek() == '(') {
	            		stack.pop();
	            		break;
	            	}
	                sb.append(stack.pop());
	            }
	            continue;
	        }

	        while(!stack.isEmpty() && priority(stack.peek()) >= priority(ex)) {
	        	if (stack.peek() == '(') {
	        		break;
	        	}
	        	sb.append(stack.pop());
	        }
	        stack.add(ex); 
	    }
	    
	    while(!stack.isEmpty()) {
	    	sb.append(stack.pop());
	    }

	    System.out.println(sb);
	}

	private static int priority(char ex) {
		if(ex == '+' || ex == '-') {
			return 1;
		}
		return 2;
	}
}