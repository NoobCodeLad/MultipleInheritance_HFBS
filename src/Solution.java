import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] hockeyPlayers = new int[11];
        int[] footballPlayers = new int[11];
        for (int i = 0; i < 11; i++)
        {
            hockeyPlayers[i] = sc.nextInt();
        }
        for (int i = 0; i < 11; i++)
        {
            footballPlayers[i] = sc.nextInt();
        }
        Sport s = new Sport(hockeyPlayers, footballPlayers);
        try {
            HockeyTeam.class.getMethod("calculateHockeyScore");
            HockeyTeam.class.getMethod("findHighestGoalByIndividualInHockey");
            FootballTeam.class.getMethod("calculateFootballScore");
            FootballTeam.class.getMethod("findHighestGoalByIndividualInFootball");

            if (s instanceof HockeyTeam && s instanceof FootballTeam) {
                System.out.println(s.calculateHockeyScore());
                System.out.println(s.calculateFootballScore());
                System.out.println(s.findHighestGoalByIndividualInHockey());
                System.out.println(s.findHighestGoalByIndividualInFootball());
            }
        } catch (NoSuchMethodException ex) {
            System.out.println("No such function is exits");
        }
    }
}
class Sport implements HockeyTeam,FootballTeam{
    int[] ht;
    int[] ft;
    public Sport(int[] hockeyPlayers, int[] footballPlayers) {
        ht=hockeyPlayers;
        ft=footballPlayers;
    }

    public int calculateHockeyScore() {
        int ths = 0;
        for (int i = 0; i < 11; i++) {
            ths+=ht[i];
        }
        return ths;
    }

    public int calculateFootballScore() {
        int tfs = 0;
        for (int i = 0; i < 11; i++) {
            tfs+=ft[i];
        }
        return tfs;
    }

    public int findHighestGoalByIndividualInHockey() {
        int hhs = 0;
        for (int i = 0; i < 11; i++) {
            if(hhs<=ht[i])
                hhs=ht[i];
        }
        return hhs;
    }

    public int findHighestGoalByIndividualInFootball() {
        int hfs = 0;
        for (int i = 0; i < 11; i++) {
            if(hfs<=ft[i])
                hfs=ft[i];
        }
        return hfs;
    }
}
interface HockeyTeam {
    int calculateHockeyScore();
    int findHighestGoalByIndividualInHockey();
}
interface FootballTeam {
    int calculateFootballScore();
    int findHighestGoalByIndividualInFootball();
}
