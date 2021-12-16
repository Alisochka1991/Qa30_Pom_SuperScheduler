package advancedscreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DraggableBasicScreen extends BaseScreenADV {
    public DraggableBasicScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='com.h6ah4i.android.example.advrecyclerview:id/drag_handle']")
    List<MobileElement> list;

    public DraggableBasicScreen dragDown()//metod tyanet swaipi
    {
        MobileElement el = list.get(0);
        Rectangle rect = el.getRect();
        int xFrom = rect.getX()+ rect.getWidth()/2;
        int yFrom = rect.getY()+rect.getHeight()/2;

        int xTo= xFrom;
        int yTo= yFrom+ rect.getHeight();

        TouchAction <?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(xFrom,yFrom))
                .moveTo(PointOption.point(xTo,yTo))
                .release()
                .perform();
        return this;
    }

    public DraggableBasicScreen dragDown(int count)//metod tyanet swaipi na kolichestvo pozicii
    {
        MobileElement el = list.get(0);
        Rectangle rect = el.getRect();
        int xFrom = rect.getX()+ rect.getWidth()/2;
        int yFrom = rect.getY()+rect.getHeight()/2;

        int xTo= xFrom;
        int yTo= yFrom+ rect.getHeight()*count;

        TouchAction <?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(xFrom,yFrom))
                .moveTo(PointOption.point(xTo,yTo))
                .release()
                .perform();
        return this;
    }

    public DraggableBasicScreen dragDownWindow()//metod tyanet swaipi na ves ekran
    {
        Dimension window = driver.manage().window().getSize();

        MobileElement el = list.get(0);
        Rectangle rect = el.getRect();
        int xFrom = rect.getX()+ rect.getWidth()/2;
        int yFrom = rect.getY()+rect.getHeight()/2;

        int xTo= xFrom;
        int yTo= window.getHeight()- rect.getHeight()/2;

        TouchAction <?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(xFrom,yFrom))
                .moveTo(PointOption.point(xTo,yTo))
                .release()
                .perform();
        return this;
    }

    public DraggableBasicScreen dragUp()
    {
        MobileElement el = list.get(5);
        Rectangle rect = el.getRect();
        int x = rect.getX()+rect.getWidth()/2;
        int yfrom = rect.getY()+rect.getHeight()/2;

        int yto = yfrom - rect.getHeight();
        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(x,yfrom))
                .moveTo(PointOption.point(x,yto))
                .release().perform();

        return this;
    }
}
