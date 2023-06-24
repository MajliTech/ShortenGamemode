package pl.majlitech.shortengamemode;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pl.majlitech.shortengamemode.Commands.Gamemode;

public final class Main extends JavaPlugin{
    public static Main instance = null;
    @Override
    public void onEnable() {
        instance=this;

        new ConfigManager();
        new LanguageManager();
        this.getCommand("gamemode").setExecutor(new Gamemode());
        this.getCommand("gm").setExecutor(new Gamemode());

    }

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
