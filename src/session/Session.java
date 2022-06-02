package session;

import dto.User;
import logger.Logger;

public class Session {

    private User user;

    private static Session instance;
    private static final Logger log = Logger.getInstance();

    private Session() {}

    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    public void createSession(final User user){
        log.info(this.getClass(), "Создана сессия с %s".formatted(user.getUserName()));
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }
}
