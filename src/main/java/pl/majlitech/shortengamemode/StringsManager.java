package pl.majlitech.shortengamemode;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class StringsManager {
    private static FileConfiguration info;
    public StringsManager()
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
        int ver=info.getInt("version");
        if (ver!=2) {
            if (Boolean.parseBoolean(ConfigManager.get("force-new-messages"))) {
                try {
                    Main.getInstance().saveResource("messages.yml", true);
                } catch(Exception e)
                {
                    Main.getInstance().getLogger().warning("Couldn't save messages file, shutting down!");
                    Main.getInstance().getPluginLoader().disablePlugin(Main.getInstance());
                }
            } else {
            Main.getInstance().getLogger().warning("!!!! OLD MESSAGES DETECTED !!!!");
            Main.getInstance().getLogger().warning("Please add the new messages file and update the version to 2.");
            Main.getInstance().getLogger().warning("If you didn't change anything in the messages, ");
            Main.getInstance().getLogger().warning("you probably want to add \"force-new-messages: true\" to config.");
            Main.getInstance().getLogger().warning("If you changed it, then get the new messages file from");
            Main.getInstance().getLogger().warning("https://github.com/MajliTech/ShortenGamemode/blob/main/src/main/resources/messages.yml");
            Main.getInstance().getLogger().warning("and update it according to your needs.");
            Main.getInstance().getLogger().warning("The plugin is now shutting down.");
            Main.getInstance().getLogger().warning("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            Main.getInstance().getLogger().info("");
            Main.shutdown = true;}

        }

    }

    public static String get(String key)
    {
        return ChatColor.translateAlternateColorCodes('&',info.getString("prefix"))+ChatColor.RESET+ChatColor.translateAlternateColorCodes('&',info.getString(key));

    }
    public static String getWithoutPrefix(String key)
    {
        return ChatColor.translateAlternateColorCodes('&',ChatColor.translateAlternateColorCodes('&',info.getString(key)));

    }
}