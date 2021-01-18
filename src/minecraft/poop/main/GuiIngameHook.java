package poop.main;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import poop.gui.UIRender;

public class GuiIngameHook extends GuiIngame{

	public GuiIngameHook(Minecraft mcIn) {
		super(mcIn);
	}
	    public void renderGameOverlay(float partialTicks) {
		super.renderGameOverlay(partialTicks);
        ScaledResolution scaledresolution = new ScaledResolution(this.mc);
        this.mc.entityRenderer.setupOverlayRendering();
        GlStateManager.enableBlend();
        
        int count = 0;
        
        for(poop.mods.Module m: Poop.getModules()) {
        	if(m.isToggled()) {
        		mc.fontRendererObj.drawString(m.getName(), 2, 2 + (count*10), 0x00ff00);
        		count++;
        	}
        }
        UIRender.renderAndUpdateFrames();
    }

}
