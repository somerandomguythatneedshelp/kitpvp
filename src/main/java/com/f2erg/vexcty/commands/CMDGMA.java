package com.f2erg.vexcty.commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDGMA implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("f2erg.vexcty.admin")) {
                if (player.getGameMode() == GameMode.ADVENTURE) {
                    player.sendMessage(ChatColor.RED + "You are already in ADVENTURE");
                } else {
                    player.sendMessage(ChatColor.GREEN + "Your gamemode has been updated to " + ChatColor.YELLOW + "ADVENTURE");
                }
            } else {
                player.sendMessage(ChatColor.RED + "You do not have permission to use that command.");
            }
        }
        return false;
    }

}
