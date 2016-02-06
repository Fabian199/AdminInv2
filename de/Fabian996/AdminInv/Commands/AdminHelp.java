package de.Fabian996.AdminInv.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.Fabian996.AdminInv.Main.AdminMain;

public class AdminHelp implements CommandExecutor {

	@SuppressWarnings("unused" )
	private static AdminMain instance;
	
	public static final String Prefix = "§8[§4AdminInv§8]§r ";
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if(!(cs instanceof Player)){
			cs.sendMessage("You must be a player!");
		}
		if(cmd.getName().equalsIgnoreCase("ahelp")){
			Player p = (Player)cs;
			if(p.hasPermission("AdminInv.Help") || p.isOp() || p.hasPermission("AdminInv.*")){
				 if(args.length == 0){
	                    p.sendMessage(Prefix + "§8--------------- §4Commands §7[§31/3§7]§8 ---------------");
	                    p.sendMessage(Prefix + "§6/admin §f- Open the Admin GUI");
	                    p.sendMessage(Prefix + "§6/ghast §f- You get the Admin Item in the Inventory");
	                    p.sendMessage(Prefix + "§6/warp §5[warpname] §f- You are teleported to the Warp");
	                    p.sendMessage(Prefix + "§6/afk §f- You Change to AFK");
	                    p.sendMessage(Prefix + "§6/back §f-  You comeback from AFK");
	                    p.sendMessage(Prefix + "§6/ping §f-  You Show your Ping§7(ms)");
	                    p.sendMessage(Prefix + "§6/pinfo §7<Player> §f- Show Playerinfo from one Player");
	                    p.sendMessage(Prefix + " ");
	                    p.sendMessage(Prefix + "§fUse §6/ahelp 2 for next Page");
	                    p.sendMessage(Prefix + "§8--------------- §4Commands §7[§31/3§7]§8 ---------------");
	                    return true;
	                }
				 if(args.length == 1){
					 if(args[0].equalsIgnoreCase("2")){
						 p.sendMessage(Prefix + "§8--------------- §4Commands §7[§32/3§7]§8 ---------------");
						 p.sendMessage(Prefix + "§6/kick §7<Player> §5[reason] §f- Kick a Player with Reason");
						 p.sendMessage(Prefix + "§6/br §5<message> §f- You can send Broadcast Messages");
						 p.sendMessage(Prefix + "§6/vote §f- Show all Vote Links");
						 p.sendMessage(Prefix + "§6/sinfo §f- Show Server Information");
						 p.sendMessage(Prefix + "§6/tc §5<message> §- Send a Message in the TeamChat");
						 p.sendMessage(Prefix + "§6/cc §f- Clear the GlobalChat)");
						 p.sendMessage(Prefix + "§6/msg §7<player> §5<messafe> §7- Private Message");
						 p.sendMessage(Prefix + " ");
						 p.sendMessage(Prefix + "§fUse §6/ahelp 3 for next Page");
						 p.sendMessage(Prefix + "§8--------------- §4Commands §7[§32/3§7]§8 ---------------");
						 return true;
					 }  
					 if(args[0].equalsIgnoreCase("3")){
						 p.sendMessage(Prefix + "§8--------------- §4Commands §7[§33/3§7]§8 ---------------");
						 p.sendMessage(Prefix + "§6/r §5<message> §f- Awnser on a Private Message ");
						 p.sendMessage(Prefix + "§6/tp §7<player> §f- You can teleport to Player");
						 p.sendMessage(Prefix + "§6/rename §f- You can rename Item");
						 p.sendMessage(Prefix + "§6/gm §7<0/1/2/3/> §f- You can change to gamemode");
						 p.sendMessage(Prefix + " ");
						 p.sendMessage(Prefix + " ");
						 p.sendMessage(Prefix + " ");
						 p.sendMessage(Prefix + " ");
						 p.sendMessage(Prefix + "§8--------------- §4Commands §7[§33/3§7]§8 ---------------");
						 return true;
					 }
					 if(args[0].equalsIgnoreCase("warp")){
						 p.sendMessage(Prefix + "§8-------------- §4 Warp Commands§8 ---------------");
						 p.sendMessage(Prefix + "§6/setwarp §7<warpname> §f- set the warp point ");
						 p.sendMessage(Prefix + "§6/delwarp §7<warpname> §f- delete the warp point");
						 p.sendMessage(Prefix + "§6/warp §7<warpname> §f- You can teleport to the Warp point");
						 p.sendMessage(Prefix + "§6/warps §f- You show all warp Points");
						 p.sendMessage(Prefix + " ");
						 p.sendMessage(Prefix + "§8-------------- §4 Warp Commands§8 --------------");
					 }
				 }
			}	
		}
		return true;
	}
}
