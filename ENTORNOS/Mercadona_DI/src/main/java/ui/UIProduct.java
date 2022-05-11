package ui;

import common.ConstantsErrors;
import jakarta.inject.Inject;
import modelo.Ingredient;
import modelo.Product;
import modelo.ProductNormal;
import modelo.ProductWithExpirationDate;
import modelo.error.ErrorIngredient;
import modelo.error.ErrorProduct;
import servicios.ServicesIngredients;
import servicios.ServicesPreviousPurchase;
import servicios.ServicesProducts;
import ui.common.ConstantsGeneral;
import ui.common.ConstantsProducts;
import ui.common.InputControl;

import java.time.LocalDateTime;
import java.util.Scanner;

public class UIProduct {
    private final ServicesPreviousPurchase servicesPreviousPurchase;
    private final ServicesProducts products;
    private final ServicesIngredients servicesIngredients;
    private final InputControl inputControl;
    private final Scanner sc;

    @Inject
    public UIProduct(ServicesPreviousPurchase servicesPreviousPurchase
            , ServicesProducts products
            , ServicesIngredients servicesIngredients
            , InputControl inputControl
            , Scanner sc) {
        this.servicesPreviousPurchase = servicesPreviousPurchase;
        this.products = products;
        this.servicesIngredients = servicesIngredients;
        this.inputControl = inputControl;
        this.sc= sc;
    }

    public void adminProductMenu() {
        int option;
        do {
            System.out.println(ConstantsProducts.PRODUCT_MENU);
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1: //Ver lista de productos
                    showList();
                    break;
                case 2: //Añadir producto
                    addProduct();
                    break;
                case 3: //Borrar producto
                    deleteProduct();
                    break;
                case 4: //Cambiar nombre
                    changeName();
                    break;
                case 5://Cambiar precio
                    changePrice();
                    break;
                case 6: //Aumentar stock
                    increaseStock();
                    break;
                case 7: //Disminuir stock
                    decreaseStock();
                    break;
                case 8: //Añadir ingredientes
                    addIngredient();
                    break;
                case 9: //Mostrar lista de ingredientes
                    showIngredientList();
                    break;
                case 10: //Mostrar productos con 1 ingrediente
                    showProductsWithOneIngredient();
                    break;
                case 11: //Mostrar productos más vendidos
                    showBestSellingProducts();
                    break;
                default:
                    if (option != 0) {
                        System.out.println(ConstantsGeneral.OPCION_NO_DISPONIBLE);
                        System.out.println(ConstantsGeneral.ELIGE_OTRA_OPCION);
                    }
            }
        } while (option != 0);
    }

    private void showBestSellingProducts() {
        servicesPreviousPurchase.sortProductPerQuantitySold()
                .forEach((s, integer) ->
                        System.out.println(s + ": " + integer));
    }

    private void showIngredientList() {

        System.out.println(ConstantsProducts.INTRODUCE_EL_NOMBRE_DEL_PRODUCTO);
        String name = sc.nextLine();
        Product product = new ProductNormal(name);

        if (servicesIngredients.showIngredientsPerProduct(product) == null) {
            System.out.println(ConstantsErrors.EL_PRODUCTO_NO_EXISTE);
        } else {
            System.out.println(servicesIngredients.showIngredientsPerProduct(product));
        }
    }

    private void showProductsWithOneIngredient() {
        products.showProductsWithOneIngredient()
                .forEach(product ->
                        System.out.println(product.getName() +
                                ConstantsGeneral.LINE_BREAK + product.getIngredients()));
    }

    private void addIngredient() {

        System.out.println(ConstantsProducts.INTRODUCE_EL_NOMBRE_DEL_PRODUCTO);
        String productName = sc.nextLine();
        Product product = new ProductNormal(productName);
        System.out.println(ConstantsProducts.INTRODUCE_EL_NOMBRE_DEL_NUEVO_INGREDIENTE);
        String ingredientName = sc.nextLine().toUpperCase();
        Ingredient ingredient = new Ingredient(ingredientName);

        ErrorIngredient error = products.addIngredient(product, ingredient);

        if (error == null) {
            System.out.println(ConstantsProducts.EL_INGREDIENTE_SE_HA_ANADIDO_CORRECTAMENTE);
        } else {
            System.out.println(error.getDescription());
        }
    }

    private void showList() {
        System.out.println(ConstantsProducts.VER_PRODUCTOS);
        if (products.isEmptyProductList()) {
            System.out.println(ConstantsGeneral.LISTA_VACIA);
        } else {
            System.out.println(products.printProductList());
        }
    }

    private void addProduct() {
        System.out.println(ConstantsProducts.ANADIR_PRODUCTO);

        Product product = getNewProduct();

        ErrorProduct error = products.addProduct(product);

        if (error == null) {
            System.out.println(ConstantsProducts.EL_PRODUCTO_SE_HA_ANADIDO_CORRECTAMENTE);
        } else {
            System.out.println(error.getDescription());
        }
        System.out.println(products.printProductList());
    }

    private Product getNewProduct() {

        System.out.println(ConstantsProducts.INTRODUCE_EL_NOMBRE_DEL_PRODUCTO);
        String name = sc.nextLine();

        double price = inputControl.getDouble(ConstantsProducts.INTRODUCE_EL_PRECIO);
        while (price <= 0) {
            System.out.println(ConstantsErrors.EL_PRECIO_TIENE_QUE_SER_MAYOR_QUE_0);
            price = inputControl.getDouble(ConstantsProducts.INTRODUCE_OTRO_PRECIO);
        }

        int stock = inputControl.getInt(ConstantsProducts.INTRODUCE_LA_CANTIDAD_DE_EXISTENCIAS);
        while (stock < 0) {
            System.out.println(ConstantsErrors.EL_STOCK_NO_PUEDE_SER_MENOR_DE_0);
            stock = inputControl.getInt(ConstantsProducts.INTRODUCE_OTRA_CANTIDAD);
        }

        return createNewProduct(name, price, stock);
    }

    private Product createNewProduct(String name, double price, int stock) {


        Product product = null;
        String answer;
        do {
            System.out.println(ConstantsProducts.TIENE_FECHA_DE_CADUCIDAD);
            answer = sc.nextLine().toUpperCase();
            switch (answer) {
                case ConstantsGeneral.SI:
                    int expiry = inputControl.getInt(ConstantsProducts.INTRODUCE_LOS_MINUTOS_QUE_QUEDAN_PARA_QUE_CADUQUE);
                    while (expiry < 0) {
                        System.out.println(ConstantsErrors.LOS_MINUTOS_NO_PUEDEN_SER_MENOR_DE_0);
                        expiry = inputControl.getInt(ConstantsProducts.INTRODUCE_OTRA_CANTIDAD);
                    }
                    LocalDateTime expirationDate = LocalDateTime.now().plusMinutes(expiry);
                    product = new ProductWithExpirationDate(name, price, stock, expirationDate);
                    break;
                case ConstantsGeneral.NO:
                    product = new ProductNormal(name, price, stock);
                    break;
                default:
                    System.out.println(ConstantsGeneral.OPCION_NO_DISPONIBLE);
                    System.out.println(ConstantsGeneral.ELIGE_OTRA_OPCION);
            }
        } while (!answer.equalsIgnoreCase(ConstantsGeneral.SI) && !answer.equalsIgnoreCase(ConstantsGeneral.NO));

        return product;
    }

    private void deleteProduct() {


        System.out.println(ConstantsProducts.BORRAR_PRODUCTO);

        System.out.println(ConstantsProducts.INTRODUCE_EL_NOMBRE_DEL_PRODUCTO);
        String name = sc.nextLine().toUpperCase();

        ErrorProduct error = products.deleteProduct(name);

        if (error == null) {
            System.out.println(ConstantsProducts.EL_PRODUCTO_SE_HA_ELIMINADO_CORRECTAMENTE);
        } else {
            System.out.println(error.getDescription());
        }

        System.out.println(products.printProductList());
    }

    private void changeName() {


        System.out.println(ConstantsProducts.CAMBIAR_NOMBRE);

        System.out.println(ConstantsProducts.INTRODUCE_EL_NOMBRE_DEL_PRODUCTO);
        String name = sc.nextLine().toUpperCase();

        System.out.println(ConstantsProducts.INTRODUCE_EL_NOMBRE_NUEVO);
        String newName = sc.nextLine().toUpperCase();

        ErrorProduct error = products.setName(name, newName);
        if (error == null) {
            System.out.println(ConstantsProducts.EL_NOMBRE_SE_HA_CAMBIADO_CORRECTAMENTE);
        } else {
            System.out.println(error.getDescription());
        }

        System.out.println(products.printProductList());
    }

    private void changePrice() {


        System.out.println(ConstantsProducts.CAMBIAR_PRECIO);

        System.out.println(ConstantsProducts.INTRODUCE_EL_NOMBRE_DEL_PRODUCTO);
        String name = sc.nextLine().toUpperCase();

        double newPrice = inputControl.getDouble(ConstantsProducts.INTRODUCE_EL_PRECIO_NUEVO);
        while (newPrice <= 0) {
            System.out.println(ConstantsErrors.EL_PRECIO_TIENE_QUE_SER_MAYOR_QUE_0);
            newPrice = inputControl.getDouble(ConstantsProducts.INTRODUCE_OTRO_PRECIO);
        }

        ErrorProduct error = products.setPrice(name, newPrice);
        if (error == null) {
            System.out.println(ConstantsProducts.EL_PRECIO_SE_HA_CAMBIADO_CORRECTAMENTE);
        } else {
            System.out.println(error.getDescription());
        }

        System.out.println(products.printProductList());

    }

    private void increaseStock() {


        System.out.println(ConstantsProducts.AUMENTAR_STOCK);

        System.out.println(ConstantsProducts.INTRODUCE_EL_NOMBRE_DEL_PRODUCTO);
        String name = sc.nextLine().toUpperCase();

        int newStock = inputControl.getInt(ConstantsProducts.INTRODUCE_UNIDADES_QUE_QUIERES_ANADIR);
        ErrorProduct error = products.increaseStock(name, newStock);
        if (error == null) {
            System.out.println(ConstantsProducts.EL_STOCK_SE_HA_CAMBIADO_CORRECTAMENTE);
        } else {
            System.out.println(error.getDescription());
        }

        System.out.println(products.printProductList());

    }

    private void decreaseStock() {


        System.out.println(ConstantsProducts.DISMINUIR_STOCK);

        System.out.println(ConstantsProducts.INTRODUCE_EL_NOMBRE_DEL_PRODUCTO);
        String name = sc.nextLine().toUpperCase();

        int newStock = inputControl.getInt(ConstantsProducts.INTRODUCE_UNIDADES_QUE_QUIERES_QUITAR);

        ErrorProduct error = products.decreaseStock(name, newStock);
        if (error == null) {
            System.out.println(ConstantsProducts.EL_STOCK_SE_HA_CAMBIADO_CORRECTAMENTE);
        } else {
            System.out.println(error.getDescription());
        }

        System.out.println(products.printProductList());
    }
}
