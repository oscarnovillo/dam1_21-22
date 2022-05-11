package modelo.error;

import common.ConstantsErrors;
import modelo.common.ConstantsPOJO;

public enum ErrorProduct {
    DUPLICATED(ConstantsPOJO.CODE_P_DUPLICATED, ConstantsErrors.EL_PRODUCTO_YA_EXISTE),
    NOT_FOUND(ConstantsPOJO.CODE_P_NOTFOUND, ConstantsErrors.EL_PRODUCTO_NO_EXISTE),
    WRONG_PRICE(ConstantsPOJO.CODE_P_WRONGPRICE, ConstantsErrors.EL_PRECIO_TIENE_QUE_SER_MAYOR_QUE_0),
    WRONG_STOCK(ConstantsPOJO.CODE_P_WRONGSTOCK, ConstantsErrors.EL_STOCK_NO_PUEDE_SER_MENOR_DE_0),
    DUPLICATED_NAME(ConstantsPOJO.CODE_P_DUPLICATEDNAME, ConstantsErrors.YA_HAY_OTRO_PRODUCTO_CON_EL_NOMBRE_NUEVO);

    private final String code;
    private final String description;

    ErrorProduct(String code, String description) {
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
