package at.ealwary.jnrchallenge.provider;

import at.ealwary.jnrchallenge.JnrChallenge;
import org.bukkit.scheduler.BukkitRunnable;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class InventoryProvider {
//    private JnrChallenge plugin;
//
//    public InventoryProvider(JnrChallenge plugin) {
//        this.plugin = plugin;
//    }
//
//    public void pushDataAsynchron() {
//        new BukkitRunnable() {
//            @Override
//            public void run() {
//                pushData();
//            }
//        }.runTaskTimerAsynchronously(plugin, 20*60*5,20*60*5);
//    }
//
//    public void pushData() {
//        clearDatabase();
//
//        if(plugin.getPlayerBirthdays().size() == 0) {
//            return;
//        }
//
//        plugin.getPlayerBirthdays().forEach((key, value) -> {
//            PreparedStatement preparedStatement = null;
//
//            try {
//
//                preparedStatement = plugin.getDatabaseProvider().connection.prepareStatement("INSERT INTO MinecraftBirthdays VALUES (?,?,?)");
//                preparedStatement.setString(1, value.getUUID().toString());
//                preparedStatement.setString(2, value.getDate());
//                preparedStatement.setInt(3, value.getYear());
//                preparedStatement.executeUpdate();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            } finally {
//                try {
//                    preparedStatement.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//    }
//
//
//    public void clearDatabase() {
//        PreparedStatement preparedStatement = null;
//
//        try {
//            preparedStatement = plugin.getDatabaseProvider().connection.prepareStatement("DELETE FROM MinecraftBirthdays;");
//            preparedStatement.executeUpdate();
//        } catch (SQLException ex) {
//        } finally {
//            try {
//                preparedStatement.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//
//    public void loadData() {
//        ResultSet resultSet = null;
//        try {
//            resultSet = plugin.getDatabaseProvider().connection.createStatement().executeQuery("SELECT * FROM MinecraftBirthdays");
//
//
//
//            while (resultSet.next()) {
//                UUID uuid = UUID.fromString(resultSet.getString("UUID"));
//                String date = resultSet.getString("Bday");
//                int year = resultSet.getInt("lastConYear");
//
//                BirthdayPlayer birthdayPlayer = new BirthdayPlayer(uuid, date, year);
//
//                plugin.getPlayerBirthdays().put(uuid, birthdayPlayer);
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        } finally {
//            try {
//                resultSet.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
