package models;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ProjectForLogin {
    private String username;
    private String password;


}
