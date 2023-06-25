package pl.majlitech.shortengamemode;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Events implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        if (e.getPlayer().hasPermission(ConfigManager.get("permission-node"))) {
            e.getPlayer().sendMessage(ChatColor.RED+"[ShortenGamemode] The plugin is disabled. Please check console for details.");
        }
    }
}
