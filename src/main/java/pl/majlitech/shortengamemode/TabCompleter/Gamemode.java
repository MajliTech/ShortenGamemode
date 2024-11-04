package pl.majlitech.shortengamemode.TabCompleter;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import pl.majlitech.shortengamemode.ConfigManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Gamemode implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        List<String> data = Collections.emptyList();
        if (!commandSender.hasPermission(ConfigManager.get("permission-node"))) {
             return data;
        }
        if (strings.length==1) {
            data = Arrays.asList("survival","creative","adventure","spectator");
        } else {
            data = new ArrayList<>();
            if (strings.length==2) {
                List<String> finalData = data;
                Bukkit.getOnlinePlayers().forEach(player -> {
                    if (player.getName().startsWith(strings[1])) {
                        finalData.add(player.getName());
                    }
                });
            }
        }
        return data;
//        return Collections.emptyList();
    }
}
