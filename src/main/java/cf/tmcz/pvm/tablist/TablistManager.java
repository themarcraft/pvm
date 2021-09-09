package cf.tmcz.pvm.tablist;

import cf.tmcz.pvm.Main;
import cf.tmcz.pvm.utils.Config;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class TablistManager{

    private String header;

    public String getHeader() {
        Config config = Main.getInstance().getConfiguration();
            this.header = config.getConfig().getString("tablist.header");
        return header;
    }

    private String footer;

    public String getFooter() {
        Config config = Main.getInstance().getConfiguration();
            this.footer = config.getConfig().getString("tablist.footer");
        return footer;
    }

    public void setPlayerlist(Player player) {
        player.setPlayerListHeaderFooter(ChatColor.DARK_GRAY + "---------[" + ChatColor.GREEN + "Plugin von _TheMarCraft_" + ChatColor.DARK_GRAY + "]---------" + "§r\n" + getHeader().toString(), getFooter().toString() + "\n" + ChatColor.DARK_GRAY + "---------------[" + ChatColor.GREEN + "PVM v1.2" + ChatColor.DARK_GRAY + "]---------------");
    }

}
