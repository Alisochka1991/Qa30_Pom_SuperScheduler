package advanced;

import advancedscreens.DragScreen;
import configadvanced.ConfigAdvanced;
import org.testng.annotations.Test;

public class DragTests extends ConfigAdvanced {
    @Test
    public void dragDownTest()
    {
        new DragScreen(driver)
                .selectDraggableBasic()
                //.dragDown(4);
                .dragDownWindow();
    }

    @Test
    public void dragUpTest()
    {
        new DragScreen(driver)
                .selectDraggableBasic()
                .dragUp();
    }
}
