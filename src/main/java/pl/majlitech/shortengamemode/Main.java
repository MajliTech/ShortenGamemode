package pl.majlitech.shortengamemode;

import org.bstats.bukkit.Metrics;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pl.majlitech.shortengamemode.Commands.Disabled;
import pl.majlitech.shortengamemode.Commands.Gamemode;

public final class Main extends JavaPlugin{
    public static Main instance = null;
    public static boolean shutdown = false;
    @Override
    public void onEnable() {
        instance=this;

        new ConfigManager();
        new StringsManager();
        if (shutdown) {
            Bukkit.getPluginManager().registerEvents(new Events(),this);
            this.getCommand("gamemode").setExecutor(new Disabled());
            this.getCommand("gm").setExecutor(new Disabled());
            return;
        }
        this.getCommand("gamemode").setExecutor(new Gamemode());
        this.getCommand("gm").setExecutor(new Gamemode());
        new Metrics(this, 18871);
    }

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
