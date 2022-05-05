package ui;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Appender;
import org.apache.logging.log4j.core.LogEvent;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class HelloWorldTest {

    @Mock
    private Appender mockAppender;

    @Captor
    private ArgumentCaptor<LogEvent> logCaptor;


    @BeforeEach
    void setUp() {
        Mockito.reset(mockAppender);
        //Set the name of the Appender
        Mockito.when(mockAppender.getName()).thenReturn("MockAppender");
        //Set to be ready to be used as an Appender (bottom 2 lines)
        Mockito.when(mockAppender.isStarted()).thenReturn(true);
//        Mockito.when(mockAppender.isStopped()).thenReturn(false);

        //Take out the ROOT logger and set the Appender.
        LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
        Configuration config = ctx.getConfiguration();

        LoggerConfig loggerConfig = config.getLoggerConfig(LogManager.ROOT_LOGGER_NAME);

        loggerConfig.setLevel(Level.INFO);
        loggerConfig.addAppender(mockAppender, Level.INFO, null);
        ctx.updateLoggers();

    }

    @Test
    void sayHello() {
        String name = "World";

        HelloWorld helloWorld = new HelloWorld();
        helloWorld.sayHello(name);

        Mockito.verify(mockAppender, Mockito.times(2)).append(logCaptor.capture());

        String message = logCaptor.getAllValues().get(0).getMessage().getFormattedMessage();
        Level level = logCaptor.getAllValues().get(0).getLevel();
        assertThat(message).isEqualTo("Hello " + name);
        assertThat(level).isEqualTo(Level.INFO);

        message = logCaptor.getAllValues().get(1).getMessage().getFormattedMessage();
        level = logCaptor.getAllValues().get(1).getLevel();
        assertThat(message).isEqualTo("Hello " + name);
        assertThat(level).isEqualTo(Level.ERROR);

    }
}
