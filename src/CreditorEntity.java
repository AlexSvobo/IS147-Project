/**
 * Represents a creditor entity with a name.
 */
public abstract class CreditorEntity {
    protected String name;

    /**
     * Default constructor for CreditorEntity.
     */
    public CreditorEntity(String name) {
        this.name = name;
    }

    /**
     * Get the name of the creditor.
     *
     * @return The name of the creditor.
     */
    public String getName() {
        return name;
    }
}
