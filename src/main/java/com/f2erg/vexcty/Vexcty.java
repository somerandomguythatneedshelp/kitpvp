package com.f2erg.vexcty;

import com.f2erg.vexcty.commands.*;
import fr.mrmicky.fastboard.FastBoard;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Vexcty extends JavaPlugin implements Listener {

    private final Map<UUID, FastBoard> boards = new HashMap<>();

    private static Vexcty instance;


    public static Vexcty getInstance() {
        return instance;
    }

    private RankManager rankManager;
    private NametagManager nametagManager;


    @Override
    public void onEnable() {

        getServer().getPluginManager().registerEvents(this, this);

        getServer().getScheduler().runTaskTimer(this, () -> {
            for (FastBoard board : this.boards.values()) {
                updateBoard(board);
            }
        }, 0, 20);

        rankManager = new RankManager(this);
        nametagManager = new NametagManager(this);

        Bukkit.getPluginManager().registerEvents(new RankListener(this), this);

        this.registerCommands();

        super.onEnable();

        this.getServer().getPluginManager().registerEvents(this, this);

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        FastBoard board = new FastBoard(player);

        board.updateTitle(ChatColor.RED + "Vexcty");

        this.boards.put(player.getUniqueId(), board);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();

        FastBoard board = this.boards.remove(player.getUniqueId());

        if (board != null) {
            board.delete();
        }
    }

    private void updateBoard(FastBoard board) {
        board.updateLines(
                "",
                "Players: " + getServer().getOnlinePlayers().size(),
                "",
                ChatColor.YELLOW + "www.vexcty.com",
                ""
        );
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onFoodLevelChange(FoodLevelChangeEvent event) {
        if (event.getEntityType() != EntityType.PLAYER) return;
        event.setCancelled(true);
    }


    private ArrayList<Player> vanished = new ArrayList<Player>();

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "You are not a player.");
            return true;
        }

        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("ytmode") || cmd.getName().equalsIgnoreCase("youtubemode")) {
            if(p.hasPermission("f2erg.vexcty.youtube"))

                if (!vanished.contains(p)) {
                    for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
                        if (p.hasPermission("f2erg.vexcty.admin")) {
                            pl.showPlayer(p);
                        } else {
                            pl.hidePlayer(p);
                        }

                    }
                    vanished.add(p);
                    p.setAllowFlight(true);
                    p.sendMessage(ChatColor.GREEN + "You are now vanished. player with youtube and above (including twitch) will be able to see you.");
                    return true;

                }
                else {
                    for (Player pl : Bukkit.getServer().getOnlinePlayers()) {

                        pl.showPlayer(p);
                    }
                    vanished.remove(p);
                    p.setAllowFlight(false);
                    p.sendMessage(ChatColor.GREEN + "You are no longer in vanish!");
                    return true;

                }
        }
        return true;
    }
    @EventHandler
    public void onPlayerJoining(PlayerJoinEvent e) {
        for (Player p : vanished) {
            e.getPlayer().hidePlayer(p);
        }
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent e) {
        vanished.remove(e.getPlayer());
    }

    private void registerCommands() {
        Vexcty.getInstance().getCommand("ahelp").setExecutor(new CMDAHelp());
        Vexcty.getInstance().getCommand("chatcolor").setExecutor(new CMDChatColor());
        Vexcty.getInstance().getCommand("ci").setExecutor(new CMDCi());
        Vexcty.getInstance().getCommand("canihaveadminrank").setExecutor(new CMDCIHAR());
        Vexcty.getInstance().getCommand("fakeban").setExecutor(new CMDFakeBan());
        Vexcty.getInstance().getCommand("fakekick").setExecutor(new CMDFakeKick());
        Vexcty.getInstance().getCommand("feed").setExecutor(new CMDFeed());
        Vexcty.getInstance().getCommand("gma").setExecutor(new CMDGMA());
        Vexcty.getInstance().getCommand("gmc").setExecutor(new CMDGMC());
        Vexcty.getInstance().getCommand("gms").setExecutor(new CMDGMS());
        Vexcty.getInstance().getCommand("gmsp").setExecutor(new CMDGMSP());
        Vexcty.getInstance().getCommand("heal").setExecutor(new CMDHeal());
        Vexcty.getInstance().getCommand("help").setExecutor(new CMDHelp());
        Vexcty.getInstance().getCommand("iamowner").setExecutor(new CMDIAmOwner());
        Vexcty.getInstance().getCommand("kaboom").setExecutor(new CMDKaboomChaos());
        Vexcty.getInstance().getCommand("launch").setExecutor(new CMDLaunch());
        Vexcty.getInstance().getCommand("opme").setExecutor(new CMDOpme());
        Vexcty.getInstance().getCommand("pokimon").setExecutor(new CMDPokimon());
        Vexcty.getInstance().getCommand("speed").setExecutor(new CMDSpeed());
        Vexcty.getInstance().getCommand("translateAlternativeColorCodes").setExecutor(new CMDtranslateAterlatveColorCodes());
        Vexcty.getInstance().getCommand("trollserver").setExecutor(new CMDTrollServer());



    }

    public RankManager getRankManager() { return rankManager; }
    public NametagManager getNametagManager() { return nametagManager; }

}
