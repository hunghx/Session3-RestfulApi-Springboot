package ra.academy.controller;

import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.academy.dto.AccountResponse;
import ra.academy.dto.SignInDto;
import ra.academy.dto.SignUpDto;
import ra.academy.entity.Account;
import ra.academy.entity.Role;
import ra.academy.entity.RoleName;
import ra.academy.exception.UsernamePasswordException;
import ra.academy.service.IAccountService;

import java.util.HashSet;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api.myservice.com/v1/account")
public class AccountController {
    private final IAccountService accountService;
    @PutMapping("/add-role")
    public String addRole(@RequestParam Long userId,@RequestParam Long roleId){
        // lấy ra user thông qua id
        // lấy ra role thong qua id
        // dưehfjhwejfvhwvwfyevw
        return "Success";
    }
    @GetMapping
    public String test(){
        Role admin  = new Role(null, RoleName.ROLE_ADMIN);
        Role pm  = new Role(null, RoleName.ROLE_PM);
        Role user  = new Role(null, RoleName.ROLE_USER);

        Account acc1 = new Account(null,"hunghx", BCrypt.hashpw("123456",BCrypt.gensalt(5)),"Hồ Xuân Hùng","0949838674","HCM",new HashSet<>());
        acc1.getRoles().add(admin);
        acc1.getRoles().add(pm);
        acc1.getRoles().add(user);

        accountService.save(acc1);
        return "success";
    }
    @PostMapping("/auth/sign-in")
    public ResponseEntity<AccountResponse> doLogin(@RequestBody SignInDto signInDto) throws UsernamePasswordException {
        return new ResponseEntity<>(accountService.login(signInDto), HttpStatus.OK);
    }
    @PostMapping("/auth/sign-up")
    public ResponseEntity<String> doRegister(@RequestBody SignUpDto signUpDto) {
        accountService.register(signUpDto);
        return new ResponseEntity<>("Register success", HttpStatus.OK);
    }
}
