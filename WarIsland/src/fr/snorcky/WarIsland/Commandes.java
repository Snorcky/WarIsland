package fr.snorcky.WarIsland;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandes implements CommandExecutor {


	public Commandes(Main main) {

	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		Player p = (Player)sender;
		
		if(sender instanceof Player){
			if(cmd.getName().equalsIgnoreCase("wi")){
				if(args[0].equalsIgnoreCase("create")){
					Random random = new Random();
					
					int x = p.getLocation().getBlockX() + random.nextInt(10);
					int y = p.getLocation().getBlockY() + random.nextInt(250);
					int z = p.getLocation().getBlockZ() + random.nextInt(10);
					
					Location aleatoire = new Location(p.getWorld(), x,y,z);
					
					p.teleport(aleatoire);
					
				}
			}
		}
		
		return false;
	}

}
