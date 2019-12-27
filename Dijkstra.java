import java.util.*;

public class Dijkstra {
	static ArrayList<ArrayList<Integer>> graphD = new ArrayList<ArrayList<Integer>>();

	Dijkstra() {
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

	public static int[] dijkstra(ArrayList<ArrayList<Integer>> graph, int startingVertex,
			boolean distance_calculated_vertices[]) {
		int length = graph.size();
		int distance[] = new int[length];
		distance[startingVertex] = 0; // Distance of starting vertex is always zero
		for (int i = 1; i < distance.length; i++) {
			distance[i] = INFINITY;
		}
		/**
		 * length-1 because the we do not need to check if there are vertices adjacent
		 * to the last vertex since all the vertices'distances have been already
		 * calculated
		 */
		for (int i = 0; i < length - 1; i++) {
			// Find the vertex with the minimum distance from the starting vertex

			int u = min_Distance(distance, distance_calculated_vertices);
			distance_calculated_vertices[u] = true;
			/**
			 * To update the distance or do the relaxation check the following conditions 1.
			 * if there is a straight path from the source vertex to a vertex 2. If its
			 * distance from the source is not already calculated 3. If its current value is
			 * less than from the calculated distance
			 */
			for (int v = 0; v < length; v++) {

				if (graph.get(u).get(v) != 0 && distance[u] != INFINITY && !distance_calculated_vertices[v]
						&& distance[u] + graph.get(u).get(v) < distance[v]) {
					distance[v] = distance[u] + graph.get(u).get(v);
				}
			}
		}
		return distance;

	}

	public static void print(int[] distance) {

		for (int i = 0; i < distance.length; i++) {
			System.out.println(distance[i]);

		}

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
		int zero[] = { 0, 4, 0, 0, 0, 0, 0, 8, 0 };
		ArrayList<Integer> list0 = graph.add(zero);
		graph.buildGraph(0, list0);
		int one[] = { 4, 0, 8, 0, 0, 0, 0, 11, 0 };
		ArrayList<Integer> list1 = graph.add(one);
		graph.buildGraph(1, list1);
		int two[] = { 0, 8, 0, 7, 0, 4, 0, 0, 2 };
		ArrayList<Integer> list2 = graph.add(two);
		graph.buildGraph(2, list2);
		int three[] = { 0, 0, 7, 0, 9, 14, 0, 0, 0 };
		ArrayList<Integer> list3 = graph.add(three);
		graph.buildGraph(3, list3);
		int four[] = { 0, 0, 0, 9, 0, 10, 0, 0, 0 };
		ArrayList<Integer> list4 = graph.add(four);
		graph.buildGraph(4, list4);
		int five[] = { 0, 0, 4, 14, 10, 0, 2, 0, 0 };
		ArrayList<Integer> list5 = graph.add(five);
		graph.buildGraph(5, list5);
		int six[] = { 0, 0, 0, 0, 0, 2, 0, 1, 6 };
		ArrayList<Integer> list6 = graph.add(six);
		graph.buildGraph(6, list6);
		int seven[] = { 8, 11, 0, 0, 0, 0, 1, 0, 7 };
		ArrayList<Integer> list7 = graph.add(seven);
		graph.buildGraph(7, list7);
		int eight[] = { 0, 0, 2, 0, 0, 0, 6, 7, 0 };
		ArrayList<Integer> list8 = graph.add(eight);
		graph.buildGraph(8, list8);
		boolean[] visited = new boolean[9];

		print(dijkstra(Dijkstra.graphD, 0, visited));

	}

}
