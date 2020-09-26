package Accounter;

import java.io.Serializable;

/**
 * Класс для хранения аккаунтов в приложении
 * @author Дмитрий Толочек P3130
 * @version 1.0 After 5 lab check.
 */
public class User implements Serializable {
    private static final long serialVersionUID = 0;
    public String login;
    public String password;

    public User(String login, String password){
        this.login = login;
        this.password = password;
    }

    public User(){}
}
