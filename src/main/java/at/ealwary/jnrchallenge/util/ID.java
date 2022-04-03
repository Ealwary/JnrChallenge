package at.ealwary.jnrchallenge.util;

public class ID {

    //Messages
    public static final String PREFIX = "§7[§3§lChallenge§r§7] §r",
            NO_PERMS = PREFIX + "§cDazu hast du keine Rechte.",
            ONLY_FOR_PLAYERS = PREFIX + "§cDieser Befehl ist nur für Spieler verfügbar.",
            WRONG_USAGE = PREFIX + "§cBitte benutze §6/",
            TP_WARN_MESSAGE_3 = PREFIX + "§aDu wirst in §63 §aSekunden teleportiert..",
            TP_WARN_MESSAGE_2 = PREFIX + "§aDu wirst in §62 §aSekunden teleportiert..",
            TP_WARN_MESSAGE_1 = PREFIX + "§aDu wirst in §6einer §aSekunde teleportiert..",
            TP_MESSAGE = PREFIX + "§aDu wirst §6jetzt §ateleportiert..",
            CHALLENGE_ALREADY_RUNNING = PREFIX + "§cDie Challenge läuft bereits.",
            CHALLENGE_ALREADY_PAUSED = PREFIX + "§cDie Challenge ist bereits pausiert.",
            CHALLENGE_PAUSED = PREFIX + "§aDie Challenge wurde pausiert.",
            CHALLENGE_RESUMED = PREFIX + "§aDie Challenge wird ",
            NO_MYSQL_CON = PREFIX + "§cDa keine MySQL-Connection vorhanden ist, kann diese Einstellung nicht aktiviert werden (Überprüfe die config.yml)";


    //Inventory Names
    public static final String INVENTORY_NAME_START = "§a§l§m§n§k§m§8§2§l§8» ",
            INVENTORY_NAME_SETTINGS = "Settings";

    //Item Names
    public static final String REWARD_NAME_START = "§6";

    //Timer Prefix
    public static final String TIMER_PREFIX1 = "§6§l";
    public static final String TIMER_PREFIX2 = "§7§l:" + TIMER_PREFIX1;


    //Permissions
    public static final String PERMISSION_SETTINGS = "jnrchallenge.settings";
    public static final String PERMISSION_CHALLENGE = "jnrchallenge.challenge";


    //Config Paths
    public static final String CPATH_HOST = "mysql.host",
            CPATH_DATABASE = "mysql.database",
            CPATH_USER = "mysql.user",
            CPATH_PSWD = "mysql.password";

    //World name
    public static final String JNR_WORLD_NAME = "JumpAndRunWorld";

}
