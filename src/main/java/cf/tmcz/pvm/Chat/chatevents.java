package cf.tmcz.pvm.Chat;

import org.bukkit.event.Listener;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class chatevents implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {

        if (e.getPlayer().isOp()) {
            e.setFormat(ChatColor.DARK_RED + "Owner | " + ChatColor.GRAY + e.getPlayer().getName() + " " + ChatColor.DARK_GRAY + "» " + ChatColor.GRAY + ChatColor.translateAlternateColorCodes('&' , e.getMessage()));
        }else{
            e.setFormat(ChatColor.GRAY + "Spieler | " + ChatColor.GRAY + e.getPlayer().getName() + " " + ChatColor.DARK_GRAY + "» " + ChatColor.GRAY + ChatColor.translateAlternateColorCodes('&' , e.getMessage()));
        }
    }
}

