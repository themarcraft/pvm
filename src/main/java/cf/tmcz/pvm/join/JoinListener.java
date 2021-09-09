package cf.tmcz.pvm.join;

import cf.tmcz.pvm.Main;
import cf.tmcz.pvm.utils.Config;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
// import cf.tmcz.pvm.scoreboard.TestScoreboard;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    Player player;

    private String joinmsg;



    @EventHandler
    public void onJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();



        event.setJoinMessage(getJoin().toString());

        player.sendMessage(ChatColor.GOLD + "Dein Text" + "\n" + ChatColor.GREEN + "PVM v1.2");

        Main.getInstance().getTablistManager().setPlayerlist(player);

        System.out.println(player.getName() + "ist dem Server beigetreten");

        // new TestScoreboard(player);

        Main.getInstance().getTablistManager().setPlayerlist(player);
    }

    private String getJoin() {
        Config config = Main.getInstance().getConfiguration();
        this.joinmsg = config.getConfig().getString("messages.join");
        this.joinmsg =  joinmsg.replace("#player#", player.getDisplayName());
        return joinmsg;
    }

}
