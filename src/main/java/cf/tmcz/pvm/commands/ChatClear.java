package cf.tmcz.pvm.commands;

import cf.tmcz.pvm.Main;
import cf.tmcz.pvm.utils.Config;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatClear implements CommandExecutor {

    private String msg;

    public String getMessage() {
        Config config = Main.getInstance().getConfiguration();
            this.msg = config.getConfig().getString("messages.chatclear");
        return msg;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;
        if(!p.hasPermission("cf.tmcz.pvm.cc")) {
            p.sendMessage(ChatColor.RED + "Dazu hast du keine Rechte");
        } else {
            for (int i= 0; i < 105; ++i) {
                for (Player all : Bukkit.getOnlinePlayers()) {
                    if(!all.hasPermission("cf.tmcz.pvm.cc")) {
                        all.sendMessage("");
                    } else {
                        all.sendMessage("");
                    }
                }
            }

            Bukkit.broadcastMessage(getMessage());
            return true;
        }


        return false;
    }
}
