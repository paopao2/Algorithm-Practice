/** 
 * Breadth First Search, Depth First Search
 * */  

import java.util.*;

import sun.tools.tree.Node;

class Main {
	public void bfs() {
		Queue queue = new LinkedList();
		queue.add(this.rootNode);
		printNode(this.rootNode);
		rootNode.visited = true;
		while(!queue.isEmpty()) {
			Node node = (Node) queue.remove();
			Node child = null;
			while ((child=getUnvisitedChildNode(node))!=null) {
				child.visited=true;
				printNode(child);
				queue.add(child);
			}
			
		}
		clearNodes();
	}
	
	public void dfs() {
		Stack stack = new Stack();
		stack.push(this.rootNode);
		rootNode.visited = true;
		printNode(rootNode);
		while(!stack.isEmpty()) {
			Node node = (Node) stack.peek();
			Node child = getUnvisitedChildNode(n);
			if(child != null) {
				child.visited = true;
				printNode(child);
				stack.push(child);
			}
			else {
				stack.pop();
			}
		}
		clearNodes();
	}
	
}
