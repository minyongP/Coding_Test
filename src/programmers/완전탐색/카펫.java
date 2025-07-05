package programmers.완전탐색;

import java.util.Arrays;

/*
Leo는 카펫을 사러 갔다가 아래 그림과 같이 중앙에는 노란색으로 칠해져 있고 테두리 1줄은 갈색으로 칠해져 있는 격자 모양 카펫을 봤습니다.
Leo는 집으로 돌아와서 아까 본 카펫의 노란색과 갈색으로 색칠된 격자의 개수는 기억했지만, 전체 카펫의 크기는 기억하지 못했습니다.
Leo가 본 카펫에서 갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때 카펫의 가로, 세로 크기를 순서대로 배열에 담아 return 하도록 solution 함수를 작성해주세요.
갈색 격자의 수 brown은 8 이상 5,000 이하인 자연수입니다.
노란색 격자의 수 yellow는 1 이상 2,000,000 이하인 자연수입니다.
카펫의 가로 길이는 세로 길이와 같거나, 세로 길이보다 깁니다.
 */
public class 카펫 {
    public static void main(String[] args) {
        int brown = 24;
        int yellow = 24;
        int[] answer = {};

        // 노란색이 정사각형에 가가울수록 브라운이 작아진다
        // 노란색이 1열 직사각형에서 정사각형으로 변경하면서 브라운 갯수에 맞는걸 찾기

        int maxYellowWidth = (int)Math.sqrt(yellow);

        // 갈색의 크기는 (노랑가로 +2) * 2 + 노랑세로
        for (int i = 1; i < maxYellowWidth+1; i++) {
            int yellowWidth = i;
            int yellowLength = yellow/i;
            int brownLength = yellowLength + 2;
            int brownWidth = yellowWidth+2;

            if (brown == (brownLength + yellowWidth) * 2) {
                answer = new int[]{brownLength, brownWidth};
            }
        }

        System.out.println(Arrays.toString(answer));

    }
}
