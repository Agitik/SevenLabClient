package NetworkExchange;

import Accounter.User;
import Accounter.UserMaker;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Класс для запуска клиента
 * @author Dima Tolochek
 * @version 1.0 Before Check
 */

public class ClientMain {
    public static Boolean exitCode = false;

    public static User main_user = new User();

    //Для дебага
    public static int port = 7150;
    public static String addr = "localhost";

    /**
     * Главный метод клиента
     * @param args - адрес, порт
     */
    public static void main(String[] args) {
        try{
            addr = args[0];
            port = Integer.parseInt(args[1]);
        } catch (NumberFormatException e ){
            System.out.println("Введен некорректный порт!");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Параметры не обнаружены, за основу взяты базовые! (localhost, 9000)");
        }
        Info.ProgramInfo.showMessage("AfterOn");
        boolean isAccountReal = Info.ProgramInfo.isSmthExistWithoutNull();
        if(isAccountReal){
            acclog();
        }else{
            reg();
        }
        while (!exitCode){
            try {
                Scanner MainIn = new Scanner(System.in);
                String ve = MainIn.nextLine();
                QuestionPack send = Packer.CommandPicker(ve);
                if(send == null & !exitCode){
                    System.out.println("Произошла ошибка чтения команды, либо такой команды не существует!");
                } else if(send.command == ClientCommands.HELP){
                    continue;
                } else if (send.command == ClientCommands.EXIT) {
                    Client.sendToServerAndGetAnswer(send, addr, port);
                    exitCode = true;
                } else {
                    Client.sendToServerAndGetAnswer(send, addr, port);
                }
            } catch (NoSuchElementException e){
                System.out.println("Работа программы завершена принудительно!");
                exitCode = true;
            }
        }
    }

    public static void reg(){
        Info.ProgramInfo.showMessage("RegistrationInfo");
        main_user = UserMaker.makeUser();
        AnswerPack ans = Client.sendToServerAndGetAnswer(Registration.registration_request(main_user), addr, port);
        if(Registration.status_check(ans)){
            System.out.println("Регистрация прошла успешно");
        }else{
            System.out.println("Произошла проблема. Скорее всего такой логин уже существует.");
            reg();
        }
    }

    public static void acclog(){
        Info.ProgramInfo.showMessage("LoginInfo");
        Scanner regsc = new Scanner(System.in);
        main_user = UserMaker.makeUser();
        AnswerPack ans = Client.sendToServerAndGetAnswer(Login.login_request(main_user), addr, port);
            if(Login.status_check(ans)){
                System.out.println("Вы вошли в учетную запись");
            } else {
                System.out.println("Вы ввели неправильный логин или пароль, попробуйте еще раз");
                acclog();
            }
    }
}
