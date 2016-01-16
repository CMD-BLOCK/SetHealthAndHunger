package io.github.CMD_BLOCK.setHealthAndHunger;

import java.util.regex.Pattern;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.regex.Matcher;

public class Main extends JavaPlugin {
	public void onEnable(){//插件加载
		getLogger().info("setHealthAndHunger插件成功加载！作者:CMD丶BLOCK");
	}
	public void help(CommandSender sender){//发送帮助
		sender.sendMessage("§a=========setHealthAndHunger插件使用帮助=========");
		sender.sendMessage("§b/shah health <玩家> <血量>  设置指定玩家的血量(0~20)");
		sender.sendMessage("§b/shah hunger <玩家> <饱食度> 设置指定玩家的饱食度(0~20)");
		sender.sendMessage("§a===============作者:CMD丶BLOCK================");
	}
	public boolean onCommand(CommandSender sender,Command cmd,String label,String[] args){
		if(label.equalsIgnoreCase("shah")){
			if(args.length==0){//发送帮助
				help(sender);
				return true;
			}
				if(args.length==3){
					Pattern pattern=Pattern.compile("[0-9]*");
					Matcher isNum=pattern.matcher(args[2]);
					if(!isNum.matches()){sender.sendMessage("§c血量和饱食度请使用数字！范围：0~20");return true;}
					Player p = (Bukkit.getServer().getPlayer(args[1]));
					Double Health=Double.valueOf(args[2]);
					int Hunger=Integer.parseInt(args[2]);
						if(args[0].equalsIgnoreCase("health")){
							if(sender.isOp()||sender.hasPermission("shah.health")){
								if(p==null){sender.sendMessage("§c此玩家不在线");return true;}
								if(p.getGameMode()==GameMode.CREATIVE){sender.sendMessage("§c此玩家是创造模式，无法修改");return true;}
								if(Health>20||Health<0){sender.sendMessage("§c血量范围：0~20");return true;}
								p.setHealth(Health);
								sender.sendMessage("§a玩家 §b"+args[1]+" §a的血量已设置成 §c"+args[2]);
								return true;
							}
							sender.sendMessage("§4你没有使用此命令的权限");
							return true;
						}//设置血量
						if(args[0].equalsIgnoreCase("hunger")){
							if(sender.isOp()||sender.hasPermission("shah.hunger")){
								if(p==null){sender.sendMessage("§c此玩家不在线");return true;}
								if(p.getGameMode()==GameMode.CREATIVE){sender.sendMessage("§c此玩家是创造模式，无法修改");return true;}
								if(Health>20||Health<0){sender.sendMessage("§c饱食度范围：0~20");return true;}
								p.setFoodLevel(Hunger);
								sender.sendMessage("§a玩家 §b"+args[1]+" §a的饱食度已设置成 §c"+args[2]);
								return true;
							}
							sender.sendMessage("§4你没有使用此命令的权限");
							return true;
						}//设置饱食度
				}
				help(sender);
				return true;
		}
		return false;
	}
}
