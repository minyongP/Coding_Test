package base;

import java.util.ArrayList;

public class treeDFS {
    public static void main(String[] args) {
        Solution.tree root = new Solution.tree("1");
        Solution.tree rootChild1 = root.addChildNode(new Solution.tree("2"));
        Solution.tree rootChild2 = root.addChildNode(new Solution.tree("3"));
        Solution.tree leaf1 = rootChild1.addChildNode(new Solution.tree("4"));
        Solution.tree leaf2 = rootChild1.addChildNode(new Solution.tree("5"));
        ArrayList<String> output = Solution.dfs(root);
        System.out.println(output); // --> ["1", "2", "4", "5", "3"]

        leaf1.addChildNode(new Solution.tree("6"));
        rootChild2.addChildNode(new Solution.tree("7"));
        output = Solution.dfs(root);
        System.out.println(output); // --> ["1", "2", "4", "6", "5", "3", "7"]
    }

    private static class Solution {
        public static ArrayList<String> dfs(tree node) {
            ArrayList<String> list = new ArrayList<>();
            dfsRun(node, list);
            return list;
        }

        public static void dfsRun(tree node, ArrayList<String> list) {
            if (node == null) return;
            list.add(node.getValue());
            if (node.getChildrenNode() != null) {
                node.getChildrenNode().stream().forEach(child -> dfsRun(child, list));
            }
        }

        //아래 클래스의 내용은 수정하지 말아야 합니다.
        public static class tree {
            private String value;
            private ArrayList<tree> children;

            public tree(String data) {
                this.value = data;
                this.children = null;
            }

            public tree addChildNode(tree node) {
                if(children == null) children = new ArrayList<>();
                children.add(node);
                return children.get(children.size() - 1);
            }

            public String getValue() {      //현재 노드의 데이터를 반환
                return value;
            }

            public ArrayList<tree> getChildrenNode() {
                return children;
            }
        }
    }
}
