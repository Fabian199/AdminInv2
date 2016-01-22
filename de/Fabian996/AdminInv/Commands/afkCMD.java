package de.Fabian996.AdminInv.Commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class afkCMD implements CommandExecutor {

	public ArrayList<String> AFK = new ArrayList<String>();
	
	public static final String Prefix = "§8[§4AdminInv§8]§r ";
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		Player p = (Player)cs;
		if(label.equalsIgnoreCase("afk")){
			p.setDisplayName("§8[§cAFK§8] §7" + p.getName());
			p.setCustomName("§8[§cAFK§8] §7" + p.getName());
			p.setPlayerListName("§8[§cAFK§8] §7" + p.getName());
			p.setCustomNameVisible(true);
			Bukkit.broadcastMessage(Prefix + p.getName() + "§f is now §4AFK");
			}else if(label.equalsIgnoreCase("back")){
				p.setDisplayName(p.getName());
				p.setCustomName(p.getName());
				p.setPlayerListName(p.getName());
				p.setCustomNameVisible(true);
				Bukkit.broadcastMessage(Prefix + p.getName() + "§f is now §aBack");
			}
		return true;
	}
}
