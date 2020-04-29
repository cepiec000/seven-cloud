package cc.seven.tx.manager;

import com.codingapi.txlcn.tm.config.EnableTransactionManagerServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description: TODO
 * @Author chendongdong
 * @Date 2020/4/26 16:57
 * @Version V1.0
 **/
@SpringBootApplication
@EnableTransactionManagerServer
public class SevenTxManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SevenTxManagerApplication.class, args);
    }

}
