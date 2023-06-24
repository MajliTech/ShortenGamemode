package pl.majlitech.shortengamemode;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class LanguageManager {
    private static FileConfiguration info;
    public LanguageManager()
    {
        File languagefile = new File(Main.getInstance().getDataFolder(), "messages.yml");

        if(!languagefile.exists())
        {
            try {
                Main.getInstance().saveResource("messages.yml", true);
            } catch(Exception e)
            {
                Main.getInstance().getLogger().warning("Couldn't save messages file, shutting down!");
                Main.getInstance().getPluginLoader().disablePlugin(Main.getInstance());
            }


        }

        info = YamlConfiguration.loadConfiguration(languagefile);


    }

    public static String get(String key)
    {
        return ChatColor.translateAlternateColorCodes('&',info.getString("prefix"))+" "+ChatColor.RESET+ChatColor.translateAlternateColorCodes('&',info.getString(key));

    }

}