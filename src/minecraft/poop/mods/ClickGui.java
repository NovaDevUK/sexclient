package poop.mods;

import org.darkstorm.minecraft.gui.util.GuiManagerDisplayScreen;
import org.lwjgl.input.Keyboard;

import poop.gui.UIRender;
import poop.main.Category;
import poop.main.Poop;

public class ClickGui extends Module{

	public ClickGui() {
		super("Click Gui", Keyboard.KEY_GRAVE, Category.OTHER);
	}
	
	public void onEnable() {
		if(!(mc.currentScreen instanceof GuiManagerDisplayScreen)) {
			mc.displayGuiScreen(new GuiManagerDisplayScreen(Poop.guiManager));
			UIRender.renderAndUpdateFrames();
		}
	}

}
