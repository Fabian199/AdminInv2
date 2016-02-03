package de.Fabian996.AdminInv.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class remsgCMD implements CommandExecutor {
	
	public static final String Prefix = "§8[§4AdminInv§8]§r ";
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("r")){
			Player p = (Player)cs;
			if(args.length >= 0){
				if(msgCMD.LAST_MSG_SEND_TO.containsKey(cs.getName())){
					CommandSender target;
					if(((String)msgCMD.LAST_MSG_SEND_TO.get(cs.getName())).equalsIgnoreCase("CONSOLE"))
						target = Bukkit.getConsoleSender();
					else{
						target = Bukkit.getPlayer((String)msgCMD.LAST_MSG_SEND_TO.get(cs.getName()));
					}
					if(target != null){
						String message = "".replace("§", "&");
						for (int i = 0; i < args.length; i++) {
							message = message + args[i] + " ";
						}
						message = ChatColor.translateAlternateColorCodes('&', message);
						msgCMD.SendMsg(cs, target, message);
					}else{
						p.sendMessage(Prefix + "§cYou cannot correspond yourself.");
					}
				}else{
					p.sendMessage(Prefix + "§cError: You have still written with nobody ");
				}
			}
		}
		return true;
	}
}
