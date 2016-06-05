package com.jimdo.Fabian996.AdminInv2.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jimdo.Fabian996.AdminInv2.API.BroadcastAPI;
import com.jimdo.Fabian996.AdminInv2.Main.AdminInv;

public class Broadcast implements CommandExecutor{

	private String  cmdHelp = "Nutze: §3/br §7<§5Nachricht§7>";
	
	@SuppressWarnings("unused")
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("br")){
			Player p = (Player)cs;
			if(cs.hasPermission("admininv.broadcast") || (cs.hasPermission("admininv.*"))){
				if(!(cs instanceof Player)){
					cs.sendMessage(AdminInv.NoPlayer);
					return true;
				}
				if(args.length == 0){
					cs.sendMessage(AdminInv.AdminPrefix + cmdHelp);
					return true;
				}
				
				StringBuilder msg = new StringBuilder();
				for(String arg : args){
					msg.append(arg);
					msg.append(" ");
				}
				BroadcastAPI.broadcastMsg(AdminInv.AdminPrefix + msg);
			}
		}
		return true;
	}
}
