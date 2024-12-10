package utils;

public class SharedData {
    private static SharedData instance;

    private String token; // Example: Store token or other shared data
    private String userId;
    private static String bearerToken;
    private static String email;
    private static String password;
    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        SharedData.email = email;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        SharedData.password = password;
    }


    private SharedData() {}

    public static SharedData getInstance() {
        if (instance == null) {
            instance = new SharedData();
        }
        return instance;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public static String getBearerToken() {
        return bearerToken;
    }

    public static void setBearerToken(String token) {
        bearerToken = token;
    }
}
