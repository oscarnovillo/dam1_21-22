package modelo.error;

import common.ConstantsErrors;
import modelo.common.ConstantsPOJO;

public enum ErrorPaying {
    INSUFFICIENT_MONEY(ConstantsPOJO.CODE_PAY_INSUFFICIENTMONEY, ConstantsErrors.NO_HAY_SUFICIENTE_DINERO_EN_EL_MONEDERO),
    PRODUCT_NOT_FOUND(ConstantsPOJO.CODE_PAY_PRODUCTNOTFOUND, ConstantsErrors.EL_PRODUCTO_NO_EXISTE),
    INSUFFICIENT_STOCK(ConstantsPOJO.CODE_PAY_INSUFFICIENTSTOCK, ConstantsErrors.NO_QUEDA_SUFICIENTE_STOCK),
    WRONG_QUANTITY(ConstantsPOJO.CODE_PAY_WRONGQUANTITY, ConstantsErrors.LA_CANTIDAD_TIENE_QUE_SER_MAYOR_QUE_0),
    WRONG_LEFT_QUANTITY(ConstantsPOJO.CODE_PAY_WRONGLEFTQUANTITY, ConstantsErrors.LA_CANTIDAD_NO_PUEDE_SER_MAYOR_QUE_LA_DEL_CARRITO),
    WALLET_DUPLICATED(ConstantsPOJO.CODE_PAY_DUPLICATED, ConstantsErrors.EL_MONEDERO_YA_EXISTE),
    WALLET_NOT_FOUND(ConstantsPOJO.CODE_PAY_WALLETNOTFOUND, ConstantsErrors.EL_MONEDERO_NO_EXISTE);

    private final String code;
    private final String description;

    ErrorPaying(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return code + ConstantsPOJO.COLON + description;
    }
}
