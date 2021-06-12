package db;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;

import java.util.Properties;

import java.sql.*;

public class DAO {
  private static DAO instance;
  private Connection connection;

  private DAO(String URL, String username, String password) throws SQLException {
    this.connection = DriverManager.getConnection(URL, username, password);
  }

  public static DAO getInstance() throws SQLException, IOException, FileNotFoundException {
    if (instance == null) {
      FileReader fileReader = new FileReader("src/properties/db.properties");
      Properties properties = new Properties();
      properties.load(fileReader);

      instance = new DAO(properties.getProperty("URL"), properties.getProperty("username"), 
                        properties.getProperty("password"));
    }
    return instance;
  }

  public Connection getConnection() {
    return connection;
  }

}