public abstract class Item {
    protected String name;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Method abstract untuk digunakan oleh subclass
    public abstract void use(Character target);
}