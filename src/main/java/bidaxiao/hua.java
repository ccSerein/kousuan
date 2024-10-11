package bidaxiao;

import java.awt.*;
import java.awt.event.InputEvent;

/**
 * 模拟鼠标绘画（建议显示器分辨率调至1280×720，且不要缩放，即100%缩放比）
 */
public class hua {
    public static void mouseGlide(int num) {

        //定义一个数组，存储坐标
        int[] x = new int[2];
        int[] y = new int[2];
        if (num == 1)  {    //大于
            x = new int[]{150, 250, 150};
            y = new int[]{430, 490, 550};
        } else if (num == 2) {  //小于
            x = new int[]{250, 150, 250};
            y = new int[]{430, 490, 550};
        }
        int x1 = x[0];
        int y1 = y[0];
        int x2 = x[1];
        int y2 = y[1];
        int x3 = x[2];
        int y3 = y[2];
        try {
            Robot r = new Robot();

            r.mouseMove(x1, y1);
            r.mousePress(InputEvent.BUTTON1_MASK);//按下鼠标左键
            Thread.sleep(50);
            r.mouseMove(x2, y2);
            Thread.sleep(50);
            r.mouseMove(x3, y3);
            Thread.sleep(50);
            r.mouseRelease(InputEvent.BUTTON1_MASK);//释放鼠标左键
            Thread.sleep(500);
        } catch (AWTException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
