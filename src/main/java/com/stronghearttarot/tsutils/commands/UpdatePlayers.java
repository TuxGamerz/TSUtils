package com.stronghearttarot.tsutils.commands;

import com.stronghearttarot.tsutils.TSUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class UpdatePlayers implements CommandExecutor {
    /**
     * This command will:
     * grab the names of the players currently on the server and insert
     * them into a txt file so my web server can read the names of the players
     * on the server and display them. The web server will also generate stats
     * for each player. e.g Time Played, average maximum time played and average block collection
     */

    private TSUtils plugin;
    private FileConfiguration fConfig;
    private File fConfigFile;

    public UpdatePlayers(TSUtils instance) {
        plugin = instance;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("plupdate")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                player.sendMessage(ChatColor.GREEN + "Updating player stats");
                updateFile();
            }
        }
        return false;
    }

    public void updateFile() {
        StringBuilder sBuilder = new StringBuilder();
        Player[] players = plugin.getServer().getOnlinePlayers();
        for (Player player : players) {
            sBuilder.append(player.getName());
        }
    }
}
