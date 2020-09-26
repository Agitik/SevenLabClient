package StartClasses;

import java.io.Serializable;

/**
 * Класс для описания покупателя билета.
 * @author Дмитрий Толочек P3130
 * @version 2.0 After 5 lab check.
 */

public class Person implements Comparable<Person>, Serializable {
    private static final long serialVersionUID = 0;
    private Double weight; //Поле может быть null, Значение поля должно быть больше 0
    private Color eyeColor; //Поле не может быть null
    private Color hairColor; //Поле может быть null
    private Country nationality; //Поле может быть null
    private Location location; //Поле может быть null

    public Double getWeight() {return weight;}
    public void setWeight(Double weight) {this.weight = weight;}

    public Color getEyeColor() {return eyeColor;}
    public void setEyeColor(Color eyeColor) {this.eyeColor = eyeColor;}

    public Color getHairColor() {return hairColor;}
    public void setHairColor(Color hairColor) {this.hairColor = hairColor;}

    public Country getNationality() {return nationality;}
    public void setNationality(Country nationality) {this.nationality = nationality;}

    public Location getLocation() {return location;}
    public void setLocation(Location location) {this.location = location;}

    /**
     * Метод для показа информации о человеке
     */
    public String showInfo(){
        String ret = "";
        if(this.weight == null){
            ret += "Weight: " + "null" + "\n";
        } else {
            ret += "Weight: " + this.weight + "\n";
        }
        ret += "EyeColor: " + this.eyeColor + "\n";
        if(this.hairColor == null){
            ret += "HairColor: " + "null" + "\n";
        } else {
            ret += "HairColor: " + this.hairColor + "\n";
        }
        if(this.nationality == null){
            ret += "Nationality: " + "null" + "\n";
        } else {
            ret += "Nationality: " + this.nationality + "\n";
        }
        if(this.location == null){
            ret += "Location - " + "null";
        } else {
            ret += "Location - " + this.location;
        }
        return ret;
    }

    @Override
    public int compareTo(Person a) {
        double A, B;
        if (this.weight == null){A = 0.0;} else {A = this.weight;}
        if (a.weight == null){B = 0.0;} else {B = a.weight;}
        return Double.compare(A, B);
    }
}
