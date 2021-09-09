package cf.tmcz.pvm;

import cf.tmcz.pvm.Chat.chatevents;
import cf.tmcz.pvm.commands.ChatClear;
import cf.tmcz.pvm.commands.TimerCommand;
import cf.tmcz.pvm.commands.pvm;
import cf.tmcz.pvm.join.JoinListener;
import cf.tmcz.pvm.tablist.TablistManager;
import cf.tmcz.pvm.timer.Timer;
import cf.tmcz.pvm.utils.Config;
import cf.tmcz.pvm.utils.TimerCfg;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    public static String pre;
    private static Main instance;
    private Timer timer;
    private Config config;
    private TimerCfg tt;
    private TablistManager tablistManager;
    Player player;

    @Override
    public void onLoad() {
        saveDefaultConfig();
        instance = this;
        config = new Config();
        tt = new TimerCfg();
    }


    @Override
    public void onEnable() {
        saveDefaultConfig();

        getCommand("timer").setExecutor(new TimerCommand());
        getCommand("ChatClear").setExecutor(new ChatClear());
        getCommand("pvm").setExecutor(new pvm());
        timer = new Timer();
        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new JoinListener(), this);
        tablistManager = new TablistManager();
        registerListeners();
        System.out.println("------------------");
        System.out.println("Plugin von Marvin");
        System.out.println("Aktiviert");
        System.out.println("------------------");

    }

    public void registerListeners(){
        Bukkit.getPluginManager().registerEvents(new chatevents() , this);
    }
    
    @Override
    public void onDisable() {
        System.out.println("Wird gespeichert...");
        tt.save();
        timer.save();
        System.out.println("Gespeichert");
        System.out.println("");
        System.out.println("");
        System.out.println("------------------");
        System.out.println("Plugin von Marvin");
        System.out.println("Deaktiviert");
        System.out.println("------------------");
    }
    public static Main getInstance() {
        return instance;
    }

    public Config getConfiguration() {
        return config;
    }

    public TimerCfg getTimertime() {
        return tt;
    }

    public Timer getTimer() {
        return timer;
    }

    public TablistManager getTablistManager() {
        return tablistManager;
    }
}
