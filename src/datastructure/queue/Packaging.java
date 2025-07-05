package datastructure.queue;

import java.util.*;
public class Packaging {
    public static void main(String[] args) {
        Integer[] boxes = new Integer[]{5, 1, 4, 6};
        int output = paveBox(boxes);
        System.out.println(output); // 3

        Integer[] boxes2 = new Integer[]{};
        int output2 = paveBox(boxes2);
        System.out.println(output2); // 1
    }

    // ArrayList를 활용한 풀이법
//    public static int paveBox(Integer[] boxes) {
//        ArrayList<Integer> answer = new ArrayList<>();
//        List<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(boxes));
//
//        while (arrayList.size() > 0) { // 만약 찾았다면, 해당 key를 answer에 넣고, ArrayList에서 그만큼 제외합니다.
//            for(int i = 0; i < arrayList.size(); i++) {
//                if(arrayList.get(i) > arrayList.get(0)) {
//                    answer.add(i);
//                    arrayList = arrayList.subList(i , arrayList.size());
//                    break;
//                }
//                // 만약 찾지 못했다면 answer에 arrayList 크기를 넣은 후, arrayList 내부의 요소를 전부 삭제합니다.
//                if(i == arrayList.size() - 1) {
//                    answer.add(arrayList.size());
//                    arrayList.clear();
//                }
//            }
//        }
//        return answer.stream().max(Integer::compare).orElse(-1);
//    }

    // Queue를 활용한 풀이법
     public static int paveBox(Integer[] boxes) {
       Queue<Integer> queue = new LinkedList<>(Arrays.asList(boxes));

       Integer first = queue.poll();
       int result = 1;
       int count = 1;

       while(queue.peek() != null) {
         Integer compare = queue.poll();
         if(first < compare) {
           result = Math.max(result,count);
           count = 1;
           first = compare;
         } else {
               count++;
           if(queue.isEmpty()) {
             result = Math.max(result,count);
           }
         }
       }
       return result;
     }
}