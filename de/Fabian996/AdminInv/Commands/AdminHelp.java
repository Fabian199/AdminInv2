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
			if(p.hasPermission("AdminInv.Help") || p.isOp()){
				p.sendMessage(Prefix + "§8----------------- §4Commands §8-----------------");
				p.sendMessage(Prefix + "§6/admin §f- Open the Admin GUI  ");
				p.sendMessage(Prefix + "§6/ghast §f- You get the Admin Item in the inventory ");
				p.sendMessage(Prefix + "§6/warp §5[warpname]§f - You are teleported to the Warp");
				p.sendMessage(Prefix + "§6/afk §f - You change to afk");
				p.sendMessage(Prefix + "§6/back §f - You comeback form afk");
				p.sendMessage(Prefix + "§6/ping §f - You show your Ping§7(ms)");
				p.sendMessage(Prefix + "§6/pinfo §7<player> §f - Show PlayerInfo form one Player");
				p.sendMessage(Prefix + "§6/kick §7<player> §5[reason] §f - Show Player Info");
				p.sendMessage(Prefix + "§6/br §5<message> §f - You can Broadcast Message send");
				p.sendMessage(Prefix + "§6/vote §f - Show all Votelinks");
				p.sendMessage(Prefix + "§6/sinfo §f - Show Server Information");
				p.sendMessage(Prefix + "§6/tc §5<message> §f - You send message in the TeamChat");
				p.sendMessage(Prefix + "§6/cc §f - Clear the Global Chat");
				p.sendMessage(Prefix + "§6/msg §7<player> §5<message> §f - Private Message");
				p.sendMessage(Prefix + "§6/r §5<message> §f - Private Message ");
				p.sendMessage(Prefix + "§6/tp §7<player> §f - You can teleport to player ");
			}
		}
		return true;
	}
}
