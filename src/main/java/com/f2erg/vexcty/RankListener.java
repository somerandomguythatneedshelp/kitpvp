package com.f2erg.vexcty;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class RankListener implements Listener {

    private Vexcty main;

    public RankListener(Vexcty main) {
        this.main = main;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        if (!player.hasPlayedBefore()) {
            main.getRankManager().setRank(player.getUniqueId(), Rank.NEWBIE, true);
        }

        main.getNametagManager().setNametags(player);
        main.getNametagManager().newTag(player);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        main.getNametagManager().removeTag(e.getPlayer());
    }


    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {

        Player player = e.getPlayer();

        String format = main.getRankManager().getRank(player.getUniqueId()).getDisplay() + " " + player.getName() + "»" + e.getMessage();

        e.setFormat(format + ": " + e.getMessage());

    }
}
