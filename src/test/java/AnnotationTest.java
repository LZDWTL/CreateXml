import junit.framework.TestSuite;
import org.junit.Test;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ResourceBundle;

/**
 * @author 10237
 * @date 2021-03-14 23:08
 */
public class AnnotationTest extends TestSuite {


    @Test
    public void testAnnotation(){
        ResourceBundle bundle = ResourceBundle.getBundle("config");//读取resources下面的config.properties
        String controllerPackageName = bundle.getString("controller.package");
        System.out.println("要扫描的包：" + controllerPackageName);
        /**
         * 把包名转换为路径
         */
        URI uri = null;
        try {
            uri = AnnotationTest.class.getResource("/" + controllerPackageName.replace(".", "/")).toURI();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        System.out.println(uri.toString());

        File file = new File(uri);

        String controllerClassNames[] = file.list();
    }
}
