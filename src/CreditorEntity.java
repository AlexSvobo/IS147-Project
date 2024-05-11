/**
 * Represents our internal creditor entity profile with a name.
 */
public abstract class CreditorEntity {
    /**
     * The name of the creditor entity.
     */
    protected String name;

    /**
     * Constructor for CreditorEntity.
     *
     * @param name The name of the creditor entity.
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
