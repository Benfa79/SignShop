package org.wargamer2010.signshop.operations;

public class giveOwnerMoney implements SignShopOperation {    
    @Override
    public Boolean setupOperation(SignShopArguments ssArgs) {
        return true;
    }
    
    @Override
    public Boolean checkRequirements(SignShopArguments ssArgs, Boolean activeCheck) {
        return true;
    }
    
    @Override
    public Boolean runOperation(SignShopArguments ssArgs) {
        Float fPricemod = ssArgs.ssPlayer.getPlayerPricemod(ssArgs.sOperation, true);
        Float fPrice = (ssArgs.fPrice * fPricemod);
        Boolean bTransaction = ssArgs.ssOwner.mutateMoney(fPrice);
        if(!bTransaction)
            ssArgs.ssPlayer.sendMessage("The money transaction failed, please contact the System Administrator");
        return bTransaction;
    }
}
