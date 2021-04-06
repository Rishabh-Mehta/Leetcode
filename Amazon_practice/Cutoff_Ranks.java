package Amazon_practice;

import java.util.Arrays;

//https://aonecode.com/amazon-online-assessment-cutoff-ranks

// A group of work friends at Amazon is playing a competitive video game together. During the game, each player receives a certain amount of points based on their performance. At the end of a round, players who achieve at least a cutoff rank get to "level up" their character, gaining increased abilities for them. Given the scores of the players at the end of the round, how many players will be able to level up their character?

// Note that players with equal scores will have equal ranks, but the player with the next lowest score will be ranked based on the position within the list of all players' scores. For example, if there are four players, and three players tie for first place, their ranks would be 1,1,1, and 4. Also, no player with a score of O can level up, no matter what their rank.

public class Cutoff_Ranks {
    public static int cutOffRank(int cutOffRank, int num, int[] scores) {
        int[] rank = new int[scores.length];
        int curr_rank = 1;
        int level_up = 0;
        Arrays.sort(scores);
        for(int i = num-1;i>=0;i--){
            if(i == num -1){
                rank[i] = curr_rank;
                
            }
            else if(scores[i] == scores[i+1]){
                rank[i] = rank[i+1];
            }
            else{
                rank[i] = curr_rank;
                
            }
            curr_rank++;
            System.out.println(rank[i]);
            if(rank[i] <= cutOffRank && scores[i] > 0){
                level_up++;
            }
        }
        return level_up;
    }
    public static void main(String[] args) {
        System.out.println(cutOffRank(3, 4, new int[]{100,50,50,25}));
        
    }
}
