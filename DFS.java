
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

public class DFS {
	LinkedList<Integer> list[];

	public DFS(int v) {
		list = new LinkedList[v];
		for (int i = 0; i < list.length; i++) {
			list[i] = new LinkedList();
		}

	}

	public void buildGraph(int i, int v) {
		list[i].add(v);
	}

	public void DFS(int s, boolean visted[]) {

		visted[s] = true;
		Stack<Integer> stack = new Stack<>();
		stack.push(s);
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + "  ");
			Iterator<Integer> iter = list[s].iterator();
			while (iter.hasNext()) {
				s = iter.next();
				if (!visted[s]) {
					stack.push(s);
					visted[s] = true;

				}

			}

		}

	}

	public static void main(String[] args) {
		DFS k = new DFS(8);
		k.buildGraph(1, 4);
		k.buildGraph(1, 5);
		k.buildGraph(1, 2);
		k.buildGraph(5, 1);
		k.buildGraph(4, 1);
		k.buildGraph(2, 1);
		k.buildGraph(2, 3);
		k.buildGraph(2, 7);
		k.buildGraph(2, 6);
		k.buildGraph(3, 2);
		k.buildGraph(6, 2);
		k.buildGraph(7, 2);
		boolean visted[] = new boolean[8];
		k.DFS(1, visted);

	}

}
