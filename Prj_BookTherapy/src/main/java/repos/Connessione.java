package repos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Connessione {

    private final String HOST = "jdbc:mysql://letturaplatform-database2025.d.aivencloud.com:19066/defaultdb?sslMode=REQUIRED";

    @Value("${spring.datasource.username}")
    private String USER;

    @Value("${spring.datasource.password}")
    private String PASS;


    private Connection conn;

    private void connetti() {
        try {

            System.setProperty("javax.net.ssl.trustStore", "src/main/resources/keystore.jks");
            System.setProperty("javax.net.ssl.trustStorePassword", "changeit");


            this.conn = DriverManager.getConnection(HOST, USER, PASS);
            System.out.println("Connesso al DB Aiven");

        } catch (SQLException e) {
            System.err.println("Non CONNESSO al DB Aiven");
            System.err.println(e.getMessage());
        }
    }

    public Connection getConn() {
        if (conn == null) connetti();

        return this.conn;    
    }
}


