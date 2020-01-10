package myTests;

import data.WorkingSession;
import org.junit.jupiter.api.Test;
import pages.MyAccountPage;
import pages.TransferPage;

public class ServiceTest {

    @Test
    void shouldLogin() {
        WorkingSession.startOfWork();
    }

    @Test
    void shouldTransferToCard0001() {
        WorkingSession.startOfWork();
        TransferPage.transferToFirstCard();
    }

    @Test
    void shouldTransferToCard0002() {
        WorkingSession.startOfWork();
        TransferPage.transferToSecondCard();
    }

    @Test
    void shouldReloadMyAccountPage() {
        WorkingSession.startOfWork();
        MyAccountPage.reloadPage();
    }

    @Test
    void shouldCancelTransfer() {
        WorkingSession.startOfWork();
        MyAccountPage.transferToSecondCard();
        TransferPage.cancelTransfer();
    }
}