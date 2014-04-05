package com.stronghearttarot.tsutils;

import com.stronghearttarot.tsutils.commands.InventoryViewer;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class TSUtils extends JavaPlugin {

    protected Logger log = Bukkit.getLogger();
    private boolean enabled = true;

    public void onEnable() {
        getCommand("tsswitch").setExecutor(this);
        getCommand("inv").setExecutor(new InventoryViewer(this));
    }

    public void onDisable() {
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("tsswitch")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (!enabled) {
                    enabled = true;
                    player.sendMessage("Plugin enabled");
                } else {
                    enabled = false;
                    player.sendMessage("Plugin disabled");
                }
            }
        }
        return true;
    }

}
