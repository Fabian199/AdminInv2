package com.jimdo.Fabian996.AdminInv2.API;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class TeleportAPI extends JavaPlugin{

	public static void teleportPlayer(Player target, Location loc){
		target.teleport(loc);
	}
}
