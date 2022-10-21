package Tp;

public class Area {

    private String name;

    public Area(String name) {
        this.name = name;
    }

    public Area() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Area{" +
                "Name='" + name + '\'' +
                '}';
    }
}
