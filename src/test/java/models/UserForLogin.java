package models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserForLogin {
    private String username;
    private String password;
}
