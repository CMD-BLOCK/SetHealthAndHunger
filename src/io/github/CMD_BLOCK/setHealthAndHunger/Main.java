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
	public void onEnable(){//�������
		getLogger().info("setHealthAndHunger����ɹ����أ�����:CMDؼBLOCK");
	}
	public void help(CommandSender sender){//���Ͱ���
		sender.sendMessage("��a=========setHealthAndHunger���ʹ�ð���=========");
		sender.sendMessage("��b/shah health <���> <Ѫ��>  ����ָ����ҵ�Ѫ��(0~20)");
		sender.sendMessage("��b/shah hunger <���> <��ʳ��> ����ָ����ҵı�ʳ��(0~20)");
		sender.sendMessage("��a===============����:CMDؼBLOCK================");
	}
	public boolean onCommand(CommandSender sender,Command cmd,String label,String[] args){
		if(label.equalsIgnoreCase("shah")){
			if(args.length==0){//���Ͱ���
				help(sender);
				return true;
			}
				if(args.length==3){
					Pattern pattern=Pattern.compile("[0-9]*");
					Matcher isNum=pattern.matcher(args[2]);
					if(!isNum.matches()){sender.sendMessage("��cѪ���ͱ�ʳ����ʹ�����֣���Χ��0~20");return true;}
					Player p = (Bukkit.getServer().getPlayer(args[1]));
					Double Health=Double.valueOf(args[2]);
					int Hunger=Integer.parseInt(args[2]);
						if(args[0].equalsIgnoreCase("health")){
							if(sender.isOp()||sender.hasPermission("shah.health")){
								if(p==null){sender.sendMessage("��c����Ҳ�����");return true;}
								if(p.getGameMode()==GameMode.CREATIVE){sender.sendMessage("��c������Ǵ���ģʽ���޷��޸�");return true;}
								if(Health>20||Health<0){sender.sendMessage("��cѪ����Χ��0~20");return true;}
								p.setHealth(Health);
								sender.sendMessage("��a��� ��b"+args[1]+" ��a��Ѫ�������ó� ��c"+args[2]);
								return true;
							}
							sender.sendMessage("��4��û��ʹ�ô������Ȩ��");
							return true;
						}//����Ѫ��
						if(args[0].equalsIgnoreCase("hunger")){
							if(sender.isOp()||sender.hasPermission("shah.hunger")){
								if(p==null){sender.sendMessage("��c����Ҳ�����");return true;}
								if(p.getGameMode()==GameMode.CREATIVE){sender.sendMessage("��c������Ǵ���ģʽ���޷��޸�");return true;}
								if(Health>20||Health<0){sender.sendMessage("��c��ʳ�ȷ�Χ��0~20");return true;}
								p.setFoodLevel(Hunger);
								sender.sendMessage("��a��� ��b"+args[1]+" ��a�ı�ʳ�������ó� ��c"+args[2]);
								return true;
							}
							sender.sendMessage("��4��û��ʹ�ô������Ȩ��");
							return true;
						}//���ñ�ʳ��
				}
				help(sender);
				return true;
		}
		return false;
	}
}
