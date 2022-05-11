package modelo.error;

import common.ConstantsErrors;
import modelo.common.ConstantsPOJO;

public enum ErrorClientAccounts {
    DUPLICATED(ConstantsPOJO.CODE_C_DUPLICATED, ConstantsErrors.DNI_VINCULADO_CON_OTRA_CUENTA),
    NOT_FOUND(ConstantsPOJO.CODE_C_NOTFOUND, ConstantsErrors.NO_HAY_NINGUN_CLIENTE_CON_ESE_DNI),
    LOW_DISCOUNT(ConstantsPOJO.CODE_C_LOWDISCOUNT, ConstantsErrors.EL_DESCUENTO_TIENE_QUE_SER_MAYOR_QUE_0),
    HIGH_DISCOUNT(ConstantsPOJO.CODE_C_HIGHDISCOUNT, ConstantsErrors.EL_DESCUENTO_TIENE_QUE_SER_MENOR_QUE_100);

    private final String code;
    private final String description;

    ErrorClientAccounts(String code, String description) {
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
