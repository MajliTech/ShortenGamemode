package pl.majlitech.shortengamemode;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ConfigManager {
    private static FileConfiguration info;

    public ConfigManager() {
        File languagefile = new File(Main.getInstance().getDataFolder(), "config.yml");

        if (!languagefile.exists()) {
            try {
                Main.getInstance().saveResource("config.yml", true);
            } catch (Exception e) {
                Main.getInstance().getLogger().warning("Couldn't save config file, shutting down!");
                Main.getInstance().getPluginLoader().disablePlugin(Main.getInstance());
            }


        }

        info = YamlConfiguration.loadConfiguration(languagefile);
        int ver = info.getInt("version");
        if (ver != 2) {
            if (info.getBoolean("force-new-config")) {
                try {
                    Main.getInstance().saveResource("config.yml", true);
                } catch (Exception e) {
                    Main.getInstance().getLogger().warning("Couldn't save config file, shutting down!");
                    Main.getInstance().getPluginLoader().disablePlugin(Main.getInstance());
                }
            } else {
                Main.getInstance().getLogger().warning("!!!! OLD CONFIG DETECTED !!!!");
                Main.getInstance().getLogger().warning("Please add the new config and update the version to 2.");
                Main.getInstance().getLogger().warning("If you didn't change anything in the config, ");
                Main.getInstance().getLogger().warning("you probably want to add \"force-new-config: true\" to it.");
                Main.getInstance().getLogger().warning("If you changed it, then get the new config from");
                Main.getInstance().getLogger().warning("https://github.com/MajliTech/ShortenGamemode/blob/main/src/main/resources/config.yml");
                Main.getInstance().getLogger().warning("and update it according to your needs.");
                Main.getInstance().getLogger().warning("The plugin is now shutting down.");
                Main.getInstance().getLogger().warning("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                Main.getInstance().getLogger().info("");
                Main.shutdown = true;
            }
        }
//        YamlConfiguration.

    }

    public static String get(String key) {
        return info.getString(key);

    }

    public static String[] getLists(String key) {
        return info.getStringList(key).toArray(new String[0]);
    }

}