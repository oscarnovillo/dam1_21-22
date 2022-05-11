package ui;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import ui.common.ConstantsGeneral;
import ui.common.InputControl;
import uk.org.webcompere.systemstubs.jupiter.SystemStub;
import uk.org.webcompere.systemstubs.jupiter.SystemStubsExtension;
import uk.org.webcompere.systemstubs.stream.SystemIn;
import uk.org.webcompere.systemstubs.stream.SystemOut;
import uk.org.webcompere.systemstubs.stream.input.LinesAltStream;

import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static uk.org.webcompere.systemstubs.SystemStubs.withTextFromSystemIn;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SystemStubsExtension.class)
class UILoginMenuTest {


    //class under test
    UILoginMenu uiLoginMenu;


    InputControl inputControl;

    @Mock
    UILoggedMenu uiLoggedMenu;

    @SystemStub
    private SystemOut systemOut;

    @Test
    void loginMenu() throws Exception {
        //given
        Scanner sc = new Scanner(new LinesAltStream("1","0"));

        uiLoginMenu = new UILoginMenu(new InputControl(sc), uiLoggedMenu,sc);

        //when
        uiLoginMenu.loginMenu();

        //then
        verify(uiLoggedMenu).adminMenu();
        assertThat(systemOut.getText()).contains(ConstantsGeneral.LOGIN_MENU);
    }


    @Test
    void loginMenu1() throws Exception {
        //given
        Scanner sc = new Scanner(new LinesAltStream("2","0"));

        uiLoginMenu = new UILoginMenu(new InputControl(sc), uiLoggedMenu,sc);

        //when
        uiLoginMenu.loginMenu();

        //then
        verify(uiLoggedMenu).clientLoginMenu();
        assertThat(systemOut.getText()).contains(ConstantsGeneral.LOGIN_MENU);
    }
}
