package com.f2erg.vexcty.commands;

// name is CMDCanhaveadminrank

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CMDCIHAR implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        sender.sendMessage(ChatColor.GREEN + "You can apply for admin rank at our website apply.vexcty.com.");
        return false;
    }
}

