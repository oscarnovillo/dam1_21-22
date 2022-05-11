package ui;

import modelo.Product;
import modelo.ProductNormal;
import modelo.ProductWithExpirationDate;
import modelo.error.ErrorProduct;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import servicios.ServicesIngredients;
import servicios.ServicesPreviousPurchase;
import servicios.ServicesProducts;
import ui.common.ConstantsProducts;
import ui.common.InputControl;
import uk.org.webcompere.systemstubs.jupiter.SystemStub;
import uk.org.webcompere.systemstubs.jupiter.SystemStubsExtension;
import uk.org.webcompere.systemstubs.stream.SystemOut;
import uk.org.webcompere.systemstubs.stream.input.LinesAltStream;

import javax.sound.sampled.Line;
import java.time.LocalDateTime;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SystemStubsExtension.class)
class UIProductTest {


    UIProduct uiProduct;


    @Mock
    ServicesPreviousPurchase servicesPreviousPurchase;
    @Mock
    ServicesProducts products;
    @Mock
    ServicesIngredients servicesIngredients;

    InputControl inputControl;
    Scanner sc;
    @SystemStub
    private SystemOut systemOut;

    @Captor
    ArgumentCaptor<Product> captorProduct;


    @Test
    void adminProductMenu() {

        //given
        sc= new Scanner(new LinesAltStream("2","pepe","10.8","3","N","0"));
        inputControl= new InputControl(sc);
        uiProduct = new UIProduct(servicesPreviousPurchase,products,servicesIngredients,inputControl,sc);
        when(products.addProduct(any(Product.class))).thenReturn(null);

        //when
        uiProduct.adminProductMenu();


        //then
        verify(products).addProduct(captorProduct.capture());
        assertThat(captorProduct.getValue().getName()).isEqualTo("pepe");
        assertThat(captorProduct.getValue()).isInstanceOf(ProductNormal.class);
        assertThat(systemOut.getOutput().getLines())
                .contains(ConstantsProducts.EL_PRODUCTO_SE_HA_ANADIDO_CORRECTAMENTE);


    }

    @Test
    void adminProductMenuCaducable() {

        //given
        sc= new Scanner(new LinesAltStream("2","pepe","10.8","3","S","1","0"));
        inputControl= new InputControl(sc);
        uiProduct = new UIProduct(servicesPreviousPurchase,products,servicesIngredients,inputControl,sc);
        when(products.addProduct(any(Product.class))).thenReturn(null);

        //when
        uiProduct.adminProductMenu();

        //then
        verify(products).addProduct(captorProduct.capture());
        assertThat(captorProduct.getValue().getName()).isEqualTo("pepe");
        assertThat(((ProductWithExpirationDate)captorProduct.getValue()).getExpirationDate())
                .isBeforeOrEqualTo(LocalDateTime.now().plusMinutes(1));
        assertThat(captorProduct.getValue()).isInstanceOf(ProductWithExpirationDate.class);
        assertThat(systemOut.getOutput().getLines())
                .contains(ConstantsProducts.EL_PRODUCTO_SE_HA_ANADIDO_CORRECTAMENTE);


    }


    @Test
    void adminProductMenuError() {

        //given
        sc= new Scanner(new LinesAltStream("2","pepe","10.8","3","N","0"));
        inputControl= new InputControl(sc);
        uiProduct = new UIProduct(servicesPreviousPurchase,products,servicesIngredients,inputControl,sc);
        when(products.addProduct(any(Product.class))).thenReturn(ErrorProduct.WRONG_PRICE);

        //when
        uiProduct.adminProductMenu();

        //then
        assertThat(systemOut.getOutput().getLines())
                .contains(ErrorProduct.WRONG_PRICE.getDescription());
    }

}
