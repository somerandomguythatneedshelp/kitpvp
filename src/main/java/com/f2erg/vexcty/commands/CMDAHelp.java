package com.f2erg.vexcty.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDAHelp implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("f2erg.vexcty.admin")) {
                if (args.length == 0) {
                    if (args[0].equalsIgnoreCase("commands")) {
                        player.sendMessage(ChatColor.GREEN + "The available commands for this plugin are:");
                        player.sendMessage(ChatColor.GREEN + "- /admincp | displays admin control panel");
                        player.sendMessage(ChatColor.GREEN + "- /afk | makes a player afk");
                        player.sendMessage(ChatColor.GREEN + "- /ahelp | shows this list");
                        player.sendMessage(ChatColor.GREEN + "- /cihar | fun command");
                        player.sendMessage(ChatColor.GREEN + "- /cc | clearchat");
                        player.sendMessage(ChatColor.GREEN + "- /fakeban | fun command for admins");
                        player.sendMessage(ChatColor.GREEN + "- /fakekick | fun command for admins");
                        player.sendMessage(ChatColor.GREEN + "- /feed | feed player");
                        player.sendMessage(ChatColor.GREEN + "- /gm | displays all gamemodes");
                        player.sendMessage(ChatColor.GREEN + "- /gma | sets your gamemode to adventure");
                        player.sendMessage(ChatColor.GREEN + "- /gmc | sets your gamemode to creative");
                        player.sendMessage(ChatColor.GREEN + "- /gms | sets your gamemode to survival");
                        player.sendMessage(ChatColor.GREEN + "- /gmsp | sets your gamemode to spectator");
                        player.sendMessage(ChatColor.GREEN + "- /heal | heal player");
                        player.sendMessage(ChatColor.GREEN + "- /help | player help menu");
                        player.sendMessage(ChatColor.GREEN + "- /iamowner | fin command");
                        player.sendMessage(ChatColor.GREEN + "- /isafk | check to see if anyone is afk");
                        player.sendMessage(ChatColor.GREEN + "- /kaboom | fun command for admins");
                        player.sendMessage(ChatColor.GREEN + "- /opme | fun command");
                        player.sendMessage(ChatColor.GREEN + "- /pokimon | fun command");
                        player.sendMessage(ChatColor.GREEN + "- /speed | set fly of walk speed");
                        player.sendMessage(ChatColor.GREEN + "- /trollserver | trolls the server");
                    } else if (args[0].equalsIgnoreCase("listeners")) {
                        player.sendMessage(ChatColor.GREEN + "The available Listeners for this plugin are:");
                        player.sendMessage(ChatColor.GREEN + "- GUIMoveItem | part of admin cp");
                        player.sendMessage(ChatColor.GREEN + "- Listener | allows Vexcty to remove all of the join and leave messages and more");
                    }
                } else {
                    player.sendMessage(ChatColor.RED + "Invalid Usage! Please use /ahelp <commands, listeners>");
                }
            } else {
                player.sendMessage(ChatColor.RED + "You don't have permission to use this command.");
            }
        }
        return false;
    }
}
