package myTests;

import data.WorkingSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.MyAccountPage;
import pages.TransferPage;

public class ServiceTest {

    @BeforeEach
    public void setUpObject() {
        WorkingSession st = new WorkingSession();
        TransferPage tr = new TransferPage();
        MyAccountPage rl = new MyAccountPage();
    }

    @Test
    void shouldLogin() {
        st.startOfWork();
    }

    @Test
    void shouldTransferToCard0001() {
        st.startOfWork();
        tr.transferToFirstCard();
    }

    @Test
    void shouldTransferToCard0002() {
        st.startOfWork();
        tr.transferToSecondCard();
    }

    @Test
    void shouldReloadMyAccountPage() {
        st.startOfWork();
        rl.reloadPage();
    }

    @Test
    void shouldCancelTransfer() {
        st.startOfWork();
        rl.selectTransferToSecondCard();
        tr.cancelTransfer();
    }
}