package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllPathsFromSourceToTarget {
	List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		int n = graph.length;
		LinkedList<Integer> track = new LinkedList<>();
		track.add(0);
		dfs(graph, 0, n - 1, track);
		return res;
	}

	public void dfs(int[][] graph, int source, int target, LinkedList<Integer> track) {
		// base
		if (source == target) {
			res.add(new ArrayList<>(track));
			return;
		}
		for (int nextNode : graph[source]) {
			track.add(nextNode);
			dfs(graph, nextNode, target, track);
			track.removeLast();
		}
	}

}
