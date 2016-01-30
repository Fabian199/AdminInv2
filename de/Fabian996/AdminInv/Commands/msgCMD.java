package de.Fabian996.AdminInv.Commands;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class msgCMD implements CommandExecutor {
	
	public static final String Prefix = "§8[§4AdminInv§8]§r ";
	public static final HashMap<String, String> LAST_MSG_SEND_TO = new HashMap<>();
	
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
						SendMsg(cs, target, Message);
					}else{
						cs.sendMessage(Prefix + "§cYou cannot correspond yourself.");
					}
				}else{
					cs.sendMessage(Prefix + "§cError: §6" + args[0] + " §cif is not online! ");
				}
			}else{
				cs.sendMessage(Prefix + "§cUse: §3/" + label + " §6<message>");
			}
		}else if(label.equalsIgnoreCase("r")){
			Player p = (Player)cs;
			if(args.length >= 1){
				if(msgCMD.LAST_MSG_SEND_TO.containsKey(cs.getName())){
					CommandSender target;
					if(((String)msgCMD.LAST_MSG_SEND_TO.get(cs.getName())).equalsIgnoreCase("CONSOLE"))
						target = Bukkit.getConsoleSender();
					else{
						target = Bukkit.getPlayer((String)msgCMD.LAST_MSG_SEND_TO.get(cs.getName()));
					}
					if(target != null){
						String Message = "";
						for (int i = 0; i < args.length; i++) {
							Message = Message + args[i] + " ";
						}
						SendMsg(cs, target, Message);
					}else{
						cs.sendMessage(Prefix + "§cYou cannot correspond yourself.");
					}
				}else{
					cs.sendMessage(Prefix + "§cError: You have still written with nobody ");
				}
			}else{
				cs.sendMessage(Prefix + "§cUse: §3/r §6 <message>");
			}
		}
		return true;
	}
	public void SendMsg(CommandSender cs, CommandSender target, String Message){
		try{
		cs.sendMessage(Prefix + "§4" + cs.getName() + " §7» §6" + target.getName() + " §8| §7" + Message);
		target.sendMessage(Prefix + "§6" + cs.getName() + " §7» §4" + target.getName() + " §8| §7" + Message);
		LAST_MSG_SEND_TO.put(cs.getName(), target.getName());
		}catch(Exception e){
		}
	}
}
