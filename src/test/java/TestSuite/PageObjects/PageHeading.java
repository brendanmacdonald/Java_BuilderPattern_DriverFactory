package TestSuite.PageObjects;

public enum PageHeading {

    HOME_PAGE("Available Examples"),
    LOGIN_PAGE("Login Page"),
    SECURE_AREA_PAGE("Secure Area");

    private final String heading;

    PageHeading(String heading) {
        this.heading = heading;
    }

    public String getHeading() {
        return heading;
    }


}
