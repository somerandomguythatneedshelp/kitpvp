package com.f2erg.vexcty.commands;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Calendar;

public class CMDHelp implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.sendMessage(ChatColor.GREEN + "If you need help like reporting a bug or and intro to the server,");
            try {
                wait(Calendar.SECOND, 3);
                player.sendMessage(ChatColor.GREEN + "Visit our website for help " + ChatColor.YELLOW + "www.vexcty.com.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        return false;
    }
}

