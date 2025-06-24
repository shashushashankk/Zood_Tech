package Login;

import com.zoodel.Generic.GlobalVariable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class LogTest extends GlobalVariable {

    @Test
    void logTest(){

        log.trace("Trace log");
        log.debug("Debug log");
        log.info("info log");
        log.fatal("fatal log");
        log.error("error log");
    }
}
