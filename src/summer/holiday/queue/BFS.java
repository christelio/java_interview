package summer.holiday.queue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


//BFS搜索最短路径
public class BFS {
	//结点类
	class Node {
		public String id;
		public Node parent;
		public List<Node> childs = new ArrayList<Node>();

		public Node(String id, Node parent) {
			this.id = id;
			this.parent = parent;
		}
	}
	//map用来存储相邻结点之间的关系
	public Node findtarget(String startId, String targetId, HashMap<String, String[]> map) {
		List<String> hasSearchList = new ArrayList<String>();
		LinkedList<Node> queue = new LinkedList<Node>();
		// 入队
		queue.offer(new Node(startId, null));
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (hasSearchList.contains(node)) {
				continue;
			}
			if (targetId.equals(node.id)) {
				return node;
			}
			if (map.get(node.id) != null && map.get(node.id).length > 0) {
				for (String childId : map.get(node.id)) {
					queue.offer(new Node(childId, null));
				}
			}
		}
		return null;
	}
}
