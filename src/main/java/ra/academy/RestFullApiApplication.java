package ra.academy;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ra.academy.entity.Account;
import ra.academy.entity.Product;
import ra.academy.entity.Role;
import ra.academy.entity.RoleName;
import ra.academy.repository.IProductRepository;
import ra.academy.service.IAccountService;

import java.math.BigDecimal;
import java.util.HashSet;


@SpringBootApplication
public class RestFullApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestFullApiApplication.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner (IProductRepository productRepository){
//        return args -> {
//            Product p1 = new Product(null, "Sản phẩm A", "https://th.bing.com/th/id/OIP.UEhHlo0a1xIOh28Vv2ROCQAAAA?rs=1&pid=ImgDetMain", new BigDecimal(100000));
//            Product p2 = new Product(null, "Sản phẩm B", "https://th.bing.com/th/id/OIP.3GGjebVY8LsD5e4DpY1pDgHaJ4?pid=ImgDet&w=474&h=632&rs=1", new BigDecimal(150000));
//            Product p3 = new Product(null, "Sản phẩm C", "https://th.bing.com/th/id/OIP.IRPCLB8WhvDzII2Zc4l_UQHaJ4?pid=ImgDet&w=474&h=632&rs=1", new BigDecimal(200000));
//
//            productRepository.save(p1);
//            productRepository.save(p2);
//            productRepository.save(p3);
//        };
//
//    }
}
