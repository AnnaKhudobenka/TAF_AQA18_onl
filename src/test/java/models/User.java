package models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {
    private String firstname;
    private String lastname;
    private String zipcode;
}
