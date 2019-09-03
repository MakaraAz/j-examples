package util;

import beans.Competitor;
import beans.User;
import config.Config;

import java.util.Scanner;

public class CompetitionUtil {

    public static Competitor[] registerCompetitors(){
        Scanner sc = new Scanner(System.in);
        System.out.println("How many competitors will participate in competition?");
        int competitorCount = sc.nextInt();
        Competitor[] competitors = new Competitor[competitorCount];
        for (int i=0; i<competitorCount; i++){
            Competitor competitor = registerCompetitor();
            competitors[i] = competitor;
        }
        Config.setCompetitors(competitors);
        System.out.println("All competitors successfully registered");
        return competitors;
    }

    public static Competitor registerCompetitor(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Competitor name: ");
        String name = sc.nextLine();
        System.out.println("Competitor surname: ");
        String surname = sc.nextLine();
        System.out.println("Competitor age: ");
        int age = sc.nextInt();
        Competitor competitor =new Competitor(name, surname, age);
        return competitor;
    }

    public static void registeredCompetitorsShow(){
        Competitor[] competitors = registerCompetitors();
        CompetitionUtil.printCompetitors(competitors);
    }

    public static void printCompetitors(Competitor[] competitors){
        if(competitors==null || competitors.length==0){
            return;
        }

        for (int i = 0; i<competitors.length; i++){
            Competitor c = competitors[i];
            System.out.println(c);
        }
    }

    public static void printCompetitors(){
        printCompetitors(Config.getCompetitors());
    }

    public static boolean startCompetiton(){
        int winner = 2;

        System.out.println("Guess winner?");
        Scanner sc = new Scanner(System.in);
        int guessWinner = sc.nextInt();
        if(guessWinner==winner){
            increasePoint();
            System.out.println("You won! Your point increases to "+Config.getUser().getPoint());
            return true;
        }else{
            System.out.println("You failed!");
            return false;
        }
    }

    public static void increasePoint(){
        User user = Config.getUser();
        user.setPoint(user.getPoint()+10);
    }

    public static void showPoint(){
        System.out.println("Your point: " + Config.getUser().getPoint());
    }

    public static void increaseCompetitors(){
        Competitor[] competitorsOld = Config.getCompetitors();
        if (competitorsOld==null || competitorsOld.length==0){
            System.out.println("you must be select 1st menu to insert competitors");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("How many competitors you want to append?");
        int increaseCount = sc.nextInt();
        Competitor[] competitorsNew = new Competitor[competitorsOld.length+increaseCount];

        for(int i=0; i<competitorsOld.length; i++){
            competitorsNew[i] = competitorsOld[i];
        }
        for(int i=competitorsOld.length; i<competitorsNew.length; i++){
            competitorsNew[i] = registerCompetitor();
        }

        Config.setCompetitors(competitorsNew);
    }
}