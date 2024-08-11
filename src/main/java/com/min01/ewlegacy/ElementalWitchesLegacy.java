package com.min01.ewlegacy;

import java.util.Calendar;

import com.min01.ewlegacy.config.EWConfig;
import com.min01.ewlegacy.init.EWBlocks;
import com.min01.ewlegacy.init.EWEffects;
import com.min01.ewlegacy.init.EWEntities;
import com.min01.ewlegacy.init.EWItems;
import com.min01.ewlegacy.init.EWParticles;
import com.min01.ewlegacy.init.EWSounds;
import com.min01.ewlegacy.proxy.ClientProxy;
import com.min01.ewlegacy.proxy.CommonProxy;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod(ElementalWitchesLegacy.MODID)
public class ElementalWitchesLegacy 
{
	public static final String MODID = "ewlegacy";
	
	public static final CreativeModeTab TAB = new CreativeModeTab(MODID)
	{
		@Override
		public ItemStack makeIcon() 
		{
			return new ItemStack(EWItems.HALLOWEEN_STAFF.get());
		}
		
		@Override
		public ResourceLocation getBackgroundImage() 
		{
			return new ResourceLocation(ElementalWitchesLegacy.MODID, "textures/gui/container/creative_inventory/tab_elementalwitchmod");
		}
	};
	
    public boolean isHalloween;
    public boolean isChristmas;
    
    @SuppressWarnings("deprecation")
	public static final CommonProxy PROXY = DistExecutor.runForDist(() -> ClientProxy::new, () -> CommonProxy::new);
	
	public ElementalWitchesLegacy() 
	{
		Calendar calendar = Calendar.getInstance();
        if(calendar.get(2) + 1 == 10 && calendar.get(5) >= 29 && calendar.get(5) <= 31) 
        {
            this.isHalloween = true;
        }
        if(calendar.get(2) + 1 == 12 && calendar.get(5) >= 24 && calendar.get(5) <= 26)
        {
            this.isChristmas = true;
        }
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        EWItems.ITEMS.register(bus);
        EWEffects.EFFECTS.register(bus);
        EWEntities.ENTITY_TYPES.register(bus);
        EWParticles.PARTICLES.register(bus);
        EWBlocks.BLOCKS.register(bus);
        EWBlocks.BLOCK_ENTITIES.register(bus);
        EWSounds.SOUNDS.register(bus);
        
        EWConfig.loadConfig(EWConfig.CONFIG, FMLPaths.CONFIGDIR.get().resolve("elemental-witches-legacy.toml").toString());
	}
}
