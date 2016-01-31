package de.Fabian996.AdminInv.Commands;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.Fabian996.AdminInv.API.TeleportAPI;

public class TeleportCMD implements CommandExecutor {

	public static final String Prefix = "§8[§4AdminInv§8]§r ";
	
	private String NoArgs = "§4Please include a player!";
	private String NotPlayer = "§4That player is not online!";
	private String tpMSG = "§2Teleported to §6";
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("tp")){
			Player p = (Player)cs;
			if(args.length == 0){
				p.sendMessage(Prefix + NoArgs);
				return true;
			}
			Player target = Bukkit.getServer().getPlayer(args[0]);
			if(target == null){
				p.sendMessage(Prefix + NotPlayer);
			}
			
			TeleportAPI.teleportPlayer(p, target.getLocation());
			p.sendMessage(Prefix + tpMSG + target.getName());
		}
		return true;
	}

}
