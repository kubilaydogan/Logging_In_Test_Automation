
## How to implement LOG4J in your framework?

### **1) Specify configurations in `log4j2.xml` file under test/resources folder**

### **2) Create preferably `private static final` logger instance in classes**

> private static final Logger log = LogManager.getLogger(className.class);

### **3) Place your logs:**
###### example:     
> log.info("Test is Starting...");