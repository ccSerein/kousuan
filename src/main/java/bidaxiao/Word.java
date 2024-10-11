package bidaxiao;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;


/**
 * @describe 识别图片上的文字
 * 官方文档：https://ai.baidu.com/ai-doc/OCR/Ikibizxql
 */
public class Word {
    // 设置APPID/AK/SK
   public static final String appId = "你的 appId";
   public static final String apiKey = "你的 apiKey";
   public static final String secretKey = "你的 secretKey";
    public static final AipOcr client = new AipOcr(appId, apiKey, secretKey);

    /*
     * 文字识别方法
     */
    public static String imgOcr(String imgpath)
    {
        // 传入可选参数调用接口
        HashMap<String, String> options = new HashMap<String, String>();
        options.put("language_type", "CHN_ENG");
        options.put("detect_direction", "true");
        options.put("detect_language", "true");
        options.put("probability", "true");
        // 参数为本地路径
        JSONObject res = client.basicGeneral(imgpath, options);
        //解析json
        JSONArray wordsResult = (JSONArray)res.get("words_result");
        String ocrStr = "\n";
        StringBuffer sb=new StringBuffer();
        for(Object obj : wordsResult)
        {
            JSONObject jo = (JSONObject)obj;
            sb.append(jo.getString("words") + "\n");
        }
        return sb.toString();
    }
/*
    public static void main(String[] args) throws AWTException, IOException {
        *//*
         * 获取屏幕数字(截屏)
         *//*
        //{左上角的横坐标,左上角的纵坐标,右下角的横坐标,右下角的纵坐标}
        int[] area1 = {60, 200, 200, 260};
        int[] area2 = {220, 200, 300, 250};

        *//*识别图片*//*
        // 识别左边
        Pictures.createScreen(area1, "test.png");     // 获取屏幕左边数字


        String s = Word.imgOcr("C:\\Users\\Administrator\\Desktop\\sw_image\\test.png");
        System.out.println("识别到："+s);
        String[] split = s.split("\n");
        // '×' 215
        String[] data = split[0].split("×");
        int a1 = 0;
        int a2 = 0;
        if (NumberUtils.isNumber(data[0])) {
            a1 = Integer.parseInt(data[0]);
        } else {
            System.out.println("左边识别失败");
        }
        if (NumberUtils.isNumber(data[1])) {
            a2 = Integer.parseInt(data[1]);
        } else {
            System.out.println("右边识别失败");
        }
        System.out.printf(String.valueOf(a1 * a2));
    }*/
}
