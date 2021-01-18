package poop.gui;

import org.darkstorm.minecraft.gui.component.Frame;
import org.darkstorm.minecraft.gui.util.GuiManagerDisplayScreen;

import net.minecraft.client.Minecraft;
import poop.main.Poop;

public class UIRender {
	
	public static void renderAndUpdateFrames() {
		for(Frame f: Poop.guiManager.getFrames()) {
			f.update();
		}
		for(Frame f: Poop.guiManager.getFrames()) {
			if(f.isPinned() || Minecraft.getMinecraft().currentScreen instanceof GuiManagerDisplayScreen) {
				f.render();
			}
		}
	}

}
