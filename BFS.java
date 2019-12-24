import java.util.*;

public class BFS {
	LinkedList<Integer> list[];
	//Populate the list 
	public BFS(int v) {
		list = new LinkedList[v];
		for(int i = 0; i < list.length; i++) {
			list[i] = new LinkedList();
		}
		
		
	}
	//Build the graph
	public void buildGraph(int i, int v) {
		list[i].add(v);
	}
	//Implement BFS
	public void BFS(int s, boolean visted[]) {
		//Insert the starting node into the queue
		visted[s] = true;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(s);
		while(!queue.isEmpty()) {
			System.out.print(queue.poll() + "  ");
			Iterator<Integer> iter =  list[s].iterator();
			while(iter.hasNext()) {
				s = iter.next();
				if(!visted[s]) {
					visted[s] = true;
					queue.add(s);
					
				}
				
			}
			
			
		}
		
		
	}
	public static void main(String[] args) {
     BFS k = new BFS(8);	
     k.buildGraph(1, 4);
     k.buildGraph(1, 5);
     k.buildGraph(1, 2);
     k.buildGraph(5, 2);
     k.buildGraph(4, 2);
     k.buildGraph(2, 1);
     k.buildGraph(2, 3);
     k.buildGraph(2, 7);
     k.buildGraph(2, 6);
     k.buildGraph(3, 2);
     k.buildGraph(6, 2);
     k.buildGraph(7, 2);
     boolean visted[] = new boolean[8];
     k.BFS(1, visted);
     

	}

}
