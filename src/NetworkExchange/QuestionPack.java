package NetworkExchange;

import java.io.Serializable;

/**
 * Класс, хранящий запрос клиента
 * @author Дмитрий Толочек P3130
 * @version 1.0 Before Check
 */

public class QuestionPack implements Serializable {
    ClientCommands command;
    Argument arg;

    private static final long serialVersionUID = 0;

    /**
     * Конструктор для команды с аргументом
     * @param command - команда
     * @param arg - аргумент
     */
    public QuestionPack(ClientCommands command, Argument arg){
        this.command = command;
        this.arg = arg;
    }

    /**
     * Конструктор для команды без аргумента
     * @param command - команда
     */
    QuestionPack(ClientCommands command){
        this.command = command;
    }
}
