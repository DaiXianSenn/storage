package www.DCW.storage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * Author: JhonDai
 * Date: ${YEAR}/${MONTH}/${DAY}/${TIME}
 * Version: 1.0
 * Description:
 */

@SpringBootApplication
public class StorageApplication {
    public static void main(String[] args) {
        SpringApplication.run(StorageApplication.class,args);
    }
}