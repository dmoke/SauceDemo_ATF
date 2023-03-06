package elements;

public enum LoginPageElements {
    USERNAME_INPUT_FIELD("//input[@data-test='username']"),
    PASSWORD_INPUT_FIELD("//input[@data-test='password']"),
    SUBMIT_BUTTON("//input[@data-test='login-button']");

    public final String xpath;

    LoginPageElements(String xpath) {
        this.xpath = xpath;
    }

}
