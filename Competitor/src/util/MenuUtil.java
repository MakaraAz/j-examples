package util;

import config.Config;

import java.util.Scanner;

public class MenuUtil {

    public static int showMenu() {
        System.out.println("Please select menu:");
        String menuStr =
                        "1. Insert competitors\n" +
                        "2. Start game\n" +
                        "3. Show point\n" +
                        "4. Add new competitor\n" +
                        "5. Show all competitors\n" +
                        "6. Sign out\n" +
                        "7. Exit App";
        System.out.println(menuStr);
        Scanner sc = new Scanner(System.in);
        int selectedMenu = sc.nextInt();
        if (selectedMenu > 0 && selectedMenu <= 7){
            return selectedMenu;
        }else {
            System.out.println("Invalid menu selected");
            return -1;
        }
    }

    public static int showMenuInfinite(){
        while (true){
            int selectedMenu = showMenu();
            switch (selectedMenu){
                case 1:
                    CompetitionUtil.registeredCompetitorsShow();
                    break;
                case 2:
                    CompetitionUtil.startCompetiton();
                    break;
                case 3:
                    CompetitionUtil.showPoint();
                    break;
                case 4:
                    CompetitionUtil.increaseCompetitors();
                    break;
                case 5:
                    CompetitionUtil.printCompetitors();
                    break;
                case 6:
                    System.out.println("Logout");
                    UserUtil.requireInputsAndLogin(3,true);
                    break;
                case 7:
                    System.out.println("App stopped!");
                    System.exit(1);
                    break;
                default:
                    continue;
            }
        }
    }

}
