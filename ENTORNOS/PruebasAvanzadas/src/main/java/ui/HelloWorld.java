package ui;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class HelloWorld {


    public void sayHello(String name) {
        log.info("Hello " + name);
        log.error("Hello " + name);
    }
}
