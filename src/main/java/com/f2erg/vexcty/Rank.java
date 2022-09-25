package com.f2erg.vexcty;

import org.bukkit.ChatColor;

public enum Rank {

    OWNER(ChatColor.DARK_RED + "[Owner]"),
    ADMIN(ChatColor.RED + "[Admin]"),
    MOD(ChatColor.DARK_GREEN + "[Moderator]"),
    TWITCH(ChatColor.LIGHT_PURPLE + "[Twitch]"),
    TMOD(ChatColor.LIGHT_PURPLE + "[Trial Mod]"),
    HELPER(ChatColor.BLUE + "[Helper]"),
    YT(ChatColor.RED + "[" + ChatColor.WHITE + "YouTube" + ChatColor.RED + "]"),
    MEMBER(ChatColor.YELLOW + "[Member]"),
    GOD(ChatColor.BLUE + "[GOD]"),
    LEGEND(ChatColor.BLACK + "[Legend]"),
    MVP(ChatColor.AQUA + "[MVP]"),
    MVPP(ChatColor.GOLD + "[MVP" + ChatColor.GREEN + "+" + ChatColor.GOLD + "]"),
    VIP(ChatColor.GREEN + "[VIP]"),
    VIPP(ChatColor.GREEN + "[VIP" + ChatColor.BLUE + "+" + ChatColor.GREEN + "]"),
    NEWBIE(ChatColor.GRAY + "[Newbie]");


    private String display;


    Rank(String display) {
        this.display = display;
    }
    public String getDisplay() { return display; }

}
