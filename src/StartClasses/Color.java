package StartClasses;

import java.io.Serializable;

/**
 * Перечесление цветов.
 * @author Дмитрий Толочек P3130
 * @version 1.0 Before Check
 * @see Person
 */

public enum Color implements Serializable {
    RED,
    BLACK,
    BLUE,
    YELLOW,
    WHITE,
    GREEN;

    /**
     * Метод для получения цвета из строки.
     * @param c - строковое представление строки в любом регистре
     * @return цвет
     */
    public static Color getType(String c){
        switch (c.toUpperCase().trim()){
            case "RED" :
                return RED;
            case "BLACK":
                return BLACK;
            case "BLUE":
                return BLUE;
            case "YELLOW":
                return YELLOW;
            case "WHITE":
                return WHITE;
            case "GREEN":
                return GREEN;
            default:
                return null;
        }
    }
    private static final long serialVersionUID = 0;
}