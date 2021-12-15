package advancedscreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SwipeableBasicScreen extends BaseScreenADV {
    public SwipeableBasicScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.h6ah4i.android.example.advrecyclerview:id/container' and @class = 'android.widget.FrameLayout']")
    // @FindBy(xpath = "//*[@resource-id='android:id/text1']")
    List<MobileElement > list;
    //@FindBy(xpath = "//*[@resource-id='com.h6ah4i.android.example.advrecyclerview:id/container'][1]")
    @FindBy(xpath = "//*[@class='android.widget.FrameLayout'][1]")
    MobileElement element;

    public SwipeableBasicScreen swipeFromLeftToRight(){
        System.out.println(list.size());
        System.out.println(list.get(0).toString());
        MobileElement el = list.get(0);

        Rectangle rect = el.getRect();
        System.out.println(rect.getWidth());

        int xfrom= rect.getX()+(rect.getWidth()/10)*2;
        //int xfrom= rect.getX()+(rect.getWidth()/5);
        //int xfrom= rect.getX()+30;
        int y = rect.getY()+rect.getHeight()/2;

        int xto = rect.getX() + (rect.getWidth()/10)*9;
        // int xto = rect.getX() + (rect.getWidth()-10);

        TouchAction<?> action = new TouchAction<>(driver);
        action.longPress(PointOption.point(xfrom,y))
                .moveTo(PointOption.point(xto,y))
                .release().perform();


        return  this;
    }

    public SwipeableBasicScreen swipeFromRightToLeft(){
        MobileElement el = list.get(3);

        Rectangle rect = el.getRect();

        int xfrom = rect.getX()+ (rect.getWidth()-20);
        int y = rect.getY()+rect.getHeight()/2;
        int xto = rect.getX()+20;

        TouchAction <?> action = new TouchAction<>(driver);
        action.longPress(PointOption.point(xfrom,y))
                .moveTo(PointOption.point(xto,y))
                .release()
                .perform();

        return this;
    }
}
