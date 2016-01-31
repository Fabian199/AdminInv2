package de.Fabian996.AdminInv.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearChatCMD implements CommandExecutor {

	public static final String Prefix = "§8[§4AdminInv§8]§r ";

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
	    if ((cs instanceof Player)) {
	    	Player p = (Player)cs;
	    	Boolean isConsole = Boolean.valueOf(true);
	    	if(cmd.getName().equalsIgnoreCase("cc")){
	    		if(p.hasPermission("AdminInv.ClearChat") || !isConsole.booleanValue()){
	    			for( Player target : Bukkit.getOnlinePlayers()){
	    				for(int i = 0; i < 120; i++){
	    					target.sendMessage(" ");
	    				}
	    				target.sendMessage(Prefix + "§7Chat has been cleared by §6" + p.getName());
					}
	    		}
	    	}
	    }
	    return true;
	}
}
