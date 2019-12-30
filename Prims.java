import java.util.ArrayList;

public class Prims {
	static ArrayList<ArrayList<Integer>> graphD = new ArrayList<ArrayList<Integer>>();

	Prims() {
	}

	final static int INFINITY = Integer.MAX_VALUE;;

	public void buildGraph(int vertex, ArrayList<Integer> list) {
		graphD.add(vertex, list);

	}

	public ArrayList<Integer> add(int[] array) {
		ArrayList<Integer> list = new ArrayList<Integer>(9);
		for (int i = 0; i < array.length; i++) {
			list.add(array[i]);
		}
		return list;

	}

	public static void PrimsMST(ArrayList<ArrayList<Integer>> graph, boolean visited_verteices[]) {
		int length = graph.size();
		int keys[] = new int[length];
		int parents[] = new int[length];

		for (int i = 1; i < keys.length; i++) {
			keys[i] = INFINITY;
		}
		keys[0] = 0;
		parents[0] = -1; // for the first vertex the parent is it self so we represent it as negative -1

		for (int i = 0; i < length - 1; i++) {
			// Find the vertex with the minimum distance from the starting vertex

			int u = min_Distance(keys, visited_verteices);
			visited_verteices[u] = true; // set the visited node to true
			/**
			 * First check if there is a path from the visited And check if the vertex is
			 * already visited Lastly, check is it is less than the stored key
			 */
			for (int v = 0; v < length; v++) {

				if (graph.get(u).get(v) != 0 && !visited_verteices[v] && graph.get(u).get(v) < keys[v]) {
					parents[v] = u;
					keys[v] = graph.get(u).get(v);
				}
			}
		}

		print(keys, parents);
	}

	public static void print(int[] keys, int[] parents) {
		int sum = 0;
		for (int i = 1; i < keys.length; i++) {
			System.out.println(parents[i] + " to " + i + " is " + keys[i]);
			sum += keys[i];
		

		}
		System.out.println("The total weight of the Minimum spanning tree is " + sum);

	}

	public static int min_Distance(int distance[], boolean sptSet[]) {
		int min = INFINITY, min_index = -1;

		for (int v = 0; v < distance.length; v++)

			if (sptSet[v] == false && distance[v] <= min) {
				min = distance[v];
				min_index = v;
			}

		return min_index;
	}

	public static void main(String[] args) {
		Dijkstra graph = new Dijkstra();
		int zero[] = { 0, 2, 0, 6, 0 };
		ArrayList<Integer> list0 = graph.add(zero);
		graph.buildGraph(0, list0);
		int one[] = { 2, 0, 3, 8, 5 };
		ArrayList<Integer> list1 = graph.add(one);
		graph.buildGraph(1, list1);
		int two[] = { 0, 3, 0, 0, 7 };
		ArrayList<Integer> list2 = graph.add(two);
		graph.buildGraph(2, list2);
		int three[] = { 6, 8, 0, 0, 9 };
		ArrayList<Integer> list3 = graph.add(three);
		graph.buildGraph(3, list3);
		int four[] = { 0, 5, 7, 9, 0 };
		ArrayList<Integer> list4 = graph.add(four);
		graph.buildGraph(4, list4);
		boolean[] visited = new boolean[9];

		PrimsMST(Dijkstra.graphD, visited);

	}

}
