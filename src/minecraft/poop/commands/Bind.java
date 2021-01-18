package poop.commands;

import org.lwjgl.input.Keyboard;

import poop.command.Command;
import poop.main.Poop;

public class Bind extends Command{

	@Override
	public String getAlias() {
		// TODO Auto-generated method stub
		return "bind";
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Allows User To Change Keybind Of Ghost Client Module";
	}

	@Override
	public String getSyntax() {
		// TODO Auto-generated method stub
		return ".bind set [MODULE] [KEY] | .bind del [MODULE] | .bind clear";
	}

	@Override
	public void onCommand(String command, String[] args) throws Exception {
		if(args[0].equalsIgnoreCase("set")) {
			args[2] = args[2].toUpperCase();
			int key = Keyboard.getKeyIndex(args[2]);
			
			for(poop.mods.Module m: Poop.getModules()) {
				if(args[1].equalsIgnoreCase(m.getName())) {
					m.setKey(Keyboard.getKeyIndex(Keyboard.getKeyName(key)));
					Poop.addChatMessage(args[1] + " has been binded to " + args[2]);
					
				}
			}
		}else if(args[0].equalsIgnoreCase("del")) {
			for(poop.mods.Module m: Poop.getModules()) {
				if(m.getName().equalsIgnoreCase(args[1])) {
					m.setKey(0);
					Poop.addChatMessage(args[1] + " Has Been Removed!");
				}
			}
		}else if(args[0].equalsIgnoreCase("clear")) {
			for(poop.mods.Module m: Poop.getModules()) {
				m.setKey(0);
			}
			Poop.addChatMessage("All Binds Cleared!");
		}
		
	}

}
