package mod.akkamaddi.arsenic.init;

import mod.akkamaddi.arsenic.ArsenicAndLace;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModParticleTypes
{

    public static final DeferredRegister<ParticleType<?>> PARTICLETYPES = 
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES , ArsenicAndLace.MODID);
    
    public static final RegistryObject<SimpleParticleType> necrotic_flame = PARTICLETYPES.register("necrotic_flame",
            () -> new SimpleParticleType(false));
} // end class
