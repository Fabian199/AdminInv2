package com.jimdo.Fabian996.AdminInv2.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_9_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import com.jimdo.Fabian996.AdminInv2.Main.AdminInv;

import net.minecraft.server.v1_9_R1.EntityPlayer;

public class Ping implements CommandExecutor{

	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args){
		Player p = (Player)cs;
	    if ((cmd.getName().equalsIgnoreCase("ping")) && (args.length == 0)) {
	    	p.sendMessage(AdminInv.AdminPrefix + "§eDein Ping ist §c" + getPing(p) + " §ems");
	    }
	    return true;
	}
	
	public int getPing(Player p){
		CraftPlayer pingc = (CraftPlayer)p;
		EntityPlayer pinge = pingc.getHandle();
		return pinge.ping;
	}
}
