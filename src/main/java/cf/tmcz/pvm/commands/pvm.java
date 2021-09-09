package cf.tmcz.pvm.commands;

import com.sun.org.apache.xpath.internal.Arg;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class pvm implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player p = (Player) sender;
        if(args.length == 0) {
            sendUsage(sender);
            return true;
        }
        switch (args[0].toLowerCase()) {
            case "info": {
                p.sendMessage(ChatColor.GREEN + "Dieses Plugin ist von Marvin aka _TheMarCraft_ mit ca. 5 Stunden Arbeitszeit programmiert worden. Ich wünsche dir viel Spaß damit.");
                break;
            }
            case "help": {
                if(args.length == 2) {
                    switch (args[1].toLowerCase()) {
                        case "timer": {
                            p.sendMessage(ChatColor.GRAY + "Verwendung" + ChatColor.DARK_GRAY + ": " + ChatColor.DARK_RED +
                                    "/timer resume, /timer pause, /timer time <Zeit>, /timer reset, /timer info" + "Permission: " + ChatColor.DARK_RED + "cf.tmcz.timer");
                            break;
                        }
                        case "spieler": {
                            p.sendMessage("§aOnline Spieler:");
                            Bukkit.getOnlinePlayers().forEach(on -> p.sendMessage(on.getName()));
                            break;
                        }
                    }
                } else {
                    p.sendMessage("/help <timer|spieler>");
                }
                break;
            }
            case "say": {
                p.kickPlayer("§c§lGEBANNT\n" + "§e§lGrund: §r§7" + args[1+2+3]);
                break;
            }
            default:
                sendUsage(sender);
                break;
        }

        return false;
    }

    private void sendUsage(CommandSender sender) {
        sender.sendMessage(ChatColor.GRAY + "Verwendung" + ChatColor.DARK_GRAY + ": " + ChatColor.DARK_RED +
                "/pvm info, /pvm help <info|me>" + ChatColor.GREEN + "\n" + ChatColor.GRAY + "Permission: " + ChatColor.DARK_RED + "cf.tmcz.timer");
    }
}
