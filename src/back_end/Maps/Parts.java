package back_end.Maps;

abstract public class Parts {
    protected  String name;
    private Colour type;

    public void setName(String name) {
        this.name = name;
    }

    public void setType(Colour type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Colour getType() {
        return type;
    }
}
