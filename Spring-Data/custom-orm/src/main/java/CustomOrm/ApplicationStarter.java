package CustomOrm;

import ormFramework.core.EntityManagerFactory;

import java.net.URISyntaxException;
import java.sql.SQLException;

public class ApplicationStarter {

    public static void main(String[] args) throws SQLException, URISyntaxException {


        EntityManagerFactory.create(
                "mysql",
                "localhost",
                3306,
                "root",
                "bobo123456789",
                "orm",
                ApplicationStarter.class
        );



    }
}
