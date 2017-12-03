package back_end.Maps;

public enum Colour {
    BROWN("Коричневый", 2), AZURE("Голубой", 3), PINK("Розовый", 3), ORANGE("Оранжевый", 3), RED("Красный", 3), YELLOW("Желтый", 3),
    GREEN("Зеленый", 3), BLUE("Синий", 2), Railroad("Вокзал", 4), SERVICES("Сервис", 3), NON("NON", 0), BIG("BIG", 0);

    private String description;
    private int countThisColour;

    Colour(String description, int countThisColour){
        this.description = description;
        this.countThisColour = countThisColour;
    }

    public String getDescription() {
        return description;
    }

    public int getCountThisColour() {
        return countThisColour;
    }
}
