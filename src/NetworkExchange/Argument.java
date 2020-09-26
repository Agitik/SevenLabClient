package NetworkExchange;

import Accounter.User;
import StartClasses.Ticket;
import StartClasses.TicketType;


import java.io.Serializable;
import java.util.LinkedHashSet;

/**
 * Класс для хранения аргумента команды.
 * @author Дмитрий Толочек P3130
 * @version 1.0 Before Check
 */

public class Argument implements Serializable {
    private static final long serialVersionUID = 0;
    public Long key;
    public TicketType type;
    public Ticket ticket;
    public LinkedHashSet<QuestionPack> script;
    public Long id;
    public User user;
}
