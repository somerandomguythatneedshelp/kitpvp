package com.f2erg.vexcty.commands;

import com.f2erg.vexcty.Methods;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class CMDKaboomChaos implements CommandExecutor {

    @EventHandler
    public void onPlayerDamage(EntityDamageEvent e) {
        if (e.getCause() == DamageCause.FALL) {
            e.setCancelled(true);
        }

    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("kaboom")) {
            if (!sender.hasPermission("f2erg.vexcty.admin")) {
                sender.sendMessage(ChatColor.RED + "You do not have permission to use this command.");
            } else {
                if (command.getName().equalsIgnoreCase("kaboom")) {
                    if (args.length == 0) {

                        Methods m = new Methods();
                        for (Player players : Bukkit.getOnlinePlayers()) {
                            m.chaos(players);
                        }
                    } else {
                        Player target = Bukkit.getPlayerExact(args[0]);
                        if (target != null) {
                            Methods m = new Methods();
                            m.chaos(target);
                        } else {
                            sender.sendMessage(ChatColor.RED + "This player is not online.");
                        }
                    }
                }

            }
        }
        return false;
    }

}
