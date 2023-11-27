package tddexamples;

public class RegistrationForMocking {
    private EmailService emailService;
    private DBService dbService;

    public RegistrationForMocking(EmailService emailService) {
        this.emailService = emailService;
    }

    public RegistrationForMocking(EmailService emailService, DBService dbService) {
        this.emailService = emailService;
        this.dbService = dbService;
    }

    public User registerNewUser(String name, Integer age, String password, String email) {
        // adicionar validações extras aqui
        User user = new User(name, age, password, email);
        emailService.sendConfirmationEmail(email);
        return user;
    }

    public User registerNewUserWithValidation(String name, Integer age, String password, String email) {
        // adicionar validações extras aqui
        dbService.validateEmail(email);
        User user = new User(name, age, password, email);
        emailService.sendConfirmationEmail(email);
        return user;
    }
}
