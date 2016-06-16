package com.jimdo.Fabian996.AdminInv2.Commands;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jimdo.Fabian996.AdminInv2.Main.AdminInv;

public class Ping implements CommandExecutor{

	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args){
		Player p = (Player)cs;
	    if ((cmd.getName().equalsIgnoreCase("ping")) && (args.length == 0)) {
	    	p.sendMessage(AdminInv.AdminPrefix + "§eDein Ping ist §c" + getPing(p) + " §ems");
	    }
	    return true;
	}
	
	public static int getPing(Player p){
		String v = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
		try{
			Class<?> CraftPlayerClass = Class.forName("org.bukkit.craftbukkit." + v + ".entity.CraftPlayer");
			Object CraftPlayer = CraftPlayerClass.cast(p);
			Method getHandle = CraftPlayer.getClass().getMethod("getHandle", new Class[0]);
			Object EntityPlayer = getHandle.invoke(CraftPlayer, new Object[0]);
			Field ping = EntityPlayer.getClass().getDeclaredField("ping");
			return ping.getInt(EntityPlayer);
		}catch (Exception e){
			e.printStackTrace();
		}
		return 0;
	}
}
