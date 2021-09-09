package cf.tmcz.pvm.scoreboard;

import cf.tmcz.pvm.Main;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import cf.tmcz.pvm.utils.Config;

public class TestScoreboard extends cf.tmcz.pvm.scoreboard.ScoreboardBuilder {

    private int socialId;



    public TestScoreboard(Player player) {
        super(player, ChatColor.DARK_GRAY + "---------[" + ChatColor.DARK_PURPLE + "PVM v1.2" + ChatColor.DARK_GRAY + "]---------");
        socialId = 0;

        run();
    }

    @Override
    public void createScoreboard() {
        setScore("test", 9);
        setScore(ChatColor.DARK_GRAY.toString(), 8);
        setScore(ChatColor.GRAY + "Dein Rang" + ":", 7);

        if(player.isOp()) {
            setScore(ChatColor.DARK_RED + "ADMIN", 6);
        } else {
            setScore(ChatColor.GRAY + "Spieler", 6);
        }

        setScore(ChatColor.GRAY.toString(), 5);
        setScore(ChatColor.AQUA + "tmcz.cf", 4);
        setScore(ChatColor.RED.toString(), 3);
        setScore(ChatColor.GRAY.toString() + "Dein Name:", 2);
        setScore(ChatColor.GREEN + player.getName(), 1);
        setScore(ChatColor.AQUA.toString(), 0);
    }

    @Override
    public void update() {

    }

    private void run() {
        new BukkitRunnable() {
            @Override
            public void run() {

                switch (socialId) {
                    case 0:
                        setScore(ChatColor.AQUA + "tmcz.cf", 4);
                        break;
                    case 1:
                        setScore(ChatColor.DARK_PURPLE + "tmcz.grasshopper-design.de", 4);
                        break;
                    case 2:
                        setScore(ChatColor.DARK_RED + "Dein Text", 4);
                        break;
                }

                socialId++;

                if(socialId >= 5) {
                    socialId = 0;
                }

            }
        }.runTaskTimer(Main.getInstance(), 50, 50);
    }
}
