package com.jimdo.Fabian996.AdminInv2.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.jimdo.Fabian996.AdminInv2.Main.AdminInv;
import com.jimdo.Fabian996.AdminInv2.Utils.BackupManager;

public class Backup implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("backup")){
			if(!cs.hasPermission("admininv.backup") || (!cs.hasPermission("admininv.*"))){
				cs.sendMessage(AdminInv.AdminPrefix + AdminInv.NoPerm);
				return false;
			}
			BackupManager.createBackup();
			cs.sendMessage(AdminInv.SystemPrefix + "§7Starten des Backups! §6Siehe in der Konsole für mehr Informationen.");
            return true;
		}
	return true;
	}
}
