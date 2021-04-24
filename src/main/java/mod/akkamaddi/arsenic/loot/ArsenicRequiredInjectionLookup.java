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
        this.put("desert_pyramid", "desert_pyramid");
        this.put("jungle_temple", "jungle_temple");
        this.AddStrongholdAliases();
    } // end ctor

    /**
     * adds the optional injection tables if enableChestLoot is true.
     */
    public void AddOptionalTables()
    {
        this.put("abandoned_mineshaft", "abandoned_mineshaft");
        
    } // end AddOptionalTables
    
} // end class
