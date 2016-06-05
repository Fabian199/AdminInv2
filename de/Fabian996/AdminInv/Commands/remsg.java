package com.jimdo.Fabian996.AdminInv2.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jimdo.Fabian996.AdminInv2.Main.AdminInv;


public class remsg implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("r")){
			Player p = (Player)cs;
			if(args.length >= 0){
				if(AdminInv.Last_msg_Send_To.containsKey(cs.getName())){
					CommandSender target;
					if(((String)AdminInv.Last_msg_Send_To.get(cs.getName())).equalsIgnoreCase("CONSOLE"))
						target = Bukkit.getConsoleSender();
					else{
						target = Bukkit.getPlayer((String)AdminInv.Last_msg_Send_To.get(cs.getName()));
					}
					if(target != null){
						String message = "".replace("§", "&");
						for (int i = 0; i < args.length; i++) {
							message = message + args[i] + " ";
						}
						message = ChatColor.translateAlternateColorCodes('&', message);
						msg.SendMsg(cs, target, message);
					}else{
						p.sendMessage(AdminInv.AdminPrefix + "§cDu kannst nicht mit dir selber schreiben.");
					}
				}else{
					p.sendMessage(AdminInv.AdminPrefix + "§cFehler: Sie haben noch mit niemandem geschrieben ");
				}
			}
		}
		return true;
	}
}
