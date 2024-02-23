package baguchan.nether_invader.data;

import baguchan.nether_invader.NetherInvader;
import baguchan.nether_invader.registry.ModBiomes;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class CustomTagGenerator {
    public static class BiomeTagGenerator extends BiomeTagsProvider {
        public static final TagKey<Biome> HAS_NETHER_PORTAL = create("has_structure/nether_portal");

        public BiomeTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> future, @Nullable ExistingFileHelper existingFileHelper) {
            super(output, future, NetherInvader.MODID, existingFileHelper);
        }

        private static TagKey<Biome> create(String p_207631_) {
            return TagKey.create(Registries.BIOME, new ResourceLocation(NetherInvader.MODID, p_207631_));
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            tag(BiomeTags.IS_NETHER).add(ModBiomes.CRIMSON_FOREST, ModBiomes.NETHER_WASTES);
            tag(HAS_NETHER_PORTAL).add(ModBiomes.CRIMSON_FOREST, ModBiomes.NETHER_WASTES);

            //vanilla
            tag(BiomeTags.WITHOUT_ZOMBIE_SIEGES).add(ModBiomes.CRIMSON_FOREST, ModBiomes.NETHER_WASTES);
            tag(BiomeTags.WITHOUT_PATROL_SPAWNS).add(ModBiomes.CRIMSON_FOREST, ModBiomes.NETHER_WASTES);
            tag(BiomeTags.WITHOUT_WANDERING_TRADER_SPAWNS).add(ModBiomes.CRIMSON_FOREST, ModBiomes.NETHER_WASTES);
        }

        @Override
        public String getName() {
            return "NetherInvader Biome Tags";
        }
    }
}