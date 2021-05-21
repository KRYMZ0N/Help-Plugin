package me.krymz0n.help.command;

import me.krymz0n.help.Main;
import me.krymz0n.help.util.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Help implements Listener {
    private final Main plugin;

    public Help(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onCommandPreprocess(PlayerCommandPreprocessEvent evt) {
        Player p = evt.getPlayer();
        if (evt.getMessage().equalsIgnoreCase("/help")) {
            plugin.getConfig().getList("Help").forEach(b -> p.sendMessage(Utils.chat((String) b)));
        }
    }
}
