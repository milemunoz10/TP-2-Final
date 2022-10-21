package Tp;

public class Boss {

    private String name;

    public Boss(String name) {
        this.name = name;
    }

    public Boss() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "Name='" + name + '\'' +
                '}';
    }
}
