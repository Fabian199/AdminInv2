package de.Fabian996.AdminInv.Commands;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class KickCMD implements CommandExecutor {
	
	public static final String Prefix = "§8[§4AdminInv§8]§r ";
	private File file = new File("plugins/AdminInv", "config.yml");
	private FileConfiguration cfg = YamlConfiguration.loadConfiguration(this.file);

	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		Player p = (Player)cs;
		Player target = Bukkit.getPlayer(args[0]);
		String KickMessage = cfg.getString("Message.KickMessage");
		KickMessage = KickMessage.replace("%target%", target.getDisplayName());
		if(cmd.getName().equalsIgnoreCase("kick")){
			if(p.hasPermission("AdminInv.Kick") || p.hasPermission("AdminInv.*")){
				if(args.length == 0){
					p.sendMessage(Prefix + "Use: §6/kick §7<player> §8[reason]"); 
					return true;
				}else if(args.length == 1){
					target = p.getServer().getPlayer(args[0]);
					target.kickPlayer(ChatColor.translateAlternateColorCodes('&', KickMessage));
					Bukkit.getServer().broadcastMessage(Prefix + ChatColor.translateAlternateColorCodes('&', KickMessage));
				}
				if(args.length >1){
					String Reason = "";
					for(int i = 1; i < args.length; i++){
						Reason = Reason + args[i] + " ";
					}
					target = p.getServer().getPlayer(args[0]);
					target.kickPlayer(KickMessage + "\n§3Reason: §4" + Reason);
					Bukkit.getServer().broadcastMessage(Prefix + ChatColor.translateAlternateColorCodes('&', KickMessage) + "\n" + Prefix + "§2Reason: §4" + Reason);
				}
			}
		}
		return false;
	}
}
