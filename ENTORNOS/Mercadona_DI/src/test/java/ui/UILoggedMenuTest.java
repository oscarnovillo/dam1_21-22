package ui;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import servicios.ServicesClients;
import ui.client_account.UISettingsForAdmin;
import ui.client_account.UISettingsForClient;
import ui.client_actions.UIShopping;
import ui.client_actions.UIWallet;
import ui.common.ConstantsGeneral;
import ui.common.InputControl;
import uk.org.webcompere.systemstubs.jupiter.SystemStubsExtension;
import uk.org.webcompere.systemstubs.stream.input.LinesAltStream;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
@ExtendWith(SystemStubsExtension.class)
class UILoggedMenuTest {

    UILoggedMenu uiLoggedMenu;


    @Mock
    UIProduct uiProduct;
    @Mock
    UIShopping uiShopping;
    @Mock
    UIWallet uiWallet;
    @Mock
    UISettingsForClient uiSettingsForClient;
    @Mock
    UISettingsForAdmin uiSettingsForAdmin;
    @Mock
    ServicesClients servicesClients;

    InputControl inputControl;
    Scanner sc;

    @Test
    void adminMenu() {


        //given
        sc = new Scanner(new LinesAltStream("1","0"));

        uiLoggedMenu = new UILoggedMenu(uiProduct,uiShopping,uiWallet,uiSettingsForClient,uiSettingsForAdmin,servicesClients,new InputControl(sc),sc);

        //when
        uiLoggedMenu.adminMenu();

        //then
        verify(uiProduct).adminProductMenu();

    }
}
