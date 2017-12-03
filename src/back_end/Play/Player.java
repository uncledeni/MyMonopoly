package back_end.Play;

import back_end.Maps.PartTypeSite;

import java.util.ArrayList;

public class Player {
    private int x = 0;
    private int money = 3000;
    private boolean flagCourse = false;
    private boolean flagDrop = true;
    private boolean flagJail = false;
    private int jailCourse = 0;

    private ArrayList<PartTypeSite> myCollections = new ArrayList();

    private String name;
    public Player(String name){
        this.name = name;
        System.out.println("Игрок " + name + " Добавлен.");
        flagCourse = true;
    }

    public void addPlace(PartTypeSite part){
        myCollections.add(part);
    }

    public void dellPlace(int index){
        myCollections.remove(index);
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public ArrayList<PartTypeSite> getMyCollections() {
        return myCollections;
    }

    public void setFlagJail(boolean flagJail) {
        this.flagJail = flagJail;
    }

    public boolean getFlagJail() {
        return flagJail;
    }

    public void setJailCourse(int jailCourse) {
        this.jailCourse = jailCourse;
    }

    public int getJailCourse() {
        return jailCourse;
    }

    public void trigCourse() {
        if(flagCourse)
            this.flagCourse = false;
        else
            this.flagCourse = true;
    }

    public void trigDrop(){
        if(flagDrop)
            this.flagDrop = false;
        else
            this.flagDrop = true;
    }

    public boolean getFlagCourse() {
        return flagCourse;
    }

    public boolean getFlagDrop() {
        return flagDrop;
    }

    public String getMyColection(){
        int i = 0;
        String inf = "";
        for(PartTypeSite p : myCollections){
            inf = inf + i + " Colour " + p.getType() + " Name :" + p.getName() + ". Колво домов : " + p.getCouttHouse() + "\n\r ";
            i++;
        }

        return inf;
    }

    public void printMyCollection()
    {
        int i = 0;
        for(PartTypeSite p : myCollections){
            System.out.println(i + p.getName());
            i++;
        }
    }
}

