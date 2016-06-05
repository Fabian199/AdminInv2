package com.jimdo.Fabian996.AdminInv2.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jimdo.Fabian996.AdminInv2.Main.AdminInv;

public class msg implements CommandExecutor {

	@SuppressWarnings({ "deprecation", "unused" })
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("msg")){
			Player p = (Player)cs;
			if(args.length >=2){
				Player target = Bukkit.getPlayer(args[0]);
				if(target!= null){
					if(target != cs){
						String Message = "";
						for(int i = 1; i < args.length; i++){
							Message = Message + args[i] + " ";
						}
						Message = ChatColor.translateAlternateColorCodes('&', Message);
						SendMsg(cs, target, Message);
					}else{
						cs.sendMessage(AdminInv.AdminPrefix + "§cDu kannst nicht mit dir selber schreiben");
					}
				}else{
					cs.sendMessage(AdminInv.AdminPrefix + "§cFehler: §6" + args[0] + " §cist nict onlein! ");
				}
			}else{
				cs.sendMessage(AdminInv.AdminPrefix + "Nutze: §3/" + label + " §7<§5Nachricht§7>");
			}
		}
		return true;
	}
	
	public static void SendMsg(CommandSender cs, CommandSender target, String Message){
		try{
		cs.sendMessage(AdminInv.AdminPrefix + "§2" + cs.getName() + " §7» §6" + target.getName() + " §8| §7" + Message);
		target.sendMessage(AdminInv.AdminPrefix + "§6" + cs.getName() + " §7» §2" + target.getName() + " §8| §7" + Message);
		AdminInv.Last_msg_Send_To.put(cs.getName(), target.getName());
		AdminInv.Last_msg_Send_To.put(target.getName(), cs.getName());
		}catch(Exception e){
		}
	}
}
