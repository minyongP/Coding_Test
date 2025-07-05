package combination;

import java.util.ArrayList;
import java.util.Arrays;

public class RockPaperScissors {
    public static void main(String[] args) {
        ArrayList<String[]> output = rockPaperScissors(1);

        System.out.println(output);

/*
    [
      ["rock", "rock", "rock", "rock", "rock"],
      ["rock", "rock", , "rock", "rock", "paper"],
      ["rock", "rock", , "rock", "rock", "scissors"],
      ["rock", "rock", "rock", "paper", "rock"],
      ["rock", "rock", "rock", "paper", "paper"],
      ["rock", "rock", "rock", "paper", "scissors"],
      ["rock", "rock", "rock", "scissors", "rock"],
      // ...etc ...
    ]
  */
    }

    public static ArrayList<String[]> rockPaperScissors(int rounds) {
        ArrayList<String[]> outcomes = new ArrayList<>();
        return permutation(rounds, new String[]{}, outcomes);
    }

    public static ArrayList<String[]> permutation(int roundsToGo, String[] playedSoFar, ArrayList<String[]> outcomes) {
        String[] rps = new String[]{"rock", "paper", "scissors"};

        if(roundsToGo == 0) {
            outcomes.add(playedSoFar);
            return outcomes;
        }

        for(int i = 0; i < rps.length; i++) {
            String currentPlay = rps[i];

            String[] concatArray = Arrays.copyOf(playedSoFar, playedSoFar.length + 1);
            concatArray[concatArray.length - 1] = currentPlay;
            outcomes = permutation(roundsToGo - 1, concatArray, outcomes);
        }

        return outcomes;
    }
}