package back_end;

public enum Chance {
   ONE(1, "Сделать пожертвование", -150, 0, "NON", "NON", "-"), TWO (2, "На ближайший вокзал", 0, 0, "NON", "NON", "Вокзал"),
   THREE(3,"Вас выбрали присяжным", 0, -3, "NON", "NON", "-" ),FOUR(4, "Вы под судом, заплатите 500 баксов", -300, 0, "name", "NON", "-"),
   FIVE(5, "Сгоняйте на St.James Place", 0, 0, "NON", "St.James Place", "-"),SIX(6, "Отправляйтесь в тюрьму", 0, 0, "NON", "JAIL", "-"),
   SAAVEN(7, "Налоговые льготы", 400, 0, "NON", "NON", "-");

   private  int number;
   private String description;
   private int money;
   private int mov;
   private String name;
   private String namePlace;
   private String type;

   Chance(int number, String description, int money, int mov, String name, String namePlace, String type){

    this.number = number;
    this.description = description;
    this.money = money;
    this.mov = mov;
    this.name = name;
    this.namePlace = namePlace;
    this.type = type;
   }

 public String getName() {
  return name;
 }

 public int getMoney() {
  return money;
 }

 public String getDescription() {
  return description;
 }

 public int getMov() {
  return mov;
 }

 public int getNumber() {
  return number;
 }

 public String getType() {
  return type;
 }

 public String getNamePlace() {
  return namePlace;
 }
}
