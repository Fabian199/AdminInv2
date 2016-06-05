package com.jimdo.Fabian996.AdminInv2.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jimdo.Fabian996.AdminInv2.Main.AdminInv;

public class TeamChat implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		Player p = (Player)cs;
		if(cmd.getName().equalsIgnoreCase("tc")){
			if(p.hasPermission("admininv.tc") || (p.hasPermission("admininv.*"))){
				if(args.length != 0){
					String Message = "";
					for(int i = 0; i < args.length; i++){
						Message = Message + " " + args[i];
					}
					for(Player target : Bukkit.getOnlinePlayers()){
						if(target.hasPermission("admininv.tc") || (target.hasPermission("admininv.*"))){
							Message = ChatColor.translateAlternateColorCodes('&', Message);
							target.sendMessage(AdminInv.TeamChatPrefix + "§c" + p.getDisplayName() + " §6>>§f "  + Message);
						}
					}
				}
			}
		}
		return true;
	}
}
