package Logger;

import JavaAdvanced.Clas;
import Logger.enums.ReportLevel;
import Logger.interfaces.Appender;
import Logger.interfaces.Layout;
import Logger.interfaces.Logger;
import Logger.models.appenders.ConsoleAppender;
import Logger.models.layouts.SimpleLayout;
import Logger.models.layouts.XmlLayout;
import Logger.models.loggers.MessageLogger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        try {
            int appenderCount = Integer.parseInt(scanner.nextLine());
            Appender[] appenders = new Appender[appenderCount];

            for (int i = 0; i < appenderCount; i++) {
                String[] tokens = scanner.nextLine().split("\\s+");

                Layout layout = getLayout(tokens[1]);
                ReportLevel reportLevel = ReportLevel.INFO;
                if (tokens.length == 3) {
                    reportLevel = ReportLevel.valueOf(tokens[2]);
                }
                Appender appender = getAppender(layout, tokens[0]);
                appender.setReportLevel(reportLevel);
                appenders[i] = appender;
            }

            Logger logger = new MessageLogger(appenders);
            String input = scanner.nextLine();

            while (!input.equals("END")){

                String[] tokens = input.split("\\|");
                ReportLevel reportLevel = ReportLevel.valueOf(tokens[0]);
                String dateTime = tokens[1];
                String message = tokens[2];
                logMessage(logger, reportLevel, dateTime,message);

                input = scanner.nextLine();
            }
            System.out.println(logger.getLogInfo());

        } catch
        (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException
                        e) {
            e.printStackTrace();
        }


    }

    private static void logMessage(Logger logger, ReportLevel reportLevel, String dateTime, String message) throws InvocationTargetException, IllegalAccessException {

        Class loggerClass = logger.getClass();
        Method method = Arrays.stream(loggerClass.getMethods())
                .filter(m -> m.getName().equalsIgnoreCase("log" + reportLevel))
                .findFirst()
                .orElseThrow();

        method.invoke(logger, dateTime, message);
    }


    private static Appender getAppender(Layout layout, String appenderName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class clazz = Class.forName("Logger.models.appenders." + appenderName);
        return (Appender) clazz.getConstructor(Layout.class).newInstance(layout);

    }

    private static Layout getLayout(String layoutName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class clazz = Class.forName("Logger.models.layouts." + layoutName);

        return (Layout) clazz.getConstructor().newInstance();
    }
}
