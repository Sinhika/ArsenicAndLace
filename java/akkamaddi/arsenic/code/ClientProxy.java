package akkamaddi.arsenic.code;

public class ClientProxy extends akkamaddi.akkamaddiCore.api.ClientProxy
{
    @Override
    public void registerRenderers()
    {
        // This is for rendering entities and so forth later on
        //Armor Renderers
        ArsenicAndLace.rendererArsenideBronze = addArmor("arsenideBronze");
        ArsenicAndLace.rendererArsenideGold = addArmor("arsenideGold");
        ArsenicAndLace.rendererOldLace = addArmor("oldLace");
        ArsenicAndLace.rendererTenebrium = addArmor("tenebrium");
    }
} // end class ClientProxy