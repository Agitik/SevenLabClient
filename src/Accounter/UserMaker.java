package Accounter;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 * Класс, содержащий методы для создания аккаунта.
 * @author Дмитрий Толочек P3130
 * @version 2.0 After 5 lab check.
 */
public class UserMaker {
    public static String encodePassword(String password){
        String end_version = "user";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-224");
            md.update(password.getBytes(StandardCharsets.UTF_8));
            byte[] hash = md.digest();
            end_version = String.format("%064x", new BigInteger(1, hash));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Произошла ошибка кодирования!");
        }
        return end_version;
    }

    public static User makeUser(){
        User user = new User();
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите логин: ");
        String login = sc.nextLine().trim();
        System.out.print("Введите пароль: ");
        String password = sc.nextLine().trim();
        if(login.equals("") | password.equals("")){
            System.out.println("Вы ничего не ввели, попробуйте еще раз!");
            makeUser();
        } else {
            user.login = login;
            user.password = UserMaker.encodePassword(password);
        }
        return user;
    }
}
