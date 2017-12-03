package back_end;

import back_end.Maps.*;
import back_end.Play.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    Scanner scanner = new Scanner(System.in);
    static boolean flagTeam = true;
    private Map maps = new Map();
    private static ArrayList<Player> players = new ArrayList<Player>();

    public Controller() {
        maps.addSite();
    }

    private static Player player;

    private static int course = 0;
    private static int x = 0;

    private static int i = 1;

    public static void addPlayer(String name) {//добавление игрока
        if (players.size() <= 4) {
            players.add(new Player(name));
            player = players.get(0);
        } else {
            System.out.println("Максимум игроков");
        }

        if (players.size() == 4) {
            setFlagTeam();
            System.out.println("Установленно максимально возможное число игроков");
        }
    }

    private void courses() {//механизм последовательности ходов
        for (Player p : players) {
            if (p.getFlagCourse()) {
                this.player = p;
                System.out.println("Ход игрока " + p.getName());
                return;
            }
        }
    }

    private int setCountCub() {
        int a = 1 + (int) (Math.random() * 6);
        return a;
    }


    public void movement() {//движение
        if (player.getFlagDrop()) {
            int a = setCountCub();
            System.out.println("Кубик А - " + a);
            int b = setCountCub();
            System.out.println("Кубик Б - " + b);
            x = (player.getX() + a + b);
            if (!checkJail()) {
                if (x <= 39) {
                    player.setX(x);
                } else if (x > 39) {
                    x = x - 39;
                    player.setX(x);
                    player.setMoney(player.getMoney() + 350);
                }
                System.out.println(maps.getTeamSite().get(player.getX()).getName() + " - " + maps.getTeamSite().get(player.getX()).getType().getDescription());
                checkType(player.getX());
                System.out.println("Вы перешли на : " + maps.getTeamSite().get(player.getX()).getName());
                player.trigDrop();
                checkMoney();//напоминалка про деньги
            } else {
                player.trigDrop();
            }
        }
    }

    private boolean checkType(int x) {//проверк типа территории
        Parts thisPart = maps.getTeamSite().get(x);
        boolean flag = false;
        if (thisPart.getType().getDescription().equals("NON")) {
            if (thisPart.getName().equals("Community Chest")) {
                System.out.println("Плюс 50 монет");
                player.setMoney(player.getMoney() + 100);
            } else if (thisPart.getName().equals("Chance")) {
                System.out.println("Вы взяли карту и читаете : ");
                chanceF();
            } else if (thisPart.getName().equals("Pay Money")) {
                System.out.println("Минус 80 монет");
                player.setMoney(player.getMoney() - 150);
            }
        } else if (thisPart.getType().getDescription().equals("BIG")) {
            if (thisPart.getName().equals("Free Parking")) {
                System.out.println("Бесплатная парковка) ");
            } else if (thisPart.getName().equals("Go to jail")) {
                player.setX(10);
                player.setFlagJail(true);
                player.setJailCourse(3);
                System.out.println("Игрок " + player.getName() + " В тюрьме");
            } else if (thisPart.getName().equals("JAIL")) {
                System.out.println("Экскурсия по тюремному блоку нашего славного замка)");
            } else if (thisPart.getName().equals("GO")) {
                System.out.println("Получите 350 кровных монеточек");
            }
        } else {
            PartTypeSite part = (PartTypeSite) maps.getTeamSite().get(player.getX());
            if (!part.getFlag()) {
                for (Player p : players) {
                    if (ifIHavePlace(part, p, 1)) {
                        p.setMoney(p.getMoney() + part.getRent());
                        player.setMoney(player.getMoney() - part.getRent());
                        System.out.println("Игрок " + player.getName() + " платит " + part.getRent() + " игроку " + p.getName());
                    }
                }
            }
            flag = true;
        }
        System.out.println(flag + " - ИзчекТипа");
        return flag;
    }

    public String getType(int x) {
        Parts thisPart = maps.getTeamSite().get(x);

        if (thisPart.getType().getDescription().equals("NON")) {

            if (thisPart.getName().equals("Community Chest"))
                return "Communite Chest";
            else if (thisPart.getName().equals("Chance"))
                return "Chance";
            else if (thisPart.getName().equals("Pay Money"))
                return "PayMoney";
            else return "";

        } else if (thisPart.getType().getDescription().equals("BIG")) {
            return "BIG";
        } else {
            if (thisPart.getType().getDescription().equals("Сервис") || thisPart.getType().getDescription().equals("Вокзал"))
                return "T";
            else
                return "K";
        }
    }

    public void returnPlace() {
        Parts part = maps.getTeamSite().get(player.getX());
        bayPlace((PartTypeSite) part);

    }

    //===================================================================||
    //  Проверить функцию покупки на предмет сервиса и железной дороги   ||
    //===================================================================||
    public void bayPlace(PartTypeSite part) {
        if (part.getFlag()) {
            //System.out.println("Если хотите купить данное место введите Y или Yes, любое другое сочетание символов расценивается как отказ");
            //String str = scanner.nextLine();
            //if (str.equals("Y") || str.equals("Yes")) {
                if (player.getMoney() >= part.getPrice()) {
                    player.setMoney(player.getMoney() - part.getPrice());
                    player.addPlace(part);
                    part.setFlag();
                    System.out.println("Вы приобрели" + part.getName());
                    if (part.getType().getDescription().equals("Вокзал") || part.getType().getDescription().equals("Сервис")) {
                        if (ifIHavePlace(part, player, 3)) {
                            if (!ifIHavePlace(part, player, 2)) {
                                part.setRent(part.getRent() * 2);
                            } else {
                                System.out.println("У вас уже есть это место");
                            }
                        } else {
                            System.out.println("У вас нет нужной суммы");
                        }
                    }
                }
            //}
        } else {
            System.out.println("Эта территория уже куплена");
        }
    }

    public Player getPlayer() {
        return player;
    }

    public void createHouse() {//постройка
        //player.printMyCollection();
        //System.out.println("Введите номер территории на которой будете строить");
        //int select = scanner.nextInt();//1
        if(getType(player.getX()).equals("K")) {
            PartTypeSite place = (PartTypeSite) maps.getTeamSite().get(player.getX());
            if (player.getMyCollections().size() > 0) {
                System.out.println(player.getMyCollections().size() + " - размер");
                if (getCountPlace(place.getType(), maps.getTeamSite(), player.getMyCollections())) {
                    if (place.getPrice() <= player.getMoney()) {
                        place.setCouttHouse();
                    } else {
                        System.out.println("У вас недостаточно денег");
                    }
                } else {
                    System.out.println("У вас не вся коллекция");
                }
            } else {
              System.out.println("Вы пока не имеете своих владений");
            }
        } else {
            System.out.println("Эту территорию купить нельзя");
        }
    }

    private boolean checkJail() {//проверка тюрьмы
        if (player.getFlagJail()) {
            if (player.getJailCourse() > 0) {
                player.setJailCourse(player.getJailCourse() - 1);
            } else {
                player.setFlagJail(false);
            }
        }

        return player.getFlagJail();
    }

    private void checkMoney() {
        if (player.getMoney() < 0) {
            System.out.println("Вы ушли в минус, просьба вернуть долги банку или вы будите исключены из игры)");
        }
    }

    private void chanceF() {//Недошанс
        for (Chance chance : Chance.values()) {
            if (chance.getNumber() == i) {
                if (chance.getNumber() == 1) {
                    System.out.println(chance.getDescription());
                    System.out.println("Заплатите " + chance.getMoney());
                    player.setMoney(player.getMoney() + chance.getMoney());

                } else if (i == 2) {
                    System.out.println(chance.getDescription());
                    while (player.getX() % 10 != 5) {
                        player.setX(player.getX() + 1);
                        if (player.getX() == 40) {
                            player.setX(0);
                            player.setMoney(player.getMoney() + 350);
                        }
                    }
                    bayPlace((PartTypeSite) (maps.getTeamSite().get(player.getX())));

                } else if (chance.getNumber() == 3) {
                    System.out.println(chance.getDescription());
                    player.setX(player.getX() - chance.getMov());

                } else if (chance.getNumber() == 4) {
                    System.out.println("Пустая карта");

                } else if (chance.getNumber() == 5) {
                    System.out.println(chance.getDescription());
                    while (!equal("St.James Place")) {
                        player.setX(player.getX() + 1);

                        if (player.getX() == 40)
                            player.setX(0);

                    }
                    bayPlace((PartTypeSite) (maps.getTeamSite().get(player.getX())));

                } else if (chance.getNumber() == 6) {
                    System.out.println(chance.getDescription());
                    do {
                        player.setX(player.getX() + 1);
                        if (player.getX() == 40) {
                            player.setX(0);
                        }

                        if (maps.getTeamSite().get(player.getX()).getName().equals("JAIL"))
                            player.setFlagJail(true);
                        player.setJailCourse(3);
                    } while (equal("JAIL"));
                } else if (i == 7) {
                    System.out.println(chance.getDescription());
                    player.setMoney(player.getMoney() + chance.getMoney());

                }
            }
        }
        i = i + 1;
        if (i == 8) {
            i = 1;
        }

    }

    private boolean equal(String str) {
        return maps.getTeamSite().get(player.getX()).getName().equals(str);
    }

    private boolean getCountPlace(Colour type, ArrayList<Parts> collection1, ArrayList<PartTypeSite> collection2) {
        int count1 = 0, count2 = 0;
        boolean flag = false;
        for (Parts p : collection1) {
            if (p.getType().getDescription().equals(type)) {
                count1++;
            }
        }

        for (PartTypeSite p : collection2) {
            if (p.getType().getDescription().equals(type)) {
                count2++;
            }
        }

        if (count1 == count2) {
            flag = true;
        }

        return flag;
    }

    private boolean ifIHavePlace(PartTypeSite part, Player player, int i) {//проверка территорий
        boolean flagType = false;
        boolean flagName = false;
        boolean flagSum = false;
        for (PartTypeSite place : player.getMyCollections()) {
            if (part.getType().getDescription().equals(place.getType().getDescription())) {
                flagType = true;
            }

            if (part.getName().equals(place.getName())) {
                flagName = true;
            }
        }

        if (i == 1) {
            if (flagName && flagType) {
                flagSum = true;
            }
        } else if (i == 2) {
            if (flagName) {
                flagSum = true;
            }
        } else if (i == 3) {
            if (flagType) {
                flagSum = true;
            }
        }

        return flagSum;
    }

    public void Deposit() {//залог территорий
        int j = 0;
        for (PartTypeSite p : player.getMyCollections()) {
            j++;
            System.out.println(j + " - " + p.getName());
        }

        System.out.println("Введите индекс территории");

        int selector = scanner.nextInt();
        while (!(selector > 0 && selector <= j)) {
            selector = scanner.nextInt();
        }

        if (player.getMyCollections().get(selector).getCouttHouse() > 0) {
            while (player.getMyCollections().get(selector).getCouttHouse() != 0) {
                if (player.getMoney() < 0) {
                    player.getMyCollections().get(selector).dellHouse();
                } else
                    break;
            }
        } else {
            if (!player.getMyCollections().get(selector).isFlagDep()) {
                player.getMyCollections().get(selector).trigFlagDep();
                player.setMoney(player.getMoney() + 100);
            }
        }
    }

    public void bayTerritoryOnDeposit() {//Выкуп из залога
        int j = 0;
        for (PartTypeSite p : player.getMyCollections()) {
            j++;
            System.out.println(j + " - " + p.getName());
        }

        System.out.println("Введите индекс территории");

        int selector = scanner.nextInt();
        while (!(selector > 0 && selector <= j)) {
            selector = scanner.nextInt();
        }

        if (player.getMyCollections().get(selector).isFlagDep()) {
            player.getMyCollections().get(selector).trigFlagDep();
        } else {
            System.out.println("Эта территория не закладывалась");
        }
    }

    public void trade() {
        int indexPlayer = -1, number = -1, money = 0, selector = -1, j = 0;
        for (Player p : players) {
            if (player.getName().equals(p.getName())) {
                j++;
            } else {
                int k = 0;
                System.out.println(j + " Игрок " + p.getName() + "\n Его коллекция : ");
                for (PartTypeSite pp : p.getMyCollections()) {
                    System.out.println("   -" + k + " Имя локации : " + pp.getName());
                    k++;
                }
                j++;
            }
        }

        j = 0;

        System.out.println("Введите индекс игрока с которым хотите провести обмен : ");
        indexPlayer = scanner.nextInt();

        for (PartTypeSite pp : players.get(indexPlayer).getMyCollections()) {
            System.out.println("   -" + j + " Имя локации : " + pp.getName());
            j++;
        }

        System.out.println("Введите номер желанной вами локации");
        number = scanner.nextInt();
        while (true) {
            System.out.println("Ваше предложение (в монетах) ?");
            money = scanner.nextInt();

            System.out.println("1 - предложить обмен \n 2 - отказаться");
            selector = scanner.nextInt();
            if (selector == 1) {
                System.out.println("Игрок " + players.get(indexPlayer).getName() + ", вы соглашаетесь на предложение? \n 1 - да \n любой иной символ - нет");
                selector = scanner.nextInt();
                if (selector == 1) {
                    player.setMoney(player.getMoney() - money);
                    players.get(indexPlayer).setMoney(players.get(indexPlayer).getMoney() + money);
                    player.addPlace(players.get(indexPlayer).getMyCollections().get(number));
                    players.get(indexPlayer).dellPlace(number);
                    break;
                } else {
                    break;
                }
            } else if (selector == 2) {
                break;
            } else {
                System.out.println("Такого варианта нет");
            }
        }
    }

    private boolean checkCourse() {//проверяет всели игроки сделали ход
        int count = 0;
        boolean flag = false;
        for (Player p : players) {
            if (!p.getFlagCourse()) {
                count++;
            }
        }
//отсюда переставил скобку
        if (count == players.size()) {
            flag = true;
            System.out.println("Все игроки сделали по ходу");
            System.out.println("Флаг из чек хода " + flag);
        }//переставил скобку сюда

        return flag;
    }

    public static int getCourse() {
        return course;
    }

    public static ArrayList<Player> getPlayers() {
        return players;
    }

    private void whoIsWin() {
        if (players.size() > 1) {
            if (player.getMoney() < 0) {
                Deposit();
                if (player.getMoney() < 0) {
                    if (player.getMyCollections().size() > 0) {
                        for (PartTypeSite p : player.getMyCollections()) {
                            if (p.isFlagDep()) {
                                p.trigFlagDep();
                            }
                            p.setFlagTrue();
                        }
                    } else {
                        return;
                    }
                }
                players.remove(players);// Может сделать ему флаг чтоб вывести по местам

                System.out.print("Вы проиграли");
            }
        } else if (players.size() == 1) {
            System.out.println(players.get(0).getName() + " - " + " Победил!!! ");
        }
    }

    private void course() {//переключает маркеры ходов у игроков
        if (checkCourse()) {
            course++;
            for (Player p : players) {
                p.trigCourse();
                System.out.println(p.getFlagCourse());
            }
        }
    }

    public void exit() {//конец хода
        player.trigCourse();
        player.trigDrop();
        if (checkCourse()) {
            course();
        }
        courses();
        whoIsWin();
    }

    public static void setFlagTeam() {//В душе не ебу зачем я ее юзал
        Controller.flagTeam = false;
    }

    public static boolean getFlagTeam() {//аналогично
        return flagTeam;
    }

    public void printInformation() {
        System.out.println(player.getName() + ". " + "Колличество монет в мешочке : " + player.getMoney() + " Находится на : " + maps.getTeamSite().get(player.getX()).getName());
        for (PartTypeSite p : player.getMyCollections()) {
            System.out.println(p.getType().getDescription() + " - " + p.getName());
        }
    }

    public void getMapPlay() {
        for (Parts p : maps.getTeamSite()) {
            for (Player pp : players) {
                if (maps.getTeamSite().get(pp.getX()).getName().equals(p.getName())) {
                    System.out.print("Игрок " + pp.getName() + " - ");
                }
            }
            System.out.println(p.getName());
        }
    }

    public String getInfo(){
        String log = "";
        log = log + maps.getTeamSite().get(player.getX()).getType().getDescription() + " - " + maps.getTeamSite().get(player.getX()).getName();
        System.out.println(log);
        if(maps.getTeamSite().get(player.getX()).getType().getDescription().equals("NON ")) {
            if ("Community Chest".equals(maps.getTeamSite().get(player.getX()).getName())) {
                log = log + " + 100 монет!";
                System.out.println(log);
            } else if ("Chance".equals(maps.getTeamSite().get(player.getX()).getName())) {
                log = log + " Вы взяли карту выполнили действие";
                System.out.println(log);
            } else if ("Pay Money".equals(maps.getTeamSite().get(player.getX()).getName())) {
                log = log + " - 150 монет!";
                System.out.println(log);
            }
        }

        return log;
    }

    public String win() {
        if (players.size() == 1) {
            return players.get(0).getName() + " - " + " Победил!!! ";
        } else
            return "";
    }

    public boolean flagPP(){
        if(players.size() <= 1)
            return false;
        else
            return true;
    }
}
