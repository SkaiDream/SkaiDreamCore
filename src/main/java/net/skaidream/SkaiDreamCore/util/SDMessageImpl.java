package net.skaidream.SkaiDreamCore.util;

import java.util.ArrayList;
import java.util.Arrays;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class SDMessageImpl extends SDAbstractSender
{
	public String REPLACE_VALUE = "\\<v\\>";

	@Override
	public MessageType sendMessage(Player player, String message)
	{
		return this.sendFixedMessage(player, message, null);
	}

	@Override
	public MessageType sendMessage(CommandSender sender, String message)
	{
		return this.sendFixedMessage(sender, message, null);
	}

	@Override
	public MessageType sendMessage(ConsoleCommandSender sender, String message)
	{
		return this.sendFixedMessage(sender, message, null);
	}

	@Override
	public MessageType sendFixedMessage(Object obj, String message)
	{
		return this.sendFixedMessage(obj, message, null);
	}

	@Override
	public MessageType sendFixedMessage(Object obj, String message, Object... args)
	{
		if(!(obj instanceof CommandSender)) throw new NullPointerException("Please check the object type");
		if(obj instanceof Player)
		{
			Player mediator =  (Player)obj;
			ArrayList<Object> mList = new ArrayList<Object>(Arrays.asList(args));
			while(message.matches(REPLACE_VALUE))
			{
				Object value = mList.get(0);
				if(value instanceof Number)
				{
					String valueStr = String.valueOf((Number)value);
					message = message.replaceFirst(REPLACE_VALUE, valueStr);
				}
				else if(value instanceof String)
				{
					String valueStr = (String)value;
					message = message.replaceFirst(REPLACE_VALUE, valueStr);
				}
			}
			mediator.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
			return new MessageType(obj, message);
		}
		else if(obj instanceof ConsoleCommandSender)
		{
			ConsoleCommandSender mediator = (ConsoleCommandSender) obj;
			ArrayList<Object> mList = new ArrayList<Object>(Arrays.asList(args));
			while(message.matches(REPLACE_VALUE))
			{
				Object value = mList.get(0);
				if(value instanceof Number)
				{
					String valueStr = String.valueOf((Number)value);
					message = message.replaceFirst(REPLACE_VALUE, valueStr);
				}
				else if(value instanceof String)
				{
					String valueStr = (String)value;
					message = message.replaceFirst(REPLACE_VALUE, valueStr);
				}
			}
			mediator.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
			return new MessageType(obj, message);
		}
		else
		{
			return null;
		}
	}
	
}
