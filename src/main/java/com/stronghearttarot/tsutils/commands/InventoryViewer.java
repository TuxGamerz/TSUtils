package com.stronghearttarot.tsutils.commands;

import com.stronghearttarot.tsutils.TSUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.UUID;

public class InventoryViewer implements CommandExecutor {

    private TSUtils plugin;

    public InventoryViewer(TSUtils instance) {
        plugin = instance;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("inv")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length == 2) {
                    UUID pID = UUID.fromString(args[0]);
                    Player targetPlayer = plugin.getServer().getPlayer(pID);
                    Inventory playerInv = targetPlayer.getInventory();
                    player.sendMessage(ChatColor.GREEN + "You are now viewing " + targetPlayer.getName() + "'s inventory.");
                    player.openInventory(playerInv);
                    return true;
                }
            }
        }
        return true;
    }

}
