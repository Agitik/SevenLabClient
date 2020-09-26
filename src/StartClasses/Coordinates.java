package StartClasses;

import java.io.Serializable;

/**
 * Класс для хранения координат мероприятия: <b>x, y</b>.
 * @author Дмитрий Толочек P3130
 * @version 1.0 Before Check
 * @see Ticket
 */

public class Coordinates implements Serializable {
    private int x;  //Поле не может быть null
    private int y;  //Поле не может быть null

    public void setX(int x) {this.x = x;}
    public void setY(int y) {this.y = y;}

    public int getX() {return x;}
    public int getY() {return y;}

    /**
     * Строковое представление обекта
     * @return Строковое представление объекта
     */

    @Override
    public String toString(){return "X: " + this.x + "; Y: " + this.y;}

    private static final long serialVersionUID = 0;
}