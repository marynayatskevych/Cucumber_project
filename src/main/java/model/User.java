package model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    private String address;
    private String city;
}
