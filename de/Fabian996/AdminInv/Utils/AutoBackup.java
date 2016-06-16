package com.jimdo.Fabian996.AdminInv2.Utils;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import com.jimdo.Fabian996.AdminInv2.Main.AdminInv;

public class AutoBackup {

	public AutoBackup(AdminInv adminInv) {
	}

	@SuppressWarnings("deprecation")
	public static void startAutoBackup(){
		Bukkit.getScheduler().scheduleSyncRepeatingTask(AdminInv.getInstance(), new BukkitRunnable(){
			public void run(){
				Bukkit.getConsoleSender().sendMessage(AdminInv.SystemPrefix + "§cErstellen eines Backups...");
				BackupManager.createBackup();
			}
	   	}, 0L, AdminInv.getInstance().getConfig().getInt("AutoBackup.Interval") * 20 * 60);
	  }
}
