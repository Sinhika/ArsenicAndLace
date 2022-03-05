package mod.akkamaddi.arsenic.client.particle;

import javax.annotation.Nullable;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;

public class NecroticFlameParticle extends TextureSheetParticle
{
    private final SpriteSet sprites;

    public NecroticFlameParticle(ClientLevel level, double xOrigin, double yOrigin, double zOrigin,
            double xVelocity, double yVelocity, double zVelocity, final SpriteSet sprites)
    {
        super(level, xOrigin, yOrigin, zOrigin, xVelocity, yVelocity, zVelocity);
        
        // Set some basic params
        this.setSize(0.01f, 0.01f);
        this.gravity = 0.4f;
        this.sprites = sprites;

        // Set this here otherwise NPE will be thrown since rendering happens before initial tick
        this.setSpriteFromAge(this.sprites);    }

    @Override
    public ParticleRenderType getRenderType()
    {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    @Override
    public void tick()
    {
        super.tick();
        // Call every tick to change the particle over time
        this.setSpriteFromAge(this.sprites);
    }

    /**
     * The provider used to register the factory to create the rendered {@link DrippingAshParticle} instance.
     */
    public static class NecroticFlameParticleProvider implements ParticleProvider<SimpleParticleType>
    {
        private final SpriteSet sprites;

        /**
         * Constructor to be passed as a method reference to
         * {@link net.minecraft.client.particle.ParticleEngine#register(ParticleType, ParticleEngine.SpriteParticleRegistration)}.
         *
         * @param sprites the referenced sprites that will be used for rendering
         */
        public NecroticFlameParticleProvider(SpriteSet sprites)
        {
            this.sprites = sprites;
        }

        @Nullable
        @Override
        public Particle createParticle(final SimpleParticleType pType, final ClientLevel pLevel, 
                                        final double pX, final double pY, final double pZ,
                                        final double pXSpeed, final double pYSpeed, final double pZSpeed)
        {
            return new NecroticFlameParticle(pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed, this.sprites);
        }

        
    } // end class NecroticFlameParticleProvider$NecroticFlameParticle
    
} // end class NecroticFlameParticle
