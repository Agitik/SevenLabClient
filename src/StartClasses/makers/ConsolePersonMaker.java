package StartClasses.makers;

import StartClasses.*;

import java.util.Scanner;

/**
 * Класс, реализующий ввод данных владельца билета пользователем с дальнейшей валидацией.
 * @author Дмитрий Толочек P3130
 * @version 2.0 After 5 lab check.
 * @see Person
 */
public class ConsolePersonMaker {

    static Scanner in = new Scanner(System.in);

    /**
     * Метод, реализующий ввод веса с консоли.
     * @param p - Изменяемые данные о владельце билета.
     */
    public static void setWeightFromConsole(Person p){
        try {
            System.out.print("Введите вес владельца билета (Больше нуля): ");
            String w = in.nextLine().trim();
            if(w.equals("")){
                p.setWeight(null);
            } else if (Double.parseDouble(w) < 0){
                throw new UnrealValueException("\nЗначение должно быть больше нуля!");
            } else {
                p.setWeight(Double.parseDouble(w));
            }
        } catch (NumberFormatException e){
            System.out.println("\nВведено некорректное число\n" + "Попробуйте еще раз!");
            setWeightFromConsole(p);
        } catch (UnrealValueException e){
            System.out.print(e.getMessage() + " Попробуйте еще раз!\n");
            setWeightFromConsole(p);
        }
    }

    /**
     * Метод, реализующий ввод цвета глаз с консоли.
     * @param p - Изменяемые данные о владельце билета.
     */
    public static void setEyeColorFromConsole(Person p){
        System.out.print("Введите цвет глаз владельца билета (RED, BLACK, BLUE, YELLOW, WHITE, GREEN): ");
        try {
            Color ec = Color.getType(in.nextLine());
            if(ec == null){
                throw new UnrealValueException("\nВведены некорректные данные\n");
            }
            p.setEyeColor(ec);
        } catch (UnrealValueException e){
            System.out.print(e.getMessage() + "\nПопробуйте еще раз!");
            setEyeColorFromConsole(p);
        }
    }

    /**
     * Метод, реализующий ввод цвета волос с консоли.
     * @param p - Изменяемые данные о владельце билета.
     */
    public static void setHairColorFromConsole(Person p){
        System.out.print("Введите цвет волос владельца билета (RED, BLACK, BLUE, YELLOW, WHITE, GREEN): ");
        p.setHairColor(Color.getType(in.nextLine()));
    }

    /**
     * Метод, реализующий ввод гражданской принадлежности с консоли.
     * @param p - Изменяемые данные о владельце билета.
     */
    public static void setNationalityFromConsole(Person p){
        System.out.print("Выберите страну из списка (USA, GERMANY, SOUTH_KOREA): ");
        p.setNationality(Country.getType(in.nextLine()));
    }

    /**
     * Метод, реализующий ввод места рождения с консоли.
     * @param p - Изменяемые данные о владельце билета.
     */
    public static void setLocationFromConsole(Person p){
        System.out.print("Вы хотите ввести данные о месте рождения владельца билета? (true/false): ");
        if(Boolean.parseBoolean(in.nextLine())){
            Location nl = new Location();
            setLocationNameFromConsole(nl);
            setLocationCoordinatesFromConsole(nl);
            p.setLocation(nl);
        }
    }

    /**
     * Метод, реализующий ввод названия местности с консоли.
     * @param l - Место рождения владельца билета.
     */
    public static void setLocationNameFromConsole(Location l){
        String result;
        System.out.print("Введите название места рождения: ");
        try {
            result = in.nextLine().trim();
            if (result.equals("")){throw new UnrealValueException("\nДанное поле не может быть пустым!\n");}
            l.setName(result);
        } catch (UnrealValueException e) {
            System.out.println(e.getMessage());
            setLocationNameFromConsole(l);
        }
    }

    /**
     * Метод, реализующий ввод координат места рождения с консоли.
     * @param l - Место рождения владельца билета.
     */
    public static void setLocationCoordinatesFromConsole(Location l){
        try {
            System.out.print("Введите X координату места рождения: ");
            l.setX(Long.parseLong(in.nextLine().trim()));
            System.out.print("Введите Y координату места рождения: ");
            l.setY(Float.parseFloat(in.nextLine().trim()));
        } catch (NumberFormatException e){
            System.out.println("\nПрограмма не смогла распознать ваше число, попробуйте еще раз!");
            System.out.println("Введите X и Y координаты заново!\n");
            setLocationCoordinatesFromConsole(l);
        }
    }
}
