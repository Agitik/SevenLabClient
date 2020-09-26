package StartClasses;

import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;

/**
 * Класс для описания билета.
 * @author Дмитрий Толочек P3130
 * @version 2.0 After 5 lab check.
 * @see Person
 */

public class Ticket implements Comparable<Ticket>, Serializable {

    private static final long serialVersionUID = 0;

    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private float price; //Поле не может быть null, Значение поля должно быть больше 0
    private Boolean refundable; //Поле может быть null
    private TicketType type; //Поле не может быть null
    private Person person; //Поле может быть null

    public Ticket(){}

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public Coordinates getCoordinates() {return coordinates;}
    public void setCoordinates(Coordinates coordinates) {this.coordinates = coordinates;}

    public LocalDate getCreationDate() {return creationDate;}

    /**
     * Метод, получающий дату в строковом представлении и генирирующий creationDate.
     * Формат введенной строки : XXXX.XX.XX - YEAR.MOUNTH.DAY.
     * Разделитель может быть любой.
     * @param sdate - Дата в строковом представлении
     * @param sep - разделитель даты. (На случай, если такой формат 2020/12/20).
     */
    public void setStringCreationDate(String sdate, String sep){
        //Date format: "XXXXsepXXsepXX" - YEARsepMOUNTHsepDAY
        LocalDate ret;
        String[] time = sdate.trim().split(sep);
        try {
            ret = LocalDate.of(Integer.parseInt(time[0].trim()),
                               Integer.parseInt(time[1].trim()),
                               Integer.parseInt(time[2].trim()));
        } catch (DateTimeException e){
            System.out.println("Ticket -> setStringCreationDate()");
            System.out.println("Некорректный формат даты. Выбрана сегодняшняя по дефолту.");
            ret = LocalDate.now();
        }
        this.creationDate = ret;
    }
    /**
     * Метод, генерирующий creationDate и задающий дату создания.
     */
    public void setDefaultCreationDate(){this.creationDate = LocalDate.now();}
    public void setCreationDate(LocalDate creationDate) {this.creationDate = creationDate;}

    public float getPrice() {return price;}
    public void setPrice(float price) {this.price = price;}

    public Boolean getRefundable() {return refundable;}
    public void setRefundable(Boolean refundable) {this.refundable = refundable;}

    public void setType(TicketType type) {this.type = type;}
    public TicketType getType() {return type;}

    public Person getPerson() {return person;}
    public void setPerson(Person person) {this.person = person;}

    /**
     * Конструктор для текстового представления билета
     */
    public String showInfo(){
        String ret = "\n***TICKET INFO***\n" + ("ID: " + this.id + "\n") +
                "Name: " + this.name + "\n" + "Coordinates - " + this.coordinates + "\n" +
                "Creation Date: " + this.creationDate + "\n" + "Price: " + this.price +
                "\n" + "Refundable: " + this.refundable + "\n" + "Type: " + this.type + "\n" +
                "***OWNER INFO***\n";
        if(this.person == null){
            ret += "Person: NO OWNER";
        } else {
            ret += this.person.showInfo();
        }
        return ret;
    }

    /**
     * Сравнение объектов по формуле: PRICE * creationYEAR
     */
    @Override
    public int compareTo(Ticket o) {
        int a = (int) this.price * this.creationDate.getDayOfYear();
        int b = (int) o.price * o.creationDate.getDayOfYear();
        return Integer.compare(a, b);
    }
}
