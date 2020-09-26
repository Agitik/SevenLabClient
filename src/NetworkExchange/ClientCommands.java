package NetworkExchange;

import java.io.Serializable;

/**
 * Перечисление команд, доступных клиенту для отправки на сервер.
 * @author Дмитрий Толочек P3130
 * @version 1.0 Before Check
 */
public enum ClientCommands implements Serializable {
    HELP,
    INFO,
    SHOW,
    INSERT_NULL,
    UPDATE_ID,
    REMOVE_KEY,
    CLEAR,
    EXECUTE_SCRIPT,
    EXIT,
    REPLACE_IF_GREATER,
    REMOVE_GREATER_KEY,
    REMOVE_LOWER_KEY,
    COUNT_LESS_THAN_TYPE,
    PRINT_FIELD_ASCENDING_PERSON,
    PRINT_FIELD_DESCENDING_TYPE,
    LOGIN,
    REGISTRATION;

    /**
     * Возвращает ClientCommands объект из строкового его представления
     * @param c команда в виде строки
     * @return команду для упаковки.
     */
    public static ClientCommands getCommandFE(String c){
        switch (c.trim().toUpperCase()){
            case "HELP":
                return HELP;
            case "INFO":
                return INFO;
            case "SHOW":
                return SHOW;
            case "INSERT_NULL":
                return INSERT_NULL;
            case "UPDATE_ID":
                return UPDATE_ID;
            case "REMOVE_KEY":
                return REMOVE_KEY;
            case "CLEAR":
                return CLEAR;
            case "EXECUTE_SCRIPT":
                return EXECUTE_SCRIPT;
            case "EXIT":
                return EXIT;
            case "REPLACE_IF_GREATER":
                return REPLACE_IF_GREATER;
            case "REMOVE_GREATER_KEY":
                return REMOVE_GREATER_KEY;
            case "REMOVE_LOWER_KEY":
                return REMOVE_LOWER_KEY;
            case "COUNT_LESS_THAN_TYPE":
                return COUNT_LESS_THAN_TYPE;
            case "PRINT_FIELD_ASCENDING_PERSON":
                return PRINT_FIELD_ASCENDING_PERSON;
            case "PRINT_FIELD_DESCENDING_TYPE":
                return PRINT_FIELD_DESCENDING_TYPE;
            default:
                return null;
        }
    }

    private static final long serialVersionUID = 0;

    /**
     * Выводит на консоль клиента список всех доступных команд.
     */
    public static void showHelp(){
        Info.ProgramInfo.showMessage("Help");
    }
}
