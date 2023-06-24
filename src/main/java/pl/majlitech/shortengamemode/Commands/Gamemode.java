package pl.majlitech.shortengamemode.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.majlitech.shortengamemode.ConfigManager;
import pl.majlitech.shortengamemode.LanguageManager;

public class Gamemode implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (!(sender instanceof Player && !(args.length ==2))) {
            sender.sendMessage(String.format(LanguageManager.get("not-enough-args-console"), command.getName()));
            return true;
        }
        Player p = (Player) sender;
        p.sendMessage(String.valueOf(p.hasPermission(ConfigManager.get("permission-node"))));
        if ((p.hasPermission(ConfigManager.get("permission-node"))) || !Boolean.parseBoolean(ConfigManager.get("enable-permissions"))) {
            p.sendMessage(LanguageManager.get("no-permission"));
            return true;
        }

        return true;
    }
}
