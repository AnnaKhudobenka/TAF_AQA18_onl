package models;

public class User {
    private String firstname;
    private String lastname;
    private String zipcode;

    public static class Builder {
        private User user;

        public Builder() {
            user = new User();
        }

        public Builder withFirstname (String value) {
            user.firstname = value;
            return this;
        }

        public Builder withLastname (String value) {
            user.lastname = value;
            return this;
        }

        public Builder withZipcode (String value) {
            user.zipcode = value;
            return this;
        }

        public User build() {
            return user;
        }

    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getZipcode() {
        return zipcode;
    }
}
