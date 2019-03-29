package codechicken.core.launch;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import codechicken.lib.config.ConfigFile;
import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.MetadataCollection;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.versioning.ArtifactVersion;
import cpw.mods.fml.common.versioning.VersionParser;
import cpw.mods.fml.common.versioning.VersionRange;

public class AlksDepLoaderModContainer extends DummyModContainer {
	public static ConfigFile config;

	public static void loadConfig() {
		if (config == null) {
			config = (new ConfigFile(new File(CodeChickenCorePlugin.minecraftDir, "config/AlkDepLoaderCore.cfg")))
					.setComment("AlkDepLoaderCore configuration file.");
		}

	}

	public AlksDepLoaderModContainer() {
		super(MetadataCollection.from(MetadataCollection.class.getResourceAsStream("/adlcmod.info"), "AlkDepLoaderCore")
				.getMetadataForId("AlkDepLoaderCore", (Map) null));
	}

	public List<ArtifactVersion> getDependants() {
		LinkedList<ArtifactVersion> deps = new LinkedList();
		if (!this.getVersion().contains("$")) {
			deps.add(VersionParser.parseVersionReference("Forge@[10.13.3,)"));
			deps.add(VersionParser.parseVersionReference("NotEnoughItems@[1.0.3,)"));
			deps.add(VersionParser.parseVersionReference("EnderStorage@[1.4.7,)"));
			deps.add(VersionParser.parseVersionReference("ChickenChunks@[1.3.4,)"));
			deps.add(VersionParser.parseVersionReference("Translocator@[1.1.1,)"));
			deps.add(VersionParser.parseVersionReference("WR-CBE|Core@[1.4.1,)"));
		}

		return deps;
	}

	public boolean registerBus(EventBus bus, LoadController controller) {
		bus.register(this);
		return true;
	}

	@Subscribe
	public void preInit(FMLPreInitializationEvent event) {
		//if (event.getSide().isClient()) {
			//LiquidTextures.init();
		//}

	}

	@Subscribe
	public void init(FMLInitializationEvent event) {
		if (event.getSide().isClient()) {
			//if (config.getTag("checkUpdates").getBooleanValue(true)) {
				//CCUpdateChecker.updateCheck(this.getModId());
			//}

			//FMLCommonHandler.instance().bus().register(new CCCEventHandler());
			//MinecraftForge.EVENT_BUS.register(new CCCEventHandler());
		}

	}

	public VersionRange acceptableMinecraftVersionRange() {
		return VersionParser.parseRange("[1.7.10]");
	}
}