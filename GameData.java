
import java.io.*;
import java.util.*;

public class GameData {
    private static final String DATA_FILE = "gamedata.txt";
    
    public static void saveHighScore(String game, int score) {
        try {
            Properties props = loadProperties();
            props.setProperty(game + "_highscore", String.valueOf(score));
            saveProperties(props);
            System.out.println("High score saved for " + game + ": " + score);
        } catch (IOException e) {
            System.out.println("Error saving high score: " + e.getMessage());
        }
    }
    
    public static int getHighScore(String game) {
        try {
            Properties props = loadProperties();
            String score = props.getProperty(game + "_highscore", "0");
            return Integer.parseInt(score);
        } catch (Exception e) {
            return 0;
        }
    }
    
    public static void saveGameStats(String game, String stat, String value) {
        try {
            Properties props = loadProperties();
            props.setProperty(game + "_" + stat, value);
            saveProperties(props);
        } catch (IOException e) {
            System.out.println("Error saving game stats: " + e.getMessage());
        }
    }
    
    public static String getGameStats(String game, String stat) {
        try {
            Properties props = loadProperties();
            return props.getProperty(game + "_" + stat, "");
        } catch (Exception e) {
            return "";
        }
    }
    
    private static Properties loadProperties() throws IOException {
        Properties props = new Properties();
        File file = new File(DATA_FILE);
        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream(file)) {
                props.load(fis);
            }
        }
        return props;
    }
    
    private static void saveProperties(Properties props) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(DATA_FILE)) {
            props.store(fos, "Game Data");
        }
    }
}
