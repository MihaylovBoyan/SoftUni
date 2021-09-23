package ormFramework.core;

import java.io.File;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EntityManagerFactory {


    public static EntityManager create(String dbType, String host, int port, String user, String pass, String dbName, Class<?> mainClass) throws SQLException, URISyntaxException {
        Connection connection = DriverManager.getConnection("jdbc:" + dbType + "://" + host + ":" + port + "/" + dbName, user, pass);


        String path = mainClass.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
        String packageName = mainClass.getPackageName();

        System.out.println(packageName);
        System.out.println(path);


        File root = new File(path + packageName.replace(".", "/"));

        return null;
    }

    private static void scan(File dir, String packageName){


    }

}
