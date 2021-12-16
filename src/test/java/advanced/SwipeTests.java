package advanced;

import advancedscreens.DragScreen;
import configadvanced.ConfigAdvanced;
import org.testng.annotations.Test;

public class SwipeTests extends ConfigAdvanced {


    @Test
    public void swipeTestLR()
    {
        new DragScreen(driver)
                .selectSwipe()
                .selectSwipeableBasic();
              //  .swipeFromLeftToRight();
    }

    @Test
    public void swipeTestRl()
    {
        new DragScreen(driver)
                .selectSwipe()
                .selectSwipeableBasic();
               // .swipeFromRightToLeft();
    }
}
