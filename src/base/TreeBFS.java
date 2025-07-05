package base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TreeBFS {
    public static void main(String[] args) {
        Solution.tree root = new Solution.tree("1");
        Solution.tree rootChild1 = root.addChildNode(new Solution.tree("2"));
        Solution.tree rootChild2 = root.addChildNode(new Solution.tree("3"));
        Solution.tree leaf1 = rootChild1.addChildNode(new Solution.tree("4"));
        Solution.tree leaf2 = rootChild1.addChildNode(new Solution.tree("5"));
        ArrayList<String> output = Solution.bfs(root);
        System.out.println(output); // --> ["1", "2", "3", "4", "5"]

        leaf1.addChildNode(new Solution.tree("6"));
        rootChild2.addChildNode(new Solution.tree("7"));
        output = Solution.bfs(root);
        System.out.println(output); // --> ["1", "2", "3", "4", "5", "7", "6"]


    }
    private static class Solution {
        public static ArrayList<String> bfs(tree node) {
            ArrayList<String> values = new ArrayList<>();
            Queue<tree> queue = new LinkedList<>();
            queue.add(node);
            bfsRun(queue, values);
            return values;
        }

        private static void bfsRun(Queue<tree> queue, ArrayList<String> values) {
            if (queue.isEmpty()) {
                return;
            }

            tree curNode = queue.poll();
            values.add(curNode.getValue());

            if (curNode.getChildrenNode() != null) {
                queue.addAll(curNode.getChildrenNode());
            }

            bfsRun(queue, values);
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
