package data;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
@Data
@Value
//@AllArgsConstructor
//@NoArgsConstructor
public class DataGiven {
    private static final String USER_LOGIN = "vasya";
    private static final String USER_PASSWORD = "qwerty123";
    private static final String USER_VERIFICATION_CODE = "12345";

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
}
