package de.Fabian996.AdminInv.Commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCMD implements CommandExecutor {

	public static final String Prefix = "§8[§4AdminInv§8]§r ";
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
			Player p = (Player)cs;
			if(cmd.getName().equalsIgnoreCase("gm")){
				if(p.hasPermission("AdminInv.Gamemode") || p.hasPermission("AdminInv.*")){
					if(args[0].equalsIgnoreCase("0")){
						p.setGameMode(GameMode.SURVIVAL);
						p.sendMessage(Prefix + "You are in Gamemode Survival");
					}
					if(args[0].equalsIgnoreCase("1")){
						p.setGameMode(GameMode.CREATIVE);
						p.sendMessage(Prefix + "You are in Gamemode Creative");
					}
					if(args[0].equalsIgnoreCase("2")){
						p.setGameMode(GameMode.ADVENTURE);
						p.sendMessage(Prefix + "You are in Gamemode Adventure");
					}
					if(args[0].equalsIgnoreCase("3")){
						p.setGameMode(GameMode.SPECTATOR);
						p.sendMessage(Prefix + "You are in Gamemode Spectator");
					}
				}
			}
		return true;
	}
}
