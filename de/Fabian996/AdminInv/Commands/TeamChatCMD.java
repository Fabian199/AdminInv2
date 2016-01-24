package de.Fabian996.AdminInv.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeamChatCMD implements  CommandExecutor{
	
	public static final String Prefix = "§8<§4TeamChat§8>§r ";

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		Player p = (Player)cs;
		if(cmd.getName().equalsIgnoreCase("tc")){
			if(p.hasPermission("AdminInv.TeamChat")){
			      if (args.length != 0) {
			          String message = "";
			          for (int i = 0; i < args.length; i++) {
			            message = message + " " + args[i];
			          }
			          for(Player target : Bukkit.getOnlinePlayers()){
			        	  if(target.hasPermission("AdminInv.TeamChat")){
			        		  target.sendMessage(Prefix + "§c" + p.getDisplayName() + " §6>> §b" + message);
			        	  }
			          }
			      }
			}
		}
		return false;
	}
}
