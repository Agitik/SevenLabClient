package StartClasses.makers;

import StartClasses.*;

import java.util.Scanner;

/**
 * Класс, реализующий ввод данных билета пользователем с дальнейшей валидацией.
 * @author Дмитрий Толочек P3130
 * @version 2.0 After 5 lab check.
 * @see Ticket
 */
public class ConsoleTicketMaker {

    static Scanner in = new Scanner(System.in);

    /**
     * Метод, реализующий ввод имени с консоли с последующей валидацией данных.
     * @param t - Изменяемый билет.
     */
    public static void setNameFromConsole(Ticket t){
        String result;
        System.out.print("Введите название билета: ");
        try {
            result = in.nextLine().trim();
            if (result.equals("")){throw new UnrealValueException("\nДанное поле не может быть пустым!\n");}
            t.setName(result);
        } catch (UnrealValueException e) {
            System.out.println(e.getMessage());
            setNameFromConsole(t);
        }
    }

    /**
     * Метод, реализующий ввод координат с консоли.
     * @param t - Изменяемый билет.
     */
    public static void setCoordinatesFromConsole(Ticket t){
        Coordinates cor = new Coordinates();
        try {
            System.out.print("Введите X координату места проведения мероприятия: ");
            cor.setX(Integer.parseInt(in.nextLine().trim()));
            System.out.print("Введите Y координату места проведения мероприятия: ");
            cor.setY(Integer.parseInt(in.nextLine().trim()));
            t.setCoordinates(cor);
        } catch (NumberFormatException e){
            System.out.println("\nПрограмма не смогла распознать ваше число, попробуйте еще раз!");
            System.out.println("Введите X и Y координаты заново!\n");
            setCoordinatesFromConsole(t);
        }
    }

    /**
     * Метод, реализующий ввод цены с консоли.
     * @param t - Изменяемый билет.
     */
    public static void setPriceFromConsole(Ticket t){
        float price;
        try {
            System.out.print("Введите цену билета (Больше нуля): ");
            price = Float.parseFloat(in.nextLine().trim());
            t.setPrice(price);
            if (price < 0){throw new UnrealValueException("\nЗначение должно быть больше нуля!");}
        } catch (NumberFormatException e){
            System.out.println("\nВведено некорректное число, попробуйте еще раз!\n");
            setPriceFromConsole(t);
        } catch (UnrealValueException e){
            System.out.println(e.getMessage() + " Попробуйте еще раз!\n");
            setPriceFromConsole(t);
        }
    }

    /**
     * Метод, разрешающий забрать билет.
     * @param t - Изменяемый билет.
     */
    public static void setRefundableFromConsole(Ticket t){
        System.out.print("Возможно ли вернуть билет? (y/n): ");
        String ref = in.nextLine().trim();
        t.setRefundable(ref.equals("") ? null : Boolean.parseBoolean(ref));
    }

    /**
     * Метод, реализующий ввод типа билета с консоли.
     * @param t - Изменяемый билет.
     */
    public static void setTypeFromConsole(Ticket t){
        try {
            System.out.print("Выберите тип билета (VIP, USUAL, BUDGETARY, CHEAP): ");
            TicketType tt = TicketType.getType(in.nextLine());
            if(tt == null){throw new UnrealValueException("\nВведено некорректное значение!\n");}
            t.setType(tt);
        } catch (UnrealValueException e){
            System.out.println(e.getMessage() + "Попробуйте еще раз!\n");
            setTypeFromConsole(t);
        }
    }

    /**
     * Метод, реализующий ввод места рождения с консоли.
     * @param t - Изменяемый билет..
     */
    public static void setPersonFromConsole(Ticket t){
        System.out.print("Вы хотите ввести данные о владельце билета? (true/false): ");
        if(Boolean.parseBoolean(in.nextLine())){
            Person np = new Person();
            ConsolePersonMaker.setWeightFromConsole(np);
            ConsolePersonMaker.setEyeColorFromConsole(np);
            ConsolePersonMaker.setHairColorFromConsole(np);
            ConsolePersonMaker.setNationalityFromConsole(np);
            ConsolePersonMaker.setLocationFromConsole(np);
            t.setPerson(np);
        }
    }

    /**
     * Метод, генерирующий билет с консоли.
     */
    public static Ticket setTicketFromConsole(){
        Ticket nt = new Ticket();
        setNameFromConsole(nt);
        setCoordinatesFromConsole(nt);
        setPriceFromConsole(nt);
        setRefundableFromConsole(nt);
        setTypeFromConsole(nt);
        setPersonFromConsole(nt);
        System.out.println("Билет создан успешно!");
        return nt;
    }

    /**
     * Обновить значение билета
     * @return обновленный билет
     */
    public static Ticket updateTicketFromConsole(){
        Ticket nt = new Ticket();
        setNameFromConsole(nt);
        setCoordinatesFromConsole(nt);
        setPriceFromConsole(nt);
        setRefundableFromConsole(nt);
        setTypeFromConsole(nt);
        setPersonFromConsole(nt);
        nt.setDefaultCreationDate();
        return nt;
    }
}
