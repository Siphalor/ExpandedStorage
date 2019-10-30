package ninjaphenix.expandedstorage.client.model;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.texture.Sprite;
import net.minecraft.util.math.MatrixStack;

@Environment(EnvType.CLIENT)
public class SingleChestModel extends Model
{
    protected ModelPart lid;
    protected ModelPart base;

    public SingleChestModel(int textureWidth, int textureHeight)
    {
        super(RenderLayer::getEntitySolid);
        this.textureWidth = textureWidth;
        this.textureHeight = textureHeight;
        lid = new ModelPart(this, 0, 0);
        base = new ModelPart(this, 0, 19);
    }

    public SingleChestModel()
    {
        this(64, 48);
        lid.addCuboid(0, 0, 0, 14, 5, 14, 0);
        lid.addCuboid(6, -1, 14, 2, 4, 1, 0);
        lid.setPivot(1, 9, 1);
        base.addCuboid(0, 0, 0, 14, 10, 14, 0);
        base.setPivot(1, 0, 1);
    }

    public void setLidPitch(float pitch)
    {
        pitch = 1.0f - pitch;
        lid.pitch = -((1.0F - pitch * pitch * pitch) * 1.5707964F);
    }

    public void render(MatrixStack stack, VertexConsumer consumer, float scale, int textureOffsetX, int textureOffsetY, Sprite texture)
    {
        base.render(stack, consumer, scale, textureOffsetX, textureOffsetY, texture);
        lid.render(stack, consumer, scale, textureOffsetX, textureOffsetY, texture);
    }

    // Fixes IDE errors
    @Override
    public void accept(ModelPart modelPart) { this.method_22696(modelPart); }

    @Override
    public void render(MatrixStack matrixStack, VertexConsumer vertexConsumer, int i, int i1, float v, float v1, float v2) { }
}