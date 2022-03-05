package mod.akkamaddi.arsenic.client.particle;

import javax.annotation.Nullable;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.RisingParticle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class NecroticFlameParticle extends RisingParticle
{
    public NecroticFlameParticle(ClientLevel level, double xOrigin, double yOrigin, double zOrigin,
            double xVelocity, double yVelocity, double zVelocity)
    {
        super(level, xOrigin, yOrigin, zOrigin, xVelocity, yVelocity, zVelocity);

        // Set this here otherwise NPE will be thrown since rendering happens before initial tick
//        this.setSpriteFromAge(this.sprites);    
    }

    @Override
    public ParticleRenderType getRenderType()
    {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    @Override
    public void move(double pX, double pY, double pZ) 
    {
        this.setBoundingBox(this.getBoundingBox().move(pX, pY, pZ));
        this.setLocationFromBoundingbox();
    }

    @Override
    public float getQuadSize(float pScaleFactor) 
    {
        float f = ((float)this.age + pScaleFactor) / (float)this.lifetime;
        return this.quadSize * (1.0F - f * f * 0.5F);
    }

    @Override
    public int getLightColor(float pPartialTick) {
        float f = ((float)this.age + pPartialTick) / (float)this.lifetime;
        f = Mth.clamp(f, 0.0F, 1.0F);
        int i = super.getLightColor(pPartialTick);
        int j = i & 255;
        int k = i >> 16 & 255;
        j += (int)(f * 15.0F * 16.0F);
        if (j > 240) {
           j = 240;
        }

        return j | k << 16;
     }

    /**
     * The provider used to register the factory to create the rendered {@link DrippingAshParticle} instance.
     */
    @OnlyIn(Dist.CLIENT)
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
            NecroticFlameParticle my_particle = 
                    new NecroticFlameParticle(pLevel, pX, pY, pZ, pXSpeed, pYSpeed, pZSpeed);
            my_particle.pickSprite(this.sprites);
            my_particle.scale(0.5F);
            return my_particle;
        }

        
    } // end class NecroticFlameParticleProvider$NecroticFlameParticle
    
} // end class NecroticFlameParticle
