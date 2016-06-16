package com.jimdo.Fabian996.AdminInv2.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.bukkit.Bukkit;

import com.jimdo.Fabian996.AdminInv2.Main.AdminInv;

public class BackupManager {

	public static void createBackup(){
		try{
			File root = new File("");
			File bfolder = new File(String.valueOf(root.getAbsolutePath() + "/server-backup/"));
			if(!bfolder.exists()){
				bfolder.mkdirs();
			}
			DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd");
			DateFormat timeFormat = new SimpleDateFormat("HH_mm_ss");
			Date date = new Date();
			File datefolder = new File(String.valueOf(bfolder.getAbsolutePath()) + "/" + dateFormat.format(date) + "/");
			if(!datefolder.exists()){
            	datefolder.mkdir();
            }
			File backup = new File(String.valueOf(datefolder.getAbsolutePath()) + "/backup_" + timeFormat.format(date) + "_Hour_Min_s.zip");
            backup.createNewFile();
            try {
            	ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(backup));
            	zipDir(root.getAbsolutePath(), zos);
            	zos.close();
            	Bukkit.getServer().getConsoleSender().sendMessage(AdminInv.SystemPrefix + "Done backup!");
            	
            }catch(Exception ex){
            }
		}catch(Exception e){
			System.out.println();
		}
	}
	
	public static void zipDir(String dir2zip, ZipOutputStream zos) {
        try {
            File zipDir = new File(dir2zip);
            ArrayList<String> dirList = new ArrayList<String>(Arrays.asList(zipDir.list()));
            for (String str22 : dirList) {
                if (str22.startsWith("backup") && str22.endsWith(".zip")) {
                    dirList.remove(str22);
                }
            }
            byte[] readBuffer = new byte[2156];
            int bytesIn = 0;
            for (String file : dirList) {
                File f = new File(zipDir, file);
                if (f.isDirectory()) {
                    String filePath = f.getPath();
                    zipDir(filePath, zos);
                    continue;
                }
                FileInputStream fis = new FileInputStream(f);
                ZipEntry anEntry = new ZipEntry(f.getPath());
                zos.putNextEntry(anEntry);
                while ((bytesIn = fis.read(readBuffer)) != -1) {
                    zos.write(readBuffer, 0, bytesIn);
                }
                fis.close();
            }
        }
        catch (Exception zipDir) {
            // empty catch block
        }
    }
}
