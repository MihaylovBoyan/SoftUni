package Logger.models.appenders;

import Logger.enums.ReportLevel;
import Logger.interfaces.Appender;
import Logger.interfaces.Layout;

public class ConsoleAppender extends BaseAppender {

    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    protected void append(String text) {
        System.out.println(text);
    }
}

