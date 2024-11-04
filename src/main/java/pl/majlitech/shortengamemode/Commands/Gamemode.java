package pl.majlitech.shortengamemode.Commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.majlitech.shortengamemode.ConfigManager;
import pl.majlitech.shortengamemode.StringsManager;

import java.text.MessageFormat;

public class Gamemode implements CommandExecutor {
    public static String formatString(String template, Object... args) {
        for (int i = 0; i < args.length; i++) {
            String placeholder = "\\{" + i + "\\}";
            template = template.replaceAll(placeholder, String.valueOf(args[i]));
        }
        return template;
    }
    public static void setGamemode(CommandSender executor, Player target, GameMode gamemode) {
        String sGamemode;
        if (gamemode.equals(GameMode.SURVIVAL)) {sGamemode="survival";}
        else if (gamemode.equals(GameMode.CREATIVE)) {sGamemode="creative";}
        else if (gamemode.equals(GameMode.ADVENTURE)) {sGamemode="adventure";}
        else if (gamemode.equals(GameMode.SPECTATOR)) {sGamemode="spectator";}
        else {
            return;
        }
            if (!executor.hasPermission(ConfigManager.get("permission-node-"+sGamemode)) && Boolean.parseBoolean(ConfigManager.get("enable-specific-gamemode-permissions"))) {
                executor.sendMessage(MessageFormat.format(StringsManager.get("no-gamemode-permission"), StringsManager.get(sGamemode)));
                return;
            }
            if (executor instanceof Player) {
                Player test = (Player) executor;
                target.setGameMode(gamemode);
                if (test.equals(target)) {
                    target.sendMessage(MessageFormat.format(StringsManager.get("your-change-success"), StringsManager.getWithoutPrefix(sGamemode)));
                } else {
                    target.sendMessage(MessageFormat.format(StringsManager.get("change-notify"), StringsManager.getWithoutPrefix(sGamemode), test.getDisplayName()));
                    executor.sendMessage(
                            formatString(StringsManager.get("change-success"), StringsManager.getWithoutPrefix(sGamemode),target.getDisplayName())

                    );
                }
            } else {
                target.setGameMode(gamemode);
                target.sendMessage(MessageFormat.format(StringsManager.get("change-notify-console"), StringsManager.getWithoutPrefix(sGamemode)));
                executor.sendMessage(
                       formatString(StringsManager.get("change-success"), StringsManager.getWithoutPrefix(sGamemode),target.getDisplayName())
                );


            }

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        Player t;
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (!(p.hasPermission(ConfigManager.get("permission-node"))) && Boolean.parseBoolean(ConfigManager.get("enable-permissions"))) {
                p.sendMessage(StringsManager.get("no-permission"));
                return true;
            }
            if (args.length == 1) {
                t = p;
            } else if (args.length == 2) {
                t = Bukkit.getPlayer(args[1]);
                if (t == null) {
                    p.sendMessage(StringsManager.get("player-offline"));
                    return true;
                }
            } else {
                p.sendMessage(StringsManager.get("not-enough-args-or-too-many"));
                return true;

            }

        } else {
            if (!(args.length == 2)) {
                sender.sendMessage(MessageFormat.format(StringsManager.get("not-enough-args-console"), command.getName()));
                return true;
            }
            t = Bukkit.getPlayer(args[1]);
            if (t == null) {
                sender.sendMessage(StringsManager.get("player-offline"));
                return true;
            }
        }
        switch (args[0]) {
            case "0":
            case "survival":
                setGamemode(sender, t, GameMode.SURVIVAL);
                return true;
            case "1":
            case "creative":
                setGamemode(sender, t, GameMode.CREATIVE);
                return true;
            case "2":
            case "adventure":
                setGamemode(sender, t, GameMode.ADVENTURE);
                return true;
            case "3":
            case "spectator":
                setGamemode(sender, t, GameMode.SPECTATOR);
                return true;

        }
        for (String alias:
        ConfigManager.getLists("survival-aliases")) {
            if (alias.equals(args[0])) {
                setGamemode(sender,t,GameMode.SURVIVAL);
                return true;
            }
        }
        for (String alias:
                ConfigManager.getLists("creative-aliases")) {
            if (alias.equals(args[0])) {
                setGamemode(sender,t,GameMode.CREATIVE);
                return true;
            }
        }
        for (String alias:
                ConfigManager.getLists("adventure-aliases")) {
            if (alias.equals(args[0])) {
                setGamemode(sender,t,GameMode.ADVENTURE);
                return true;
            }
        }
        for (String alias:
                ConfigManager.getLists("spectator-aliases")) {
            if (alias.equals(args[0])) {
                setGamemode(sender,t,GameMode.SPECTATOR);
                return true;
            }
        }
        sender.sendMessage();
        return true;
    }
}
