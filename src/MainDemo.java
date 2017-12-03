import back_end.Controller;

import java.util.Scanner;

public class MainDemo {
    public static void main(String[] args) {
        int i = 0;
        String name = "";
        Controller controller = new Controller();

        Scanner scanner = new Scanner(System.in);

        while (Controller.getFlagTeam()) {
            System.out.println("Введите имя игрока");
            name = scanner.nextLine();
            Controller.addPlayer(name);
            System.out.println("Введите Y если игроков больше на будет");
            name = scanner.nextLine();
            if (name.equals("Y")) {
                Controller.setFlagTeam();
            }
        }

        while (i != -1) {
            System.out.println(" 1 - Кинуть кубик \n 2 - Построить дом \n 3 - Купить данную локацию \n 4 - Закончить ход \n 5 - Информация \n 6 - Карта \n 7 - trade \n 8 - заложить землю \n 9 - dвыкупить");
            i = scanner.nextInt();
        if(i == 1) {
            controller.movement();
        } else if(i == 2){
            controller.createHouse();
        } else if(i == 3){
            controller.returnPlace();
        } else if(i == 4){
            controller.exit();
        } else if(i == 5){
            controller.printInformation();
        } else if(i == 6){
            controller.getMapPlay();
        } else if(i == 7){
            controller.trade();
        } else if(i == 8){
            controller.Deposit();
        } else if(i == 9){
            controller.bayTerritoryOnDeposit();
        }

        }
    }
}
