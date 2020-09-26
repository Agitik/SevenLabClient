package Info;

import java.io.*;
import java.util.Scanner;

public class ProgramInfo {
    static Boolean result = false;
    public static void showMessage(String messageFileName){
        try {
            messageFileName += ".txt";
            String path = "Messages/" + messageFileName;
            ClassLoader loader = ProgramInfo.class.getClassLoader();
            InputStream isstream = loader.getResourceAsStream(path);
            InputStreamReader inputStreamReader = new InputStreamReader(isstream);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
            isstream.close();
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
