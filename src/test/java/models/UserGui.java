package models;

public class UserGui {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public static class Builder {
        private UserGui newUser;

        public Builder () {
            newUser = new UserGui();
        }

        public Builder withEmail (String  value) {
            newUser.email = value;

            return this;
        }

        public Builder withPassword (String  value) {
            newUser.password = value;

            return this;
        }

        public Builder withFirstName (String  value) {
            newUser.firstName = value;

            return this;
        }

        public Builder withLastName (String  value) {
            newUser.lastName = value;

            return this;
        }

        public UserGui build() {
            return newUser;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
