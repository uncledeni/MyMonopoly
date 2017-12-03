package back_end.Maps;

public class Chest extends Parts {
    private Colour type;

    Chest(String name, Colour type){
        this.name = name;
        super.setName(name);
        this.type = type;
        super.setType(type);
    }

    public Colour getType() {
        return type;
    }
}
