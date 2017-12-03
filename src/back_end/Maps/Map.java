package back_end.Maps;

import java.util.ArrayList;

public class Map {

    private static int maxHouse = 32;


    private ArrayList<Parts> teamSite = new ArrayList<Parts>();

    public void addSite() {
        //0
        teamSite.add(new BigPlaces("GO", BigPlaces.oneOf.ONE, Colour.BIG));

        teamSite.add(new PartTypeSite("Mediter-Ranean Avenue", 60, 2, Colour.BROWN));
        teamSite.add(new Chest("Community Chest", Colour.NON));
        teamSite.add(new PartTypeSite("Baltic Avenu", 60, 4, Colour.BROWN));
        teamSite.add(new PartTypeSite("Pay Money", 200, 16, Colour.NON));
            teamSite.add(new PartTypeSite("Reading Railroad", 200, 16, Colour.Railroad));
        teamSite.add(new PartTypeSite("Oriental Avenue", 100, 6, Colour.AZURE));
        teamSite.add(new Chest("Chance", Colour.NON));
        teamSite.add(new PartTypeSite("Vermont Avenue", 100, 6, Colour.AZURE));
        teamSite.add(new PartTypeSite("Connecticut Avenue", 120, 8 , Colour.AZURE));
        //1
        teamSite.add(new BigPlaces("JAIL", BigPlaces.oneOf.TWO, Colour.BIG));

        teamSite.add(new PartTypeSite("St.Charles Place", 140, 10, Colour.PINK));
        teamSite.add(new PartTypeSite("Electric Company", 150, 11, Colour.SERVICES));
        teamSite.add(new PartTypeSite("States Avenue", 140, 10, Colour.PINK));
        teamSite.add(new PartTypeSite("Virginia Avenue", 160, 10, Colour.PINK));
            teamSite.add(new PartTypeSite("Pennsylvania Railroad", 200, 16, Colour.Railroad));
        teamSite.add(new PartTypeSite("St.James Place", 140, 10, Colour.ORANGE));
        teamSite.add(new Chest("Community Chest", Colour.NON));
        teamSite.add(new PartTypeSite("Tennessee Avenue", 140, 10, Colour.ORANGE));
        teamSite.add(new PartTypeSite("New York Avenue", 160, 12, Colour.ORANGE));
        //2
        teamSite.add(new BigPlaces("Free Parking", BigPlaces.oneOf.THREE, Colour.BIG));

        teamSite.add(new PartTypeSite("Kentucky Avenue", 220, 18, Colour.RED));
        teamSite.add(new Chest("Chance", Colour.NON));
        teamSite.add(new PartTypeSite("Indiana Avenue", 220, 18, Colour.RED));
        teamSite.add(new PartTypeSite("Illinois Avenue", 240, 20, Colour.RED));
            teamSite.add(new PartTypeSite("B&O Railroad", 200, 16, Colour.Railroad));
        teamSite.add(new PartTypeSite("Atlantic Avenue", 260, 22, Colour.YELLOW));
        teamSite.add(new PartTypeSite("Ventnor Avenue", 260, 22, Colour.YELLOW));
        teamSite.add(new PartTypeSite("Water Works", 150, 11, Colour.SERVICES));
        teamSite.add(new PartTypeSite("Marvin Gardens", 280, 24, Colour.YELLOW));
        //3
        teamSite.add(new BigPlaces("Go to jail", BigPlaces.oneOf.FOUR, Colour.BIG));

        teamSite.add(new PartTypeSite("Pacific Avenue", 300, 26, Colour.GREEN));
        teamSite.add(new PartTypeSite("North Carolina Avenue", 300, 26, Colour.GREEN));
        teamSite.add(new Chest("Community Chest", Colour.NON));
        teamSite.add(new PartTypeSite("Pennsylvania Avenue", 320, 28, Colour.GREEN));
            teamSite.add(new PartTypeSite("Short Line", 150, 11, Colour.Railroad));
        teamSite.add(new Chest("Chance", Colour.NON));
        teamSite.add(new PartTypeSite("Parc Place", 350, 35, Colour.BLUE));
        teamSite.add(new Chest("Pay Money", Colour.NON));
        teamSite.add(new PartTypeSite("Boardwalk", 400, 40, Colour.BLUE));
    }

    public static void setMaxHouse() {
        Map.maxHouse--;
    }

    public static int getMaxHouse() {
        return maxHouse;
    }

    public ArrayList<Parts> getTeamSite() {
        return teamSite;
    }


}
