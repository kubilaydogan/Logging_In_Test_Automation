package pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage {
    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);

    public static void login(String profile) {
        log.info("Login as " + profile +" started!");
    }
}

/*
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginPage {
     Using Log4j
    private static final Logger log = LogManager.getLogger(LoginPage.class);

    public static void login(String profile) {
        log.info("Login as " + profile +" started!");
    }
}
*/