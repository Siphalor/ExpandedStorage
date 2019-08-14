package ninjaphenix.cursedchests.api.block.entity;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DefaultedList;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import ninjaphenix.cursedchests.api.Registries;

public class OldChestBlockEntity extends BaseChestBlockEntity
{

    public OldChestBlockEntity()
    {
        this(Registry.BLOCK_ENTITY.get(new Identifier("cursedchests", "old_cursed_chest")), new Identifier("cursedchests", "null"));
    }

    public OldChestBlockEntity(Identifier block) { this(Registry.BLOCK_ENTITY.get(new Identifier("cursedchests", "old_cursed_chest")), block); }

    public OldChestBlockEntity(BlockEntityType type, Identifier block) { super(type, block); }

    @Override
    protected void initialize(Identifier block)
    {
        this.block = block;
        defaultContainerName = Registries.OLD.get(block).getContainerName();
        inventorySize = Registries.OLD.get(block).getSlotCount();
        inventory = DefaultedList.ofSize(inventorySize, ItemStack.EMPTY);
        SLOTS = new int[inventorySize];
        for (int i = 0; i < inventorySize; i++) SLOTS[i] = i;
    }
}
