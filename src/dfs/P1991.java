package dfs;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


class TreeNode {
	char data;
	TreeNode left, right;

	TreeNode(char data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class P1991 {
	private static void preorder(TreeNode node) {
		if (node != null) {
			System.out.print(node.data);
			preorder(node.left);
			preorder(node.right);
		}
	}

	private static void inorder(TreeNode node) {
		if (node != null) {
			inorder(node.left);
			System.out.print(node.data);
			inorder(node.right);
		}
	}

	private static void postorder(TreeNode node) {
		if (node != null) {
			postorder(node.left);
			postorder(node.right);
			System.out.print(node.data);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		String[] nodes = new String[n];

		for (int i = 0; i < n; i++) {
			nodes[i] =  sc.nextLine();
		}

		Map<Character, TreeNode> nodesMap = new HashMap<>();
		TreeNode root = buildTree(nodesMap, nodes);

		preorder(root);
		System.out.println();
		inorder(root);
		System.out.println();
		postorder(root);
	}

	private static TreeNode buildTree(Map<Character, TreeNode> nodesMap, String[] nodes) {
		TreeNode root = null;

		for (String node : nodes) {
			char parent = node.charAt(0);
			char left =  node.charAt(2);
			char right = node.charAt(4);

			if (!nodesMap.containsKey(parent)) {
				nodesMap.put(parent, new TreeNode(parent));
			}

			TreeNode parentNode = nodesMap.get(parent);

			if (left != '.') {
				if (!nodesMap.containsKey(left)) {
					nodesMap.put(left, new TreeNode(left));
				}
				parentNode.left = nodesMap.get(left);
			}

			if (right != '.') {
				if (!nodesMap.containsKey(right)) {
					nodesMap.put(right, new TreeNode(right));
				}
				parentNode.right = nodesMap.get(right);
			}

			if (root == null) {
				root = parentNode;
			}
		}

		return root;
	}
}
