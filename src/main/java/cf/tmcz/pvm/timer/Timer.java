package cf.tmcz.pvm.timer;

import cf.tmcz.pvm.utils.TimerCfg;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import cf.tmcz.pvm.Main;

public class Timer {

    private boolean running; // true or false
    private int time;

    public Timer() {
        TimerCfg tt = Main.getInstance().getTimertime();

        this.running = false;

        if (tt.getTime().contains("timer.time")) {
            this.time = tt.getTime().getInt("timer.time");
        } else {
            this.time = 0;
        }

        run();
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void sendActionBar() {
        for (Player player : Bukkit.getOnlinePlayers()) {

            if (!isRunning()) {
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GOLD +
                        "Timer ist pausiert"));
                continue;
            }

            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GOLD.toString() +
                    ChatColor.BOLD + getTime()));
        }
    }

    public void save() {
        TimerCfg tt = Main.getInstance().getTimertime();

        tt.getTime().set("timer.time", time);

        tt.save();
    }

    private void run() {
        new BukkitRunnable() {
            @Override
            public void run() {

                sendActionBar();

                if (!isRunning()) {
                    return;
                }

                setTime(getTime() + 1);
            }
        }.runTaskTimer(Main.getInstance(), 20, 20);
    }
}