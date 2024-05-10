public abstract class CreditorEntity {
    protected String name;

    public CreditorEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void displayInfo();
}
