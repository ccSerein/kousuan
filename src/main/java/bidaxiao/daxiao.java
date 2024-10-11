package bidaxiao;

import org.apache.commons.lang3.math.NumberUtils;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class daxiao {
    //图片存放目录
    public static final String BUFFER_IMAGE_AREA="/";
    public static final String BUFFER_IMAGE="/test.png";

    public static void main(String[] args) throws IOException, AWTException, InterruptedException {

        Scanner sc = new Scanner(System.in);
        System.out.println("输入任意开始");
        String s=sc.next();
        sc.close();
        int a = 10;     //一共几道题
        while (a > 0) {
            a--;
            int left = 0;
            int right = 0;
            // int[] area3={150,600,450,970};

            /*
             * 获取屏幕数字(截屏)
             */
            //{左上角的横坐标,左上角的纵坐标,右下角的横坐标,右下角的纵坐标}
            int[] area1 = {100, 215, 180, 250};
            int[] area2 = {220, 215, 300, 250};

            /*识别图片*/
            // 识别左边
            Pictures.createScreen(area1, "test.png");     // 获取屏幕左边数字
            String s1 = Word.imgOcr(BUFFER_IMAGE);
            String[] data1 = s1.split("\n");
            if (!NumberUtils.isNumber(data1[0])) { // 如果不是数字，继续等待
                a++;
                Thread.sleep(1000);
                continue;
            } else if (Integer.parseInt(data1[0]) > 100){ // 如果是数字，还需判断.如果大于两位数，继续等待
                a++;
                Thread.sleep(1000);
                continue;
            }
            left = Integer.parseInt(data1[0]);
            System.out.println("识别到左边：" + s1);
            // 识别右边
            Pictures.createScreen(area2, "test.png");     // 获取屏幕右边数字
            String s2 = Word.imgOcr(BUFFER_IMAGE);
            String[] data2 = s2.split("\n");
            if (!NumberUtils.isNumber(data2[0])) { // 如果不是数字，继续等待
                a++;
                Thread.sleep(1000);
                continue;
            } else if (Integer.parseInt(data2[0]) > 100){ // 如果是数字，还需判断.如果大于两位数，继续等待
                a++;
                Thread.sleep(1000);
                continue;
            }
            right = Integer.parseInt(data2[0]);
            System.out.println("识别到右边：" + s2);


            /*判断大小*/
            if (left > right) { // 左边大
                System.out.println("左边大");
                hua.mouseGlide(1);
            } else if (left < right) { // 右边大
                System.out.println("右边大");
                hua.mouseGlide(2);
            }
        }

        //删除文件,截图时生成的图片文件
        boolean result = Files.deleteIfExists(Paths.get(BUFFER_IMAGE));
    }

}
