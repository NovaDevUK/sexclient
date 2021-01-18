package poop.main;

import org.darkstorm.minecraft.gui.theme.simple.SimpleTheme;
import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.network.play.server.S02PacketChat;
import net.minecraft.util.ChatComponentText;

import java.util.ArrayList;

import poop.command.CommandManager;
import poop.gui.PoopGuiManager;
import poop.mods.*;

import poop.mods.Flight;
import poop.mods.Module;

public class Poop {
	
	private static ArrayList<Module> mods;
	private static CommandManager cmdManager;
	public static PoopGuiManager guiManager;
	
	public Poop() {
		mods = new ArrayList<Module>();
		cmdManager = new CommandManager();
		addMod(new Flight());
		addMod(new Nofall());
		addMod(new Fullbright());
		addMod(new ClickGui());
		guiManager = new PoopGuiManager();
		guiManager.setTheme(new SimpleTheme());
		guiManager.setup();
		
	}
	
	public static void addMod(Module m) {
		mods.add(m);
	}
	
	public static ArrayList<Module> getModules() {
		return mods;
	}
	
	public static void onUpdate() {
		for(Module m: mods) {
			m.onUpdate();
		}
	}
	
	public static void onRender() {
		for(Module m: mods) {
			m.onRender();
		}
	}
	
	public static void onKeyPressed(int k) {
		for(Module m:mods) {
			if(m.getKey() == k) {
				m.toggle();
			}
		}
	}
	
	public static void addChatMessage(String s) { //ESP
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Poop: " + s));
	}
	
	public static boolean onSendChatMessage(String s) {
		if(s.startsWith(".")){
			cmdManager.callCommand(s.substring(1));
			return false;
		}
		for (Module m: getModules()) {
			if(m.isToggled()) {
				return m.onSendChatMessage(s);
			}
		}
		return true;
	}
	public static boolean onRecieveChatMessage(S02PacketChat packet) {
		for(Module m: getModules()) {
			if(m.isToggled()) {
				return m.onRecieveChatMessage(packet);
		}
	}
	return true;
}}