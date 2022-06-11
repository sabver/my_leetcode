package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import leetcode.util.TreeNode;

public class FindDuplicateSubtrees {
	String NULLMARK = "#";
	String COMA = ",";
	Map<String, TreeNode> map = new HashMap<>();
	Set<String> set = new HashSet<>();
	
	List<TreeNode> res = new ArrayList<>();
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
		helper(root);
		return res;
	}
	
	public void helper(TreeNode root) {
		if( root == null ) {
			return ;
		}
		String nodeStr = encode(root);
		if( map.containsKey(nodeStr) ) {
			if( set.contains(nodeStr) == false ) {
				res.add(map.get(nodeStr));
				set.add(nodeStr);
			}
		} else {
			map.put(nodeStr, root);
		}
		helper(root.left);
		helper(root.right);
	}
	
	public String encode(TreeNode root) {
		StringBuffer track = new StringBuffer();
		encodeHelper(root, track);
		return track.toString();
	}
	
	public void encodeHelper(TreeNode root, StringBuffer track) {
		if( root == null ) {
			track.append(NULLMARK).append(COMA);
			return ;
		}
		track.append(root.val).append(COMA);
		encodeHelper(root.left, track);
		encodeHelper(root.right, track);
	}

}
