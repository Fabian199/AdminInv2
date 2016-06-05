package com.jimdo.Fabian996.AdminInv2.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jimdo.Fabian996.AdminInv2.Main.AdminInv;

public class Vote implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		Player p = (Player)cs;
		if(cmd.getName().equalsIgnoreCase("vote")){
			String Vote = AdminInv.cfg.getString("vote.message1");
			String Vote2 = AdminInv.cfg.getString("vote.message2");
			String Vote3 = AdminInv.cfg.getString("vote.message3");
			String Vote4 = AdminInv.cfg.getString("vote.message4");
			String Vote5 = AdminInv.cfg.getString("vote.message5");
			
			p.sendMessage(AdminInv.AdminPrefix + "§6+---------------+§bVote Links§6+----------------+");		
			p.sendMessage(AdminInv.AdminPrefix + "§7Vote 1: §2" + Vote);
			p.sendMessage(AdminInv.AdminPrefix + "§7Vote 2: §2" + Vote2);
			p.sendMessage(AdminInv.AdminPrefix + "§7Vote 3: §2" + Vote3);
			p.sendMessage(AdminInv.AdminPrefix + "§7Vote 4: §2" + Vote4);
			p.sendMessage(AdminInv.AdminPrefix + "§7Vote 5: §2" + Vote5);
			p.sendMessage(AdminInv.AdminPrefix + "§6+---------------+§bVote Links§6+----------------+");	
			return true;
		}
		return true;
	}
}
