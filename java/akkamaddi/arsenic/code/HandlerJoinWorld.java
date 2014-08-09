package akkamaddi.arsenic.code;

import java.util.Random;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;

public class HandlerJoinWorld
{
    public static double rand;
    public static int range;

    public static RandomRange random = new RandomRange();

    public static final String HANDLED_KEY = "simpleores.spawn.handled";

    /**
     * This class allows zombies and skeletons to spawn holding/wearing Arsenic items.
     */
    @ForgeSubscribe
    public void EntityJoinWorldEvent(EntityJoinWorldEvent event)
    {
        rand = Math.random();
        range = random.nextInt(1, 70);

        if ((rand <= 0.03D) && ((event.entity instanceof EntityLiving)) && ((event.entity instanceof EntitySkeleton | event.entity instanceof EntityZombie)))
        {
            EntityLiving living = (EntityLiving)event.entity;

            if (range == 1)
            {
                living.setCurrentItemOrArmor(4, new ItemStack(ArsenicAndLace.arsenideBronzeHelm));
            }

            if (range == 2)
            {
                living.setCurrentItemOrArmor(3, new ItemStack(ArsenicAndLace.arsenideBronzeChest));
            }

            if (range == 3)
            {
                living.setCurrentItemOrArmor(2, new ItemStack(ArsenicAndLace.arsenideBronzeLegs));
            }

            if (range == 4)
            {
                living.setCurrentItemOrArmor(1, new ItemStack(ArsenicAndLace.arsenideBronzeBoots));
            }

            if (range == 5)
            {
                living.setCurrentItemOrArmor(4, new ItemStack(ArsenicAndLace.arsenideGoldHelm));
            }

            if (range == 6)
            {
                living.setCurrentItemOrArmor(3, new ItemStack(ArsenicAndLace.arsenideGoldChest));
            }

            if (range == 7)
            {
                living.setCurrentItemOrArmor(2, new ItemStack(ArsenicAndLace.arsenideGoldLegs));
            }

            if (range == 8)
            {
                living.setCurrentItemOrArmor(1, new ItemStack(ArsenicAndLace.arsenideGoldBoots));
            }

            if (range == 9)
            {
                living.setCurrentItemOrArmor(3, new ItemStack(ArsenicAndLace.oldLaceChest));
            }

            if (range == 10)
            {
                living.setCurrentItemOrArmor(3, new ItemStack(ArsenicAndLace.oldLaceChest));
            }

            if (range == 11)
            {
                living.setCurrentItemOrArmor(3, new ItemStack(ArsenicAndLace.oldLaceChest));
            }

            if (range == 12)
            {
                living.setCurrentItemOrArmor(3, new ItemStack(ArsenicAndLace.oldLaceChest));
            }

            if (range == 13)
            {
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.arsenicSword));
            }

            if (range == 14)
            {
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.arsenicShovel));
            }

            if (range == 15)
            {
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.arsenicAxe));
            }

            if (range == 16)
            {
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.arsenicPickaxe));
            }

            if (range == 17)
            {
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.arsenicHoe));
            }

            if (range == 18)
            {
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.arsenideBronzeSword));
            }

            if (range == 19)
            {
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.arsenideBronzeShovel));
            }

            if (range == 20)
            {
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.arsenideBronzeAxe));
            }

            if (range == 21)
            {
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.arsenideBronzePickaxe));
            }

            if (range == 22)
            {
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.arsenideBronzeHoe));
            }

            if (range == 23)
            {
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.arsenideGoldSword));
            }

            if (range == 24)
            {
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.arsenideGoldShovel));
            }

            if (range == 25)
            {
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.arsenideGoldAxe));
            }

            if (range == 26)
            {
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.arsenideGoldPickaxe));
            }

            if (range == 27)
            {
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.arsenideGoldHoe));
            }

            if (range == 28)
            {
                living.setCurrentItemOrArmor(3, new ItemStack(ArsenicAndLace.oldLaceChest));
            }

            if (range == 29)
            {
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.tenebriumSword));
            }

            if (range == 30)
            {
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.tenebriumShovel));
            }

            if (range == 31)
            {
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.tenebriumAxe));
            }

            if (range == 32)
            {
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.tenebriumPickaxe));
            }

            if (range == 33)
            {
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.tenebriumHoe));
            }

            if (range == 34)
            {
                living.setCurrentItemOrArmor(4, new ItemStack(ArsenicAndLace.tenebriumHelm));
            }

            if (range == 35)
            {
                living.setCurrentItemOrArmor(3, new ItemStack(ArsenicAndLace.tenebriumChest));
            }

            if (range == 36)
            {
                living.setCurrentItemOrArmor(2, new ItemStack(ArsenicAndLace.tenebriumLegs));
            }

            if (range == 37)
            {
                living.setCurrentItemOrArmor(1, new ItemStack(ArsenicAndLace.tenebriumBoots));
            }

            if (range == 38)
            {
                living.setCurrentItemOrArmor(4, new ItemStack(ArsenicAndLace.arsenideBronzeHelm));
                living.setCurrentItemOrArmor(3, new ItemStack(ArsenicAndLace.arsenideBronzeChest));
                living.setCurrentItemOrArmor(2, new ItemStack(ArsenicAndLace.arsenideBronzeLegs));
                living.setCurrentItemOrArmor(1, new ItemStack(ArsenicAndLace.arsenideBronzeBoots));
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.arsenideBronzeSword));
            }

            if (range == 39)
            {
                living.setCurrentItemOrArmor(4, new ItemStack(ArsenicAndLace.arsenideBronzeHelm));
                living.setCurrentItemOrArmor(3, new ItemStack(ArsenicAndLace.arsenideBronzeChest));
                living.setCurrentItemOrArmor(2, new ItemStack(ArsenicAndLace.arsenideBronzeLegs));
                living.setCurrentItemOrArmor(1, new ItemStack(ArsenicAndLace.arsenideBronzeBoots));
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.arsenideBronzeSword));
            }

            if (range == 40)
            {
                living.setCurrentItemOrArmor(4, new ItemStack(ArsenicAndLace.arsenideBronzeHelm));
                living.setCurrentItemOrArmor(1, new ItemStack(ArsenicAndLace.arsenideBronzeBoots));
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.arsenideBronzePickaxe));
            }

            if (range == 41)
            {
                living.setCurrentItemOrArmor(4, new ItemStack(ArsenicAndLace.arsenideBronzeHelm));
                living.setCurrentItemOrArmor(3, new ItemStack(ArsenicAndLace.arsenideBronzeChest));
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.arsenideBronzeAxe));
            }

            if (range == 42)
            {
                living.setCurrentItemOrArmor(2, new ItemStack(ArsenicAndLace.arsenideBronzeLegs));
                living.setCurrentItemOrArmor(1, new ItemStack(ArsenicAndLace.arsenideBronzeBoots));
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.arsenideBronzeShovel));
            }

            if (range == 43)
            {
                living.setCurrentItemOrArmor(4, new ItemStack(ArsenicAndLace.arsenideBronzeHelm));
                living.setCurrentItemOrArmor(1, new ItemStack(ArsenicAndLace.arsenideBronzeBoots));
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.arsenideBronzeHoe));
            }

            if (range == 44)
            {
                living.setCurrentItemOrArmor(4, new ItemStack(ArsenicAndLace.arsenideGoldHelm));
                living.setCurrentItemOrArmor(3, new ItemStack(ArsenicAndLace.arsenideGoldChest));
                living.setCurrentItemOrArmor(2, new ItemStack(ArsenicAndLace.arsenideGoldLegs));
                living.setCurrentItemOrArmor(1, new ItemStack(ArsenicAndLace.arsenideGoldBoots));
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.arsenideGoldSword));
            }

            if (range == 45)
            {
                living.setCurrentItemOrArmor(4, new ItemStack(ArsenicAndLace.arsenideGoldHelm));
                living.setCurrentItemOrArmor(3, new ItemStack(ArsenicAndLace.arsenideGoldChest));
                living.setCurrentItemOrArmor(2, new ItemStack(ArsenicAndLace.arsenideGoldLegs));
                living.setCurrentItemOrArmor(1, new ItemStack(ArsenicAndLace.arsenideGoldBoots));
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.arsenideGoldSword));
            }

            if (range == 46)
            {
                living.setCurrentItemOrArmor(4, new ItemStack(ArsenicAndLace.arsenideGoldHelm));
                living.setCurrentItemOrArmor(1, new ItemStack(ArsenicAndLace.arsenideGoldBoots));
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.arsenideGoldPickaxe));
            }

            if (range == 47)
            {
                living.setCurrentItemOrArmor(4, new ItemStack(ArsenicAndLace.arsenideGoldHelm));
                living.setCurrentItemOrArmor(3, new ItemStack(ArsenicAndLace.arsenideGoldChest));
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.arsenideGoldAxe));
            }

            if (range == 48)
            {
                living.setCurrentItemOrArmor(2, new ItemStack(ArsenicAndLace.arsenideGoldLegs));
                living.setCurrentItemOrArmor(1, new ItemStack(ArsenicAndLace.arsenideGoldBoots));
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.arsenideGoldShovel));
            }

            if (range == 49)
            {
                living.setCurrentItemOrArmor(4, new ItemStack(ArsenicAndLace.arsenideGoldHelm));
                living.setCurrentItemOrArmor(1, new ItemStack(ArsenicAndLace.arsenideGoldBoots));
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.arsenideGoldHoe));
            }

            if (range == 50)
            {
                living.setCurrentItemOrArmor(4, new ItemStack(ArsenicAndLace.tenebriumHelm));
                living.setCurrentItemOrArmor(3, new ItemStack(ArsenicAndLace.tenebriumChest));
                living.setCurrentItemOrArmor(2, new ItemStack(ArsenicAndLace.tenebriumLegs));
                living.setCurrentItemOrArmor(1, new ItemStack(ArsenicAndLace.tenebriumBoots));
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.tenebriumSword));
            }

            if (range == 51)
            {
                living.setCurrentItemOrArmor(4, new ItemStack(ArsenicAndLace.tenebriumHelm));
                living.setCurrentItemOrArmor(3, new ItemStack(ArsenicAndLace.tenebriumChest));
                living.setCurrentItemOrArmor(2, new ItemStack(ArsenicAndLace.tenebriumLegs));
                living.setCurrentItemOrArmor(1, new ItemStack(ArsenicAndLace.tenebriumBoots));
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.tenebriumSword));
            }

            if (range == 52)
            {
                living.setCurrentItemOrArmor(4, new ItemStack(ArsenicAndLace.tenebriumHelm));
                living.setCurrentItemOrArmor(1, new ItemStack(ArsenicAndLace.tenebriumBoots));
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.tenebriumPickaxe));
            }

            if (range == 53)
            {
                living.setCurrentItemOrArmor(4, new ItemStack(ArsenicAndLace.tenebriumHelm));
                living.setCurrentItemOrArmor(3, new ItemStack(ArsenicAndLace.tenebriumChest));
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.tenebriumAxe));
            }

            if (range == 54)
            {
                living.setCurrentItemOrArmor(2, new ItemStack(ArsenicAndLace.tenebriumLegs));
                living.setCurrentItemOrArmor(1, new ItemStack(ArsenicAndLace.tenebriumBoots));
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.tenebriumShovel));
            }

            if (range == 55)
            {
                living.setCurrentItemOrArmor(4, new ItemStack(ArsenicAndLace.tenebriumHelm));
                living.setCurrentItemOrArmor(1, new ItemStack(ArsenicAndLace.tenebriumBoots));
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.tenebriumHoe));
            }

            if (range == 56)
            {
                living.setCurrentItemOrArmor(4, new ItemStack(ArsenicAndLace.arsenideBronzeHelm));
                living.setCurrentItemOrArmor(3, new ItemStack(ArsenicAndLace.arsenideBronzeChest));
                living.setCurrentItemOrArmor(2, new ItemStack(ArsenicAndLace.arsenideBronzeLegs));
                living.setCurrentItemOrArmor(1, new ItemStack(ArsenicAndLace.arsenideBronzeBoots));
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.arsenicSword));
            }

            if (range == 57)
            {
                living.setCurrentItemOrArmor(4, new ItemStack(ArsenicAndLace.arsenideGoldHelm));
                living.setCurrentItemOrArmor(3, new ItemStack(ArsenicAndLace.arsenideGoldChest));
                living.setCurrentItemOrArmor(2, new ItemStack(ArsenicAndLace.arsenideGoldLegs));
                living.setCurrentItemOrArmor(1, new ItemStack(ArsenicAndLace.arsenideGoldBoots));
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.arsenicSword));
            }

            if (range == 58)
            {
                living.setCurrentItemOrArmor(4, new ItemStack(Item.helmetLeather));
                living.setCurrentItemOrArmor(3, new ItemStack(Item.plateLeather));
                living.setCurrentItemOrArmor(2, new ItemStack(Item.legsLeather));
                living.setCurrentItemOrArmor(1, new ItemStack(Item.bootsLeather));
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.arsenicSword));
            }

            if (range == 59)
            {
                living.setCurrentItemOrArmor(4, new ItemStack(Item.helmetLeather));
                living.setCurrentItemOrArmor(1, new ItemStack(Item.bootsLeather));
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.arsenicPickaxe));
            }

            if (range == 60)
            {
                living.setCurrentItemOrArmor(4, new ItemStack(Item.helmetLeather));
                living.setCurrentItemOrArmor(3, new ItemStack(Item.plateLeather));
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.arsenicAxe));
            }

            if (range == 61)
            {
                living.setCurrentItemOrArmor(2, new ItemStack(Item.legsLeather));
                living.setCurrentItemOrArmor(1, new ItemStack(Item.bootsLeather));
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.arsenicShovel));
            }

            if (range == 62)
            {
                living.setCurrentItemOrArmor(4, new ItemStack(Item.helmetLeather));
                living.setCurrentItemOrArmor(1, new ItemStack(Item.bootsLeather));
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.arsenicHoe));
            }

            if (range == 63)
            {
                living.setCurrentItemOrArmor(3, new ItemStack(ArsenicAndLace.oldLaceChest));
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.arsenicSword));
            }

            if (range == 64)
            {
                living.setCurrentItemOrArmor(3, new ItemStack(ArsenicAndLace.oldLaceChest));
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.arsenicPickaxe));
            }

            if (range == 65)
            {
                living.setCurrentItemOrArmor(3, new ItemStack(ArsenicAndLace.oldLaceChest));
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.arsenicAxe));
            }

            if (range == 66)
            {
                living.setCurrentItemOrArmor(3, new ItemStack(ArsenicAndLace.oldLaceChest));
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.arsenicShovel));
            }

            if (range == 67)
            {
                living.setCurrentItemOrArmor(3, new ItemStack(ArsenicAndLace.oldLaceChest));
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.arsenicHoe));
            }

            if (range == 68)
            {
                living.setCurrentItemOrArmor(3, new ItemStack(ArsenicAndLace.oldLaceChest));
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.arsenicSword));
            }

            if (range == 69)
            {
                living.setCurrentItemOrArmor(3, new ItemStack(ArsenicAndLace.oldLaceChest));
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.arsenideBronzeSword));
            }

            if (range == 70)
            {
                living.setCurrentItemOrArmor(3, new ItemStack(ArsenicAndLace.oldLaceChest));
                living.setCurrentItemOrArmor(0, new ItemStack(ArsenicAndLace.arsenideGoldSword));
            }
        }
    }
}

class RandomRange extends Random
{
    public int nextInt(int min, int max)
    {
        return nextInt(max - min + 1) + min;
    }
}
