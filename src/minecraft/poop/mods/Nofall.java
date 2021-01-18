package poop.mods;

import org.lwjgl.input.Keyboard;

import net.minecraft.network.play.client.C03PacketPlayer;
import poop.main.Category;

public class Nofall extends Module{

	public Nofall() {
		super("Nofall", Keyboard.KEY_N, Category.PLAYER);
	}
	
	public void onUpdate() {
		if(this.isToggled()) {
			if(mc.thePlayer.fallDistance > 1F) {
				mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer(true));
			}
		}
		super.onUpdate();
	}

}
