package at.ealwary.jnrchallenge.provider;

import org.bukkit.Bukkit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseProvider {
    private final String host;
    private final String user;
    private final String password;
    private final String database;
    public Connection connection;

    public DatabaseProvider(String host, String user, String password, String database) {
        this.host = host;
        this.user = user;
        this.password = password;
        this.database = database;
        this.connect();
    }

    private void connect() {
        if(!isSQLConnected()) {
            try {
                this.connection = DriverManager.getConnection("jdbc:mysql://" + host + ":3306/" + database + "?autoReconnect=true", user, password);

            } catch (SQLException e) {
                e.printStackTrace();
                Bukkit.getConsoleSender().sendMessage("§c[JnrChallenge] Verbindung zur Datenbank gescheitert. Die Speicherung von Inventaren in MySQL funktioniert derzeit nicht und wird deaktiviert. (Keine/Falsche MySQL LoginDaten -> Check config.yml)§r");
            }
        }
    }

    public void disconnect() {
        if(this.connection == null) {
            return;
        } else {
            try {
                this.connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(String query) {
        try {
            Statement statement = this.connection.createStatement();
            statement.execute(query);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() {
        return connection;
    }

    public boolean isSQLConnected() {
        return getConnection() != null;
    }
}
