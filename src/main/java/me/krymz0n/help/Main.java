package me.krymz0n.help;

import me.krymz0n.help.command.Help;
import me.krymz0n.help.command.Reload;
import me.krymz0n.help.util.Utils;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        System.out.println("  _    _      _       \n" +
                " | |  | |    | |      \n" +
                " | |__| | ___| |_ __  \n" +
                " |  __  |/ _ \\ | '_ \\ \n" +
                " | |  | |  __/ | |_) |\n" +
                " |_|  |_|\\___|_| .__/ \n" +
                "               | |    \n" +
                "               |_|  ");
        System.out.println(Utils.chat("&6Enabling Help Plugin by &4KRYMZ0N!"));
        System.out.println(Utils.chat("&6Registering Events!"));
        PluginManager pm = getServer().getPluginManager();

        pm.registerEvents(this, this);
        pm.registerEvents(new Help(this), this);

        getCommand("helpplugin").setExecutor(new Reload(this));
    }

    @Override
    public void onDisable() {
        System.out.println(Utils.chat("&6Disabling Help plugin by &4KRYMZ0N"));
    }
}
