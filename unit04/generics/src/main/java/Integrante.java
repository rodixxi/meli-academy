public class Integrante implements Comparable<Integrante>{

    private String firstName;
    private String lastName;
    private String email;

    public enum Criteria {
        FULL,
        FIRST_NAME,
        LAST_NAME,
        EMAIL
    }

    public static Criteria criteria = Criteria.FULL;

    public Integrante(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int compareTo(Integrante o){
        switch (criteria) {
            case FULL: return this.toString().compareTo(o.toString());
            case FIRST_NAME: return this.firstName.compareTo(o.getFirstName());
            case LAST_NAME: return this.lastName.compareTo(o.getLastName());
            case EMAIL: return this.email.compareTo(o.getEmail());
        }
        return 0;

    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(this.lastName)
                .append(" ")
                .append(this.firstName)
                .append(" ")
                .append(this.email)
                .toString();
    }
}
