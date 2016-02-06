package de.Fabian996.AdminInv.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeamChatCMD implements CommandExecutor{
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		Player p = (Player)cs;
		if(cmd.getName().equalsIgnoreCase("tc")){
			if(p.hasPermission("AdminInv.TeamChat") || p.hasPermission("AdminInv.*")){
			      if (args.length != 0) {
			          String message = "";
			          String Prefix = "§8<§4TeamChat§8>§r ";
			          for (int i = 0; i < args.length; i++) {
			            message = message + " " + args[i];
			          }
			          for(Player target : Bukkit.getOnlinePlayers()){
			        	  if(target.hasPermission("AdminInv.TeamChat") || p.hasPermission("AdminInv.*")){
			        		  message = ChatColor.translateAlternateColorCodes('&', message);
			        		  target.sendMessage(Prefix + "§c" + p.getDisplayName() + " §6>>§f "  + message);
			        	  }
			          }
			      }
			}
		}
		return false;
	}
}
