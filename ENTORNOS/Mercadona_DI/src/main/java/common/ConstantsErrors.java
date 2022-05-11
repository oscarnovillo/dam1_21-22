package common;

public class ConstantsErrors {
    private ConstantsErrors() {
    }

    public static final String EL_DESCUENTO_TIENE_QUE_SER_MAYOR_QUE_0 = "El descuento tiene que ser mayor que 0.";
    public static final String EL_DESCUENTO_TIENE_QUE_SER_MENOR_QUE_100 = "El descuento tiene que ser menor que 100.";
    public static final String YA_APARECE_EN_LA_LISTA = "Ya aparece en la lista.";
    public static final String LOS_MINUTOS_NO_PUEDEN_SER_MENOR_DE_0 = "Los minutos no pueden ser menor de 0.";

    //WALLET ERRORS
    public static final String NO_HAY_SUFICIENTE_DINERO_EN_EL_MONEDERO = "No hay suficiente dinero en el monedero.";
    public static final String EL_MONEDERO_YA_EXISTE = "El monedero ya existe.";
    public static final String EL_MONEDERO_NO_EXISTE = "El monedero no existe.";

    //CLIENT ACCOUNT ERRORS
    public static final String NO_HAY_NINGUN_CLIENTE_CON_ESE_DNI = "No hay ningún cliente con ese DNI.";
    public static final String DNI_VINCULADO_CON_OTRA_CUENTA = "El DNI ya está vinculado con otra cuenta.";

    //PRODUCT ERRORS
    public static final String LA_CANTIDAD_TIENE_QUE_SER_MAYOR_QUE_0 = "La cantidad tiene que ser mayor que 0.";
    public static final String LA_CANTIDAD_NO_PUEDE_SER_MAYOR_QUE_LA_DEL_CARRITO = "La cantidad no puede ser mayor que la del carrito.";
    public static final String NO_QUEDA_SUFICIENTE_STOCK = "No queda suficiente stock.";
    public static final String EL_PRODUCTO_YA_EXISTE = "El producto ya existe.";
    public static final String EL_PRODUCTO_NO_EXISTE = "El producto no existe.";
    public static final String EL_PRECIO_TIENE_QUE_SER_MAYOR_QUE_0 = "El precio tiene que ser mayor que 0.";
    public static final String EL_STOCK_NO_PUEDE_SER_MENOR_DE_0 = "El stock no puede ser menor de 0.";
    public static final String YA_HAY_OTRO_PRODUCTO_CON_EL_NOMBRE_NUEVO = "Ya hay otro producto con el nombre nuevo.";
}
