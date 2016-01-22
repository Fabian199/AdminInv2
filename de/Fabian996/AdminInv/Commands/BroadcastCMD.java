package de.Fabian996.AdminInv.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.Fabian996.AdminInv.API.BroadcastAPI;

public class BroadcastCMD implements CommandExecutor {

	public static final String Prefix = "§8[§4AdminInv§8]§r ";
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("br")){
			Player p = (Player)cs;
			if(p.hasPermission("AdminInv.Broadcast")){
				if(!(cs instanceof Player)){
					cs.sendMessage("You are not a player!");
					return true;
				}
				if(args.length == 0){
					cs.sendMessage(Prefix + "§fUse: §6/br §5<message>");
					return true;
				}
			
				StringBuilder msg = new StringBuilder();
				for(String arg : args){
					msg.append(arg);
					msg.append(" ");
				}
				BroadcastAPI.broadcastMsg(Prefix + msg);
			}
		}
		return false;
	}
}
