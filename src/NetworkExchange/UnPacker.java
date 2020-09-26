package NetworkExchange;

import java.util.ArrayList;

/**
 * Класс предназначенный для распаковки ответа от сервера
 * @author Дмитрий Толочек P3130
 * @version 1.0 Before Check
 */

public class UnPacker {

    /**
     * Метод для печати ответа от сервера
     * @param l - пак ответов
     */
    static void UnPackAnswerFromServer(ArrayList<String> l){
        for (String s : l){
            System.out.println(s);
        }
    }
}
