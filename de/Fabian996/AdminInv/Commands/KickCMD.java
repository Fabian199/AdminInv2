package de.Fabian996.AdminInv.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KickCMD implements CommandExecutor {
	
	public static final String Prefix = "§8[§4AdminInv§8]§r ";
	
	Player target;
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		Player p = (Player)cs;
		if(cmd.getName().equalsIgnoreCase("kick")){
			if(p.hasPermission("AdminInv.Kick")){
				if(args.length == 0){
					cs.sendMessage(Prefix + "Use: §6/kick §3<player> [reason]");
				}else if(args.length == 1){
					this.target = p.getServer().getPlayer(args[0]);
					this.target.kickPlayer("§4You were kicked!");
					Bukkit.getServer().broadcastMessage(Prefix + args[0] + " §5it was kicked!");
				}
				
				if(args.length >1){
					this.target = p.getServer().getPlayer(args[0]);
					this.target.kickPlayer("§aYou were kicked with the reason: §4" + args[1]);
					Bukkit.getServer().broadcastMessage(Prefix + args[0] + " §5it was kicked!");
				}
			}
		}
		return false;
	}

}
