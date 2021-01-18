package poop.mods;
import org.lwjgl.input.Keyboard;

import poop.main.Category;

public class Flight extends Module{
	
	public static float flyHackSpeed = 0.1f;

	public Flight() {
		super("Flight", Keyboard.KEY_F, Category.PLAYER);
	}
	
	public void onDisable() {
		mc.thePlayer.capabilities.isFlying = false;
		super.onDisable();
	}
	
	public void onUpdate() {
		if(this.isToggled()) {
			mc.thePlayer.capabilities.isFlying = true;
			
			if(mc.gameSettings.keyBindJump.isPressed()) {
				mc.thePlayer.motionY += 0.2;
			}
			
			if(mc.gameSettings.keyBindSneak.isPressed()) {
				mc.thePlayer.motionY -= 0.2;
			}
			
			if(mc.gameSettings.keyBindForward.isPressed()) {
				mc.thePlayer.capabilities.setFlySpeed(flyHackSpeed);
			}
			super.onUpdate();
		}
	}

}
