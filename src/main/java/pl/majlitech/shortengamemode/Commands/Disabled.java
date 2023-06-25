package pl.majlitech.shortengamemode.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import pl.majlitech.shortengamemode.ConfigManager;

public class Disabled implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender e, Command command, String s, String[] strings) {
        if (e.hasPermission(ConfigManager.get("permission-node"))) {
            e.sendMessage(ChatColor.RED + "[ShortenGamemode] The plugin is disabled. Please check console for details.");
        } else {
            e.sendMessage(ConfigManager.get("no-permission"));
        }
        return true;
    }
}

