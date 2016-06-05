package com.jimdo.Fabian996.AdminInv2.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jimdo.Fabian996.AdminInv2.Main.AdminInv;

public class ClearChat implements CommandExecutor{
	
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args){
		if((cs instanceof Player)){
			Player p = (Player)cs;
			if(cmd.getName().equalsIgnoreCase("cc")){
				if(p.hasPermission("admininv.cc") || (p.hasPermission("admininv.*"))){
					for(Player target : Bukkit.getOnlinePlayers()){
						for(int i = 0 ; i < 120; i++){
							target.sendMessage(" ");
						}
						target.sendMessage(AdminInv.AdminPrefix + "§7Der Chat würde gelöscht durch §6" + p.getName());
					}
				}
			}
		}
		return true;
	}
}
