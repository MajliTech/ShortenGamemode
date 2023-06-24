package pl.majlitech.shortengamemode;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ConfigManager {
    private static FileConfiguration info;
    public ConfigManager()
    {
        File languagefile = new File(Main.getInstance().getDataFolder(), "config.yml");

        if(!languagefile.exists())
        {
            try {
                Main.getInstance().saveResource("config.yml", true);
            } catch(Exception e)
            {
                Main.getInstance().getLogger().warning("Couldn't save config file, shutting down!");
                Main.getInstance().getPluginLoader().disablePlugin(Main.getInstance());
            }


        }

        info = YamlConfiguration.loadConfiguration(languagefile);


    }

    public static String get(String key)
    {
        return info.getString(key);

    }

}