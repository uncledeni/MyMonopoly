package back_end.Maps;

public class BigPlaces extends Parts {
    enum oneOf{
        ONE("GO", 1), TWO("Jail", 2), THREE("Free Parking", 3), FOUR("Go to jail", 4);

        private String description;
        private int numberPlace;

        oneOf(String description, int numberPlace){
            this.description = description;
            this.numberPlace = numberPlace;
        }

        public String getDescription() {
            return description;
        }

        public int getNumberPlace() {
            return numberPlace;
        }
    }

    private oneOf type1;
    private Colour type;

    public BigPlaces(String name, oneOf type1, Colour type){
        this.name = name;
        super.setName(name);
        this.type = type;
        super.setType(type);
        this.type1 = type1;
    }

    public oneOf getType1() {
        return type1;
    }
}
