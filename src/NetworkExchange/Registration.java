package NetworkExchange;

import Accounter.User;

public class Registration {
    public static QuestionPack registration_request(User user){
        Argument arg = new Argument();
        arg.user = user;
        return new QuestionPack(ClientCommands.REGISTRATION, arg);
    }
    public static boolean status_check(AnswerPack ap){
        return ap.status;
    }
}
