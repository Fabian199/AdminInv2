package de.Fabian996.AdminInv.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearChatCMD implements CommandExecutor {

	public static final String Prefix = "§8[§4AdminInv§8]§r ";
	
	@SuppressWarnings("unused")
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("cc")){
			Player p = (Player)cs;
			if(p.hasPermission("AdminInv.ClearChat")){
				for( Player traget : Bukkit.getOnlinePlayers()){
					for(int x = 0; x < 120; x++){
						p.sendMessage(" ");
					}
					Bukkit.broadcastMessage(Prefix + "§7Chat has been cleared by §6" + p.getName());
				}
			}
		}
		return false;
	}

}
