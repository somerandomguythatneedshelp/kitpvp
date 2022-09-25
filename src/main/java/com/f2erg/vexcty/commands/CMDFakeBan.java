package com.f2erg.vexcty.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDFakeBan implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("f2erg.vexcty.admin")) {
                if (args.length > 0) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target != null) {
                        target.kickPlayer("You have been banned from this server.");
                    } else {
                        player.sendMessage(ChatColor.RED + "This player is not online");
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "Invaild Usage! Please use /fakeban <target>");
                }
            } else {
                player.sendMessage(ChatColor.RED + "You do not have permission to use that command.");
            }
        }
        return false;
    }
}


