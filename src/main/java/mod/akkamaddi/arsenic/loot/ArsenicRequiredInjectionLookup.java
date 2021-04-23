package mod.akkamaddi.arsenic.loot;

import mod.alexndr.simplecorelib.helpers.InjectionTableLookup;

@SuppressWarnings("serial")
public class ArsenicRequiredInjectionLookup extends InjectionTableLookup
{
    /**
     * create only the tables absolutely required so that player can 
     * obtain old_lace now and then.
     * "required" list is very short, so nullify most entries.
     * we keep only "stronghold", "desert_pyramid", and "jungle_temple".
     */
    public ArsenicRequiredInjectionLookup()
    {
        super();
        this.replace("bastion_bridge", null);
        this.replace("bastion_hoglin_stable", null);
        this.replace("bastion_other", null);
        this.replace("bastion_treasure", null);
        this.replace("buried_treasure", null);
        this.replace("nether_bridge", null);
        this.replace("pillager_outpost", null);
        this.replace("shipwreck_map", null);
        this.replace("shipwreck_supply", null);
        this.replace("shipwreck_treasure", null);
        this.replace("underwater_ruin_big", null);
        this.replace("underwater_ruin_small", null);
        this.replace("woodland_mansion", null);
        this.replace("village_savanna_house", null);
        this.replace("village_plains_house", null);
        this.replace("village_desert_house", null);
        this.replace("village_snowy_house", null);
        this.replace("village_taiga_house", null);

        this.put("abandoned_mineshaft", null);
        this.put("spawn_bonus_chest", null);
        this.put("nether", null);
    } // end ctor

    /**
     * adds the optional injection tables if enableChestLoot is true.
     */
    public void AddOptionalTables()
    {
        
    } // end AddOptionalTables
    
} // end class
