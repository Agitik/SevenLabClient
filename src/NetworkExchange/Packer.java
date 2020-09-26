package NetworkExchange;

import Accounter.User;
import StartClasses.TicketType;
import StartClasses.UnrealValueException;
import StartClasses.makers.ConsoleTicketMaker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * Класс, предназначенный для упаковки запроса серверу.
 * @author Дмитрий Толочек P3130
 * @version 1.0 Before Check
 */

public class Packer {

    public static HashSet<File> checker = new HashSet<File>();
    public static User mainUser = ClientMain.main_user;

    /**
     * Делает из команды объект - запрос для сервера.
     * @param in - команда и ее аргумент
     * @return объект - запрос "QuestionPack"
     */
    public static QuestionPack CommandPicker(String in){
        QuestionPack p = null;
        String inRe = in.trim().toUpperCase();
        if(inRe.contains("HELP")){
            ClientCommands.showHelp();
            p = new QuestionPack(ClientCommands.HELP);
        } else if(inRe.contains("INFO")){
            p = new QuestionPack(ClientCommands.INFO);
        } else if(inRe.contains("SHOW")){
            p = new QuestionPack(ClientCommands.SHOW);
        } else if(inRe.contains("INSERT_NULL")){
            Argument arg = new Argument();
            inRe = inRe.replace("INSERT_NULL","");
            try{
                arg.ticket = ConsoleTicketMaker.setTicketFromConsole();
                arg.key = Long.parseLong(inRe.trim());
                if(arg.key < 0){throw new NumberFormatException();}
                p = new QuestionPack(ClientCommands.INSERT_NULL, arg);
            } catch (NumberFormatException e){
                System.out.println("Введен недопустимый тип ключа! Ключ должен быть положительным");
            }
        } else if(inRe.contains("UPDATE_ID")){
            Argument arg = new Argument();
            inRe = inRe.replace("UPDATE_ID","");
            try{
                arg.ticket = ConsoleTicketMaker.updateTicketFromConsole();
                arg.id = Long.parseLong(inRe.trim());
                if(arg.id < 0){throw new NumberFormatException();}
                p = new QuestionPack(ClientCommands.UPDATE_ID, arg);
            } catch (NumberFormatException e){
                System.out.println("Введен недопустимый ID! Он должен быть больше нуля!");
            }
        } else if(inRe.contains("REMOVE_KEY")){
            inRe = inRe.replace("REMOVE_KEY","");
            Argument arg = new Argument();
            try{
                arg.key = Long.parseLong(inRe.trim());
                if(arg.key < 0){throw new NumberFormatException();}
                p = new QuestionPack(ClientCommands.REMOVE_KEY, arg);
            } catch (NumberFormatException e){
                System.out.println("Введен недопустимый ключ! Ключ должен быть положительным");
            }
        } else if(inRe.contains("CLEAR")){
            p = new QuestionPack(ClientCommands.CLEAR);
        } else if(inRe.contains("EXECUTE_SCRIPT")){
            inRe = inRe.replace("EXECUTE_SCRIPT","");
            p = new QuestionPack(ClientCommands.EXECUTE_SCRIPT, Packer.Script_Packer(inRe.trim()));
        } else if(inRe.contains("REPLACE_IF_GREATER")){
            Argument arg = new Argument();
            inRe = inRe.replace("REPLACE_IF_GREATER","");
            try{
                arg.ticket = ConsoleTicketMaker.setTicketFromConsole();
                arg.key = Long.parseLong(inRe.trim());
                if(arg.key < 0){throw new NumberFormatException();}
                p = new QuestionPack(ClientCommands.REPLACE_IF_GREATER, arg);
            } catch (NumberFormatException e){
                System.out.println("Введен недопустимый тип ключа! Он должен быть больше нуля!");
            }
        } else if(inRe.contains("REMOVE_GREATER_KEY")){
            Argument arg = new Argument();
            inRe = inRe.replace("REMOVE_GREATER_KEY","");
            try {
                arg.key = Long.parseLong(inRe.trim());
                if(arg.key < 0){throw new NumberFormatException();}
                p = new QuestionPack(ClientCommands.REMOVE_GREATER_KEY, arg);
            } catch (NumberFormatException e){
                System.out.println("Введен недопустимый тип ключа! Он должен быть больше нуля!");
            }
        } else if(inRe.contains("REMOVE_LOWER_KEY")){
            Argument arg = new Argument();
            inRe = inRe.replace("REMOVE_LOWER_KEY","");
            try {
                arg.key = Long.parseLong(inRe.trim());
                if(arg.key < 0){throw new NumberFormatException();}
                p = new QuestionPack(ClientCommands.REMOVE_LOWER_KEY, arg);
            } catch (NumberFormatException e){
                System.out.println("Введен недопустимый тип ключа! Он должен быть больше нуля!");
            }
        } else if(inRe.contains("COUNT_LESS_THAN_TYPE")){
            Argument arg = new Argument();
            inRe = inRe.replace("COUNT_LESS_THAN_TYPE","");
            if(TicketType.getType(inRe) == null){
                System.out.println("Такого типа билета не существует!");
            } else {
                arg.type = TicketType.getType(inRe.trim());
                p = new QuestionPack(ClientCommands.COUNT_LESS_THAN_TYPE, arg);
            }
        } else if(inRe.contains("PRINT_FIELD_ASCENDING_PERSON")){
            p = new QuestionPack(ClientCommands.PRINT_FIELD_ASCENDING_PERSON);
        } else if(inRe.contains("PRINT_FIELD_DESCENDING_TYPE")){
            p = new QuestionPack(ClientCommands.PRINT_FIELD_DESCENDING_TYPE);
        }  else if(inRe.contains("EXIT")){
            System.out.println("Ининицирован выход клиента.");
            p = new QuestionPack(ClientCommands.EXIT);
        }
        try {
            if (p != null) {
                p.arg.user = ClientMain.main_user;
            }
        } catch (NullPointerException e){
            Argument argument = new Argument();
            argument.user = ClientMain.main_user;
            p.arg = argument;
        }
        return p;
    }

    public static Argument Script_Packer(String file) {
        file = file.toLowerCase();
        Argument arg = new Argument();
        LinkedHashSet<QuestionPack> sc = new LinkedHashSet<QuestionPack>();
        try{
            File f = new File(file);
            for (File cf : Packer.checker) {
                if (cf.equals(f)){
                    throw new UnrealValueException("Вызов файла во время исполнения этого же файла запрещен!");
                }
            }
            Packer.checker.add(f);
            FileReader fr = new FileReader(f);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                QuestionPack a = Packer.CommandPicker(line);
                if(a == null){
                    System.out.print("Команда в скрипте не распознана! (Чтение скрипта продолжено)");
                    continue;
                }
                sc.add(a);
                line = reader.readLine();
            }
            Packer.checker.remove(f);
        } catch (IOException e) {
            System.out.println("Во время чтения скрипта произошла ошибка!");
            sc.clear();
        } catch (UnrealValueException e){
            System.out.println(e.getMessage());
            System.out.println("Внесите изменение в скрипт и попробуйте еще раз!");
        }
        arg.script = sc;
        return arg;
    }
}
