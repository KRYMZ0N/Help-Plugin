package me.krymz0n.help.command;

import me.krymz0n.help.Main;
import me.krymz0n.help.util.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Reload implements CommandExecutor {
    private final Main plugin;

    public Reload(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args[0].toLowerCase().startsWith("reload")) {
            if (sender.isOp() || (!(sender instanceof Player))) {
                plugin.reloadConfig();
                sender.sendMessage(Utils.chat("&6Help Config Reloaded!"));
                return true;
            } else {
                sender.sendMessage(Utils.chat("&cYou do not have permission to execute this command!"));
            }
        }
        if (args[0].toLowerCase().startsWith("ver")) {
            sender.sendMessage(Utils.chat( "&6This server is currently running HelpPlugin &7v&6" + plugin.getDescription().getVersion()));
        }
        return false;
    }
}