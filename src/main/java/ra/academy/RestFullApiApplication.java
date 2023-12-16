package ra.academy;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ra.academy.entity.Account;
import ra.academy.entity.Role;
import ra.academy.entity.RoleName;
import ra.academy.service.IAccountService;

import java.util.HashSet;


@SpringBootApplication
public class RestFullApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestFullApiApplication.class, args);
    }

}
