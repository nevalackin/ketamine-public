package net.minecraft.client.renderer.entity.layers;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderDragon;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class LayerEnderDragonEyes extends LayerRenderer<EntityDragon>
{
    private static final ResourceLocation TEXTURE = new ResourceLocation("textures/entity/enderdragon/dragon_eyes.png");
    private final RenderDragon dragonRenderer;

    public LayerEnderDragonEyes(RenderDragon dragonRendererIn)
    {
        this.dragonRenderer = dragonRendererIn;
    }

    public void doRenderLayer(EntityDragon entitylivingbaseIn, float p_177141_2_, float p_177141_3_, float partialTicks, float p_177141_5_, float p_177141_6_, float p_177141_7_, float scale)
    {
        this.dragonRenderer.bindTexture(TEXTURE);
        GL11.glEnable(GL11.GL_BLEND);
        GlStateManager.disableAlpha();
        GL11.glBlendFunc(1, 1);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDepthFunc(514);
        int i = 61680;
        int j = i % 65536;
        int k = i / 65536;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j / 1.0F, (float)k / 1.0F);
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.dragonRenderer.getMainModel().render(entitylivingbaseIn, p_177141_2_, p_177141_3_, p_177141_5_, p_177141_6_, p_177141_7_, scale);
        this.dragonRenderer.func_177105_a(entitylivingbaseIn, partialTicks);
        GL11.glDisable(GL11.GL_BLEND);
        GlStateManager.enableAlpha();
        GL11.glDepthFunc(515);
    }

    public boolean shouldCombineTextures()
    {
        return false;
    }
}
