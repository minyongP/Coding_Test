package programmers;

import java.util.ArrayList;
/*
자연수 n이 주어졌을 때, n의 다음 큰 숫자는 다음과 같이 정의 합니다.

조건 1. n의 다음 큰 숫자는 n보다 큰 자연수 입니다.
조건 2. n의 다음 큰 숫자와 n은 2진수로 변환했을 때 1의 갯수가 같습니다.
조건 3. n의 다음 큰 숫자는 조건 1, 2를 만족하는 수 중 가장 작은 수 입니다.
예를 들어서 78(1001110)의 다음 큰 숫자는 83(1010011)입니다.

자연수 n이 매개변수로 주어질 때, n의 다음 큰 숫자를 return 하는 solution 함수를 완성해주세요.

1.무한반복 ver
2.패턴화 ver
 */
public class 다음큰숫자 {
    public static void main(String[] args) {
        int n = 78;
//        int answer = 0;
        int answer = n+1;

        // 이진수 변환
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (n > 0) {
            arrayList.add(0,n % 2);
            n /= 2;
        }

        // 1. 무한반복 ver
        // 1의 갯수 카운트
        int oneCount = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) == 1) oneCount++;
        }


        // n보다 1씩 증가시켜 1의 갯수가 서로 같을때까지 반복
        int temp = answer;
        while (true) {
            answer = temp;
            int tempOneCount = 0;
            ArrayList<Integer> tempArrayList = new ArrayList<>();
            while (answer > 0) {
                tempArrayList.add(0,answer % 2);
                answer /= 2;
            }
            for (int i = 0; i < tempArrayList.size(); i++) {
                if (tempArrayList.get(i) == 1) tempOneCount++;
            }
            if (oneCount == tempOneCount) {
                arrayList = tempArrayList;
                break;
            }
            else temp++;
        }

//        2.패턴화 ver
//        int loc = 0;
//        for (int i = arrayList.size()-1; i > 0; i--) {
//            // 처음으로 01 패턴일때 10으로 변환
//            if (arrayList.get(i) == 1 && arrayList.get(i-1) == 0) {
//                arrayList.set(i, 0);
//                arrayList.set(i-1, 1);
//                loc = i;
//                break;
//            }
//            // 비트를 바꿀 수 없는 경우 앞에 0을 붙여주고 다시 실행
//            else if (i == 1) {
//                arrayList.add(0, 0);
//                i = arrayList.size();
//            }
//        }
//
//        // 그 뒤 숫자를 모두 0으로 변환후 1의 개숫만큼 뒤에서 채우기
//        int oneCount = 0;
//        for (int i = loc; i < arrayList.size(); i++) {
//            if (arrayList.get(i) == 1) oneCount++;
//            arrayList.set(i, 0);
//        }
//
//        for (int i = arrayList.size()-1; i > arrayList.size()-1-oneCount; i--) {
//            arrayList.set(i, 1);
//        }

        // 십진법으로 변환
        for (int i = 0; i < arrayList.size(); i++) {
            answer = answer * 2 + arrayList.get(i);
        }

        System.out.println(answer);
    }
}
