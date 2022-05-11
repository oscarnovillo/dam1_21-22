package modelo.error;

import common.ConstantsErrors;
import modelo.common.ConstantsPOJO;

public enum ErrorIngredient {
    DUPLICATED(ConstantsPOJO.CODE_I_DUPLICATED, ConstantsErrors.YA_APARECE_EN_LA_LISTA),
    NOT_FOUND(ConstantsPOJO.CODE_P_NOTFOUND, ConstantsErrors.EL_PRODUCTO_NO_EXISTE);

    private final String code;
    private final String description;

    ErrorIngredient(String code, String description) {
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
