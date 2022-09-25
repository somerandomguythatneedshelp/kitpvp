package com.f2erg.vexcty.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDHeal implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("f2erg.vexcty.admin")) {
               player.setHealth(20);
            } else {
                player.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
            }
        }
        return true;
    }


}
