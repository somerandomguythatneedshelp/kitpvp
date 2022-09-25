package com.f2erg.vexcty.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDSpeed implements CommandExecutor {

    public CMDSpeed() {

    }

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("Player only command!");
            return false;
        }
        Player p = (Player) commandSender;
        if (!p.hasPermission("f2erg.vexcty.admin")) {
            p.sendMessage(ChatColor.RED + "You don't have permission to use this command.");
            return false;
        }
        if (strings.length == 0) {
            p.sendMessage(ChatColor.RED + "&cPlease provide a speed from 1 - 10.");
            return false;
        }
        int speed;
        try {
            speed = Integer.parseInt(strings[0]);
        } catch (NumberFormatException e) {
            p.sendMessage(ChatColor.RED + "&cPease provide a speed from 1 - 10.");
            return false;
        }
        if (speed < 1 || speed > 10) {
            p.sendMessage(ChatColor.RED + "&cPease provide a speed from 1 - 10.");
            return false;
        }
        if (p.isFlying()) {
            p.setFlySpeed((float) speed / 10);
        } else {
            p.setWalkSpeed((float) speed/ 10);
        }
        p.sendMessage(ChatColor.GREEN + "&aSpeed set to &b" + speed + ".");
        return true;
    }

}


