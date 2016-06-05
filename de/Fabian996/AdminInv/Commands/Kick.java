package com.jimdo.Fabian996.AdminInv2.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jimdo.Fabian996.AdminInv2.Main.AdminInv;

public class Kick implements CommandExecutor{
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		Player p = (Player)cs;
		Player target = Bukkit.getPlayer(args[0]);
		String KickMessage = AdminInv.cfg.getString("Message.KickMessage");
		KickMessage = KickMessage.replace("%target%", target.getName());
		if(cmd.getName().equalsIgnoreCase("kick")){
			if(p.hasPermission("admininv.kick") || p.hasPermission("admininv.*")){
				if(args.length == 0){
					p.sendMessage(AdminInv.AdminPrefix + "Nutze: §3/kick §7<§5Spieler§7> §8[§6Grund§8]"); 
					return true;
				}else if(args.length == 1){
					target = p.getServer().getPlayer(args[0]);
					target.kickPlayer(ChatColor.translateAlternateColorCodes('&', KickMessage));
					Bukkit.getServer().broadcastMessage(AdminInv.AdminPrefix + ChatColor.translateAlternateColorCodes('&', KickMessage));
				}
				if(args.length >1){
					String Reason = "";
					for(int i = 1; i < args.length; i++){
						Reason = Reason + args[i] + " ";
					}
					target = p.getServer().getPlayer(args[0]);
					target.kickPlayer("§6" + target.getName() +  " §rwürde vom Server gekickt" + "\n§2Grund: §4" + Reason);
					Bukkit.getServer().broadcastMessage(AdminInv.AdminPrefix + ChatColor.translateAlternateColorCodes('&', KickMessage) + "\n" + AdminInv.AdminPrefix + "§2Grund: §4" + Reason);
				}
			}
		}
		return true;
	}
}
