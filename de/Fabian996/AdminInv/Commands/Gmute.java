package com.jimdo.Fabian996.AdminInv2.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jimdo.Fabian996.AdminInv2.Main.AdminInv;

public class GMute implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		Player p = (Player)cs;
		if(!(cs instanceof Player)){
			cs.sendMessage(AdminInv.AdminPrefix + AdminInv.NoPlayer);
		}
		if(args.length == 0){
			if(p.hasPermission("admininv.globalmute") || (p.hasPermission("admininv.*"))){
				if(!AdminInv.mute){
					Bukkit.broadcastMessage(AdminInv.AdminPrefix + "§7Der Globale Mute ist §2Aktive§7!");
					AdminInv.mute = true;
				}else{
					Bukkit.broadcastMessage(AdminInv.AdminPrefix + "§7Der Globele Mute ist §cNicht Aktive§7!");
					AdminInv.mute = false;
				}
			}else{
				cs.sendMessage(AdminInv.AdminPrefix +  AdminInv.NoPerm);
			}
		}
		return true;
	}
}
