package seedu.bigpp.builder;

public class CurrentBuilder {

    public static Builder currentBuilder;

    public static void setBuilder(Builder builder) {
        currentBuilder = builder;
    }

    public static Builder getBuilder() {
        return currentBuilder;
    }
}
