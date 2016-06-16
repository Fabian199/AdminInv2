package com.jimdo.Fabian996.AdminInv2.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jimdo.Fabian996.AdminInv2.Main.AdminInv;

public class Vanisch implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String l, String[] args) {
		if(!(cs instanceof Player)){
			cs.sendMessage(AdminInv.AdminPrefix  + AdminInv.NoPlayer);
			return true;
		}
		
		Player p = (Player)cs;
		if(cmd.getName().equalsIgnoreCase("v")){
			if(args.length == 0){
				if(p.hasPermission("admininv.vanish") || (p.hasPermission("admininv*"))){
					if(!AdminInv.Vanished.contains(p)){
						for(Player pl : Bukkit.getServer().getOnlinePlayers()){
							pl.hidePlayer(p);
						}
						AdminInv.Vanished.add(p);
						p.sendMessage(AdminInv.AdminPrefix + "§7Vanish ist nun §aAktiviert");
						return true;
					}
					for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
				        pl.showPlayer(p);
					}
					AdminInv.Vanished.remove(p);
					p.sendMessage(AdminInv.AdminPrefix + "§7Vanish ist nun §cDeaktiviert");
					return true;
				}
			}
		}
		return true;
	}
}
