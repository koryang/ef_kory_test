package properties;

public class userProperties {
    private static final PropertiesReader propertiesReader = new PropertiesReader();

    public static final String username = propertiesReader.getUsername();
    public static final String password = propertiesReader.getPassword();
}
