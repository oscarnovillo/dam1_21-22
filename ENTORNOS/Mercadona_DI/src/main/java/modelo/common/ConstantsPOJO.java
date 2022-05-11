package modelo.common;

public class ConstantsPOJO {
    private ConstantsPOJO() {
    }

    public static final String NOMBRE = "Nombre = '";
    public static final String QUOTE = "'";
    public static final String CLOSING_BRACKET = "}\n";
    public static final String COLON = ": ";

    //ERRORS
    public static final String CODE_C_LOWDISCOUNT = "CODE_C_LOWDISCOUNT";
    public static final String CODE_C_HIGHDISCOUNT = "CODE_C_HIGHDISCOUNT";
    public static final String CODE_I_DUPLICATED = "CODE_I_DUPLICATED";
    public static final String CODE_PAY_INSUFFICIENTMONEY = "CODE_PAY_INSUFFICIENTMONEY";
    public static final String CODE_PAY_PRODUCTNOTFOUND = "CODE_PAY_PRODUCTNOTFOUND";
    public static final String CODE_PAY_INSUFFICIENTSTOCK = "CODE_PAY_INSUFFICIENTSTOCK";
    public static final String CODE_PAY_WRONGQUANTITY = "CODE_PAY_WRONGQUANTITY";
    public static final String CODE_PAY_WRONGLEFTQUANTITY = "CODE_PAY_WRONGLEFTQUANTITY";
    public static final String CODE_PAY_DUPLICATED = "CODE_PAY_DUPLICATED";
    public static final String CODE_PAY_WALLETNOTFOUND = "CODE_PAY_WALLETNOTFOUND";
    public static final String CODE_PAY_NOTADDED = "CODE_PAY_NOTADDED";
    public static final String CODE_PAY_NOTDELETED = "CODE_PAY_NOTDELETED";
    public static final String CODE_PAY_NOTSAVED = "CODE_PAY_NOTSAVED";
    public static final String CODE_P_DUPLICATED = "E_P_DUPLICATED";
    public static final String CODE_P_NOTADDED = "E_P_NOTADDED";
    public static final String CODE_P_NOTFOUND = "E_P_NOTFOUND";
    public static final String CODE_P_WRONGPRICE = "E_P_WRONGPRICE";
    public static final String CODE_P_WRONGSTOCK = "E_P_WRONGSTOCK";
    public static final String CODE_P_DUPLICATEDNAME = "E_P_DUPLICATEDNAME";
    public static final String CODE_C_DUPLICATED = "E_C_DUPLICATED";
    public static final String CODE_C_NOTFOUND = "E_C_NOTFOUND";
    public static final String CODE_C_NOTADDED = "E_C_NOTADDED";

    //PRODUCT
    public static final String PRODUCTO = "Producto\n{";
    public static final String PRECIO = ", precio = ";
    public static final String EURO = "€";
    public static final String STOCK = ", stock = ";
    public static final String UNIDADES = " unidades";
    public static final String CADUCIDAD = "caducidad = ";
    public static final String DATE_TIME_FORMAT = "dd-MM-yyyy, HH:mm:ss";
    public static final String INGREDIENTE = "Ingrediente{";

    //CLIENT
    public static final String CLIENTES = "Clientes{";
    public static final String DNI = ", DNI = ";
    public static final String DESCUENTO = ", descuento = ";
    public static final String PERCENTAGE = "%";

    //WALLET
    public static final String DINERO = ", Dinero=";
    public static final String CODIGO = "Código='";
    public static final String MONEDERO = "Monedero{";

    //SELECTED PRODUCT
    public static final String UNIDADES_SELECCIONADAS = ", unidades = ";
    public static final String PRECIO_TOTAL = ", precio total = ";
}
