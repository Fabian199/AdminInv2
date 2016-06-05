package com.jimdo.Fabian996.AdminInv2.API;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class BroadcastAPI extends JavaPlugin{

	public static void broadcastMsg(String msg) {
		msg = ChatColor.translateAlternateColorCodes('&', msg);
		Bukkit.getServer().broadcastMessage(msg);
	  }
}
