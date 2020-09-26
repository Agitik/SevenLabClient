package Info;

import java.io.*;
import java.util.Scanner;

public class ProgramInfo {
    static Boolean result = false;
    public static void showMessage(String messageFileName){
        try {
            messageFileName += ".txt";
            String path = "out\\production\\SevenLabClient\\Messages\\" + messageFileName;
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
            fr.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isSmthExistWithoutNull(){
        result = false;
        try {
            Scanner check = new Scanner(System.in);
            String in = check.nextLine().toLowerCase().trim();
            if(in.equals("y")){
                result = true;
            }else if(!in.equals("n")){
                throw new ChooseException();
            }
        } catch (ChooseException e){
            showMessage("AnswerErrorWithoutNull");
            isSmthExistWithoutNull();
        }
        return result;
    }

    public static Serializable isSmthExistNull(){
        result = false;
        try {
            Scanner check = new Scanner(System.in);
            String in = check.nextLine().toLowerCase().trim();
            if(in.equals("y")){
                result = true;
            }else if(in.equals("n")){
                result = false;
            }else if(in.equals("")){
                result = null;
            } else {
                throw new ChooseException();
            }
        } catch (ChooseException e){
            showMessage("AnswerErrorNull");
            isSmthExistNull();
        }
        return result;
    }
}
