package back_end.Maps;

import back_end.Play.Player;

public class PartTypeSite extends  Parts{
    private Colour color;
    private int price;
    private byte couttHouse = 0;
    private int rent;
    private Player p;
    private boolean flag = true;
    private boolean flagDep = false;

     public PartTypeSite ( String name, int price, int rent, Colour color){
         this.name = name;
         super.setName(name);
         this.price = price;
         this.rent = rent;
         this.color = color;
         super.setType(color);
     }

     public void setCouttHouse(){
         if(Map.getMaxHouse() > 0) {
             if (color.getDescription().equals("Вокзал")) {
                 System.out.println("Такое действие для данного класса не предусмотренно");
             } else if (color.getDescription().equals("Сервис")) {
                 System.out.println("Такое действие для данного класса не предусмотренно");
             } else {
                 if (getCouttHouse() <= 4) {
                     couttHouse++;
                     Map.setMaxHouse();
                     rent = +100;
                 } else {
                     System.out.println("Максимум домов уже достигнут");
                 }
             }
         } else {
             System.out.println("Лимит построек исчерпан");
         }
     }

    public void dellHouse(){
         couttHouse--;
         rent = -100;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public byte getCouttHouse() {
        return couttHouse;
    }

    public int getPrice() {
        return price;
    }

    public int getRent() {
        return rent;
    }

    public boolean getFlag() {
        return flag;
    }

    public Player getP() {
        return p;
    }

    public void setFlag(){
         flag = false;
    }

    public void trigFlagDep(){
        if(!flagDep){
            flagDep = true;
        } else
            flagDep = false;
    }


    public boolean isFlagDep() {
        return flagDep;
    }

    public void setFlagTrue(){
        flag = true;
    }

    public void setP(Player p) {
        this.p = p;
    }
}
