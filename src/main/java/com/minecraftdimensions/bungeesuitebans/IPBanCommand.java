package com.minecraftdimensions.bungeesuitebans;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class IPBanCommand implements CommandExecutor {

	BungeeSuiteBans plugin;
	
	private static final String[] PERMISSION_NODES = { "bungeesuite.ban.ipban", "bungeesuite.ban.*",
		"bungeesuite.mod", "bungeesuite.admin", "bungeesuite.*" };

	public IPBanCommand(BungeeSuiteBans bungeeSuiteBans){
		plugin = bungeeSuiteBans;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if (!CommandUtil.hasPermission(sender, PERMISSION_NODES)) {
			plugin.utils.getMessage(sender.getName(), "NO_PERMISSION");
			return true;
		}
		if(args.length==1){
			plugin.utils.ipBanPlayer(sender.getName(),args[0], "");
			return true;
		}
		if(args.length>1){
			String msg = "";
			for(String data: args){
				if(!data.equals(args[0])){
					msg+=data+" ";
				}
			}
			plugin.utils.ipBanPlayer(sender.getName(),args[0],msg);
			return true;
		}

		return false;
	}

}