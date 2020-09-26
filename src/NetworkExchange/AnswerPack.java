package NetworkExchange;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Класс для хранения пакета ответов, полученных от cервера
 * @author Дмитрий Толочек P3130
 * @version 1.0 Before Check
 */

public class AnswerPack implements Serializable {
    private static final long serialVersionUID = 0;
    ArrayList<String> answer = new ArrayList<String>();
    public boolean status = false;
}