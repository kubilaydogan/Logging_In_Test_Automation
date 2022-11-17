
## How to implement SLF4J together with LOG4J for logging?

### **1) Add Log4j2 and SLF4j Binding Dependencies**

```xml
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-api</artifactId>
    <version>2.19.0</version>
</dependency>
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-core</artifactId>
    <version>2.19.0</version>
</dependency>
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-slf4j-impl</artifactId>
    <version>2.19.0</version>
    <scope>test</scope>
</dependency>
```

> `log4j-slf4j2-impl` dependency should be used for binding SLF4J. Use the matching log4j version



### **2) Specify logging configurations in `log4j2.xml` file under test/resources folder**
> See example under `src/test/resources/log4j2.xml`


### **3) Usage of Logs**
Create preferably `private static final` logger instance in classes

```java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage {
    private static final Logger log = LoggerFactory.getLogger(LoginPage.class);

    public static void login(String profile) {
        log.info("Login as " + profile +" started!");
    }
}
```
Sample of automation.log:
```
2022-11-09 11:27:02 [main] INFO  hooks:23 - ===============================================================
2022-11-09 11:27:02 [main] INFO  hooks:24 - |          Test is Starting...
2022-11-09 11:27:02 [main] INFO  hooks:25 - |          Operating System : Mac OS X
2022-11-09 11:27:02 [main] INFO  hooks:26 - ===============================================================

2022-11-09 11:27:02 [main] INFO  hooks:33 - ===============================================================
2022-11-09 11:27:02 [main] INFO  hooks:34 - |          Scenario Name: Login with valid admin credentials
2022-11-09 11:27:02 [main] INFO  hooks:35 - ===============================================================
2022-11-09 11:27:02 [main] INFO  LoginPage:10 - Login as admin started!
```

<br>
<br>

Sample of LOG4J usage without SLF4J

```java
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginPage {
    private static final Logger log = LogManager.getLogger(LoginPage.class);

    public static void login(String profile) {
        log.info("Login as " + profile +" started!");
    }
}
```
