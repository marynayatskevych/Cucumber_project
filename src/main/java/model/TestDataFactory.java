package model;

public class TestDataFactory {
    public static User getValidClientUser() {
        return User.builder()
                .firstName("Jonh")
                .lastName("Doe")
                .email("validemail@gmail.com")
                .password("StrongPassword123!")
                .phoneNumber("1234567890")
                .address("123 Mia Street")
                .city("Kharkiv")
                .build();
    }

    public static User getInvalidUser() {
        return User.builder()
                .firstName("Invalid")
                .lastName("User")
                .email("invalid-email")
                .password("weak")
                .phoneNumber("123")
                .address("No Address")
                .city("Nowhere")
                .build();
    }

    public static User getEmptyUser() {
        return User.builder().build();
    }
}
