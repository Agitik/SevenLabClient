package StartClasses;

import java.io.Serializable;

/**
 * Перечисление видов билетов.
 * @author Дмитрий Толочек P3130
 * @version 1.0 Before Check
 * @see Person
 */

public enum TicketType implements Serializable {
    VIP,
    USUAL,
    BUDGETARY,
    CHEAP;

    /**
     * Получение типа билета из строки
     * @param t - строковое представление билета
     * @return объект "TicketType"
     */
    public static TicketType getType(String t){
        switch (t.toUpperCase().trim()){
            case "VIP" :
                return VIP;
            case "USUAL":
                return USUAL;
            case "BUDGETARY":
                return BUDGETARY;
            case "CHEAP":
                return CHEAP;
            default:
                return null;
        }
    }
    private static final long serialVersionUID = 0;
}