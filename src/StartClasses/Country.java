package StartClasses;

import java.io.Serializable;

/**
 * Перечисление стран, граждане которых могут купить билет.
 * @author Дмитрий Толочек P3130
 * @version 1.0 Before Check
 * @see Person
 */

public enum Country implements Serializable {
    USA,
    GERMANY,
    SOUTH_KOREA;

    /**
     * Получение страны из строкового представления
     * @param c - строковое представление строки
     * @return "country" объект
     */
    public static Country getType(String c){
        switch (c.toUpperCase().trim()){
            case "USA" :
                return USA;
            case "GERMANY":
                return GERMANY;
            case "SOUTH_KOREA":
                return SOUTH_KOREA;
            default:
                return null;
        }
    }
    private static final long serialVersionUID = 0;
}