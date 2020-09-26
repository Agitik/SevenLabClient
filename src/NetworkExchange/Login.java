package NetworkExchange;

import Accounter.User;

public class Login {
    public static QuestionPack login_request(User user){
        Argument arg = new Argument();
        arg.user = user;
        return new QuestionPack(ClientCommands.LOGIN, arg);
    }
    public static boolean status_check(AnswerPack ap){
        return ap.status;
    }
}
