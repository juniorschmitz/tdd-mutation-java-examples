package tddexamples;

public class Registration {
    public Registration() {
    }

    public User registerNewUser(String name, Integer age, String password, String email) {
        // adicionar validações extras aqui
        User user = new User(name, age, password, email);
        return user;
    }
}
