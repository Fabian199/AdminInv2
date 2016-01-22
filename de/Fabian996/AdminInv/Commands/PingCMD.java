package de.Fabian996.AdminInv.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.EntityPlayer;

public class PingCMD implements CommandExecutor {

	public static final String Prefix = "§8[§4AdminInv§8]§r ";

	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args){
		Player p = (Player)cs;
	    if ((cmd.getName().equalsIgnoreCase("Ping")) && (args.length == 0)) {
	    	p.sendMessage(Prefix + "§eYour Ping is §c" + getPing(p) + " ms");
	    }
	    return true;
	  }

	  public int getPing(Player p) {
	    CraftPlayer pingc = (CraftPlayer)p;
	    EntityPlayer pinge = pingc.getHandle();
	    return pinge.ping;
	  }
}
