package com.min01.ewlegacy.config;

import java.io.File;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;

import net.minecraftforge.common.ForgeConfigSpec;

public class EWConfig
{
    private static ForgeConfigSpec.Builder BUILDER;
    public static ForgeConfigSpec CONFIG;
    
    public static ForgeConfigSpec.BooleanValue canDarkWitchTurnToNight;
    public static ForgeConfigSpec.BooleanValue canLightWitchTurnToDay;
    public static ForgeConfigSpec.BooleanValue canDarkWitchDestroyLight;
    public static ForgeConfigSpec.BooleanValue spawnFireTemple;
    public static ForgeConfigSpec.BooleanValue spawnLightningTemple;
    public static ForgeConfigSpec.BooleanValue spawnWaterTemple;
    public static ForgeConfigSpec.BooleanValue spawnAirTemple;
    public static ForgeConfigSpec.BooleanValue spawnEarthTemple;
    public static ForgeConfigSpec.BooleanValue spawnIceTemple;
    public static ForgeConfigSpec.BooleanValue spawnNatureTemple;
    public static ForgeConfigSpec.BooleanValue spawnLightTemple;
    public static ForgeConfigSpec.BooleanValue spawnDarkTemple;
    public static ForgeConfigSpec.BooleanValue darkWitchVsLightWitch;
    public static ForgeConfigSpec.BooleanValue fireWitchVsWaterWitch;
    public static ForgeConfigSpec.BooleanValue elementalsVsWitches;
    
    public static void loadConfig(ForgeConfigSpec config, String path) 
    {
        CommentedFileConfig file = CommentedFileConfig.builder(new File(path)).sync().autosave().writingMode(WritingMode.REPLACE).build();
        file.load();
        config.setConfig(file);
    }
    
    static 
    {
    	BUILDER = new ForgeConfigSpec.Builder();
    	EWConfig.init(EWConfig.BUILDER);
        CONFIG = EWConfig.BUILDER.build();
    }
	
    public static void init(ForgeConfigSpec.Builder config) 
    {
    	config.push("Settings");
    	EWConfig.canDarkWitchTurnToNight = config.comment("define whether dark witch can turn world to night").define("canDarkWitchTurnToNight", true);
    	EWConfig.canLightWitchTurnToDay = config.comment("define whether light witch can turn world to day").define("canLightWitchTurnToDay", true);
    	EWConfig.canDarkWitchDestroyLight = config.comment("define whether dark witch can destroy light source blocks").define("canDarkWitchDestroyLight", true);

    	EWConfig.darkWitchVsLightWitch = config.comment("define whether dark witch and light witch fight each other").define("darkWitchVsLightWitch", true);
    	EWConfig.fireWitchVsWaterWitch = config.comment("define whether fight witch and water witch fight each other").define("fireWitchVsWaterWitch", true);
    	EWConfig.elementalsVsWitches = config.comment("define whether any elemetal witch and vanilla witch fight each other").define("elementalsVsWitches", true);
        config.pop();
    }
}
