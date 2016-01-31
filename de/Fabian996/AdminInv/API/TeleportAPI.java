package de.Fabian996.AdminInv.API;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class TeleportAPI extends JavaPlugin{
	
	public static void teleportPlayer(Player target, Location loc){
		target.teleport(loc);
	}
}
