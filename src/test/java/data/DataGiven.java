package data;

public class DataGiven {
    private static final String USER_LOGIN = "vasya";
    private static final String USER_PASSWORD = "qwerty123";
    private static final String USER_VERIFICATION_CODE = "12345";
    public static final CharSequence sumTransfer = "300"; // задаем сумму перевода

    public DataGiven() {
    }

    public static String getUserLogin() {
        return USER_LOGIN;
    }

    public static String getUserPassword() {
        return USER_PASSWORD;
    }

    public static String getUserVerificationCode() {
        return USER_VERIFICATION_CODE;
    }

    public static CharSequence getSumTransfer() {return sumTransfer;}
}
