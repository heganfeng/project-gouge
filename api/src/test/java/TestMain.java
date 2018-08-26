import com.gouge.tool.EncryptTool;
import com.gouge.util.StaticUtils;

/**
 * Created by grandfen on 17/7/20.
 */
public class TestMain {
    public static void main(String[] args) {
        try {
            System.out.println(EncryptTool.getDeCode("e7eaa38be6e3b7fde79d3c696375523b", StaticUtils.key));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
