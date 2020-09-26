package StartClasses;

import java.io.Serializable;

/**
 * Класс для хранения фактического адреса проживания человека по его:
 * Координатам: <b>x, y</b>
 * И названию пункта проживания: <b>name</b>
 * @author Дмитрий Толочек P3130
 * @version 1.0 Before Check
 * @see Person
 */
public class Location implements Serializable {

    private Long x; //Поле не может быть null
    private float y; //Поле не может быть null
    private String name; //Поле не может быть null

    public void setName(String name) {this.name = name;}
    public String getName() {return name;}

    public void setX(Long x) {this.x = x;}
    public Long getX() {return x;}

    public void setY(float y) {this.y = y;}
    public float getY() {return y;}

    /**
     * Строковое представление объекта
     */
    @Override
    public String toString(){return "Name: " + this.name + ". X: " + this.x + "; Y: " + this.y;}

    private static final long serialVersionUID = 0;
}