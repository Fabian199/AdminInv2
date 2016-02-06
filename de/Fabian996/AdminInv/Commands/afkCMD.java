package de.Fabian996.AdminInv.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.Fabian996.AdminInv.Main.AdminMain;

public class afkCMD implements CommandExecutor {
	
	public static final String Prefix = "§8[§4AdminInv§8]§r ";
	
	@SuppressWarnings("unused")
	private final AdminMain plugin;
	
	public afkCMD(AdminMain plugin){
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		Player p = (Player)cs;
		if(args.length == 0){
			if(AdminMain.afkPlayers.contains(p.getName())){
				AdminMain.afkPlayers.remove(p.getName());
			}else{
				AdminMain.afkPlayers.add(p.getName());
				p.setDisplayName("§8[§cAFK§8] §7" + p.getName());
				p.setCustomName("§8[§cAFK§8] §7" + p.getName());
				p.setPlayerListName("§8[§cAFK§8] §7" + p.getName());
				p.setCustomNameVisible(true);
				Bukkit.broadcastMessage(Prefix + p.getName() + "§f is now §4AFK");
			}
		}
		return true;
	}
}
