package ra.academy.service;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ra.academy.dto.AccountResponse;
import ra.academy.dto.SignInDto;
import ra.academy.dto.SignUpDto;
import ra.academy.entity.Account;
import ra.academy.exception.UsernamePasswordException;
import ra.academy.repository.IAccountRepository;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService implements IAccountService{
    private final IAccountRepository accountRepository;


    @Override
    public AccountResponse login(SignInDto signInDto) throws UsernamePasswordException {
        Account account  = accountRepository.findByUsername(signInDto.getUsername())
                .orElseThrow(() -> new UsernamePasswordException("Username or password incorrect"));

        if (!BCrypt.checkpw(signInDto.getPassword(),account.getPassword())){
            throw new UsernamePasswordException("Username or password incorrect");
        }
        // tạo token từ username
        String token = BCrypt.hashpw(account.getUsername(),BCrypt.gensalt());
        return new AccountResponse(account.getUsername(), account.getFullName(), token);
    }

    @Override
    public List<Account> findAll() {
        return null;
    }

    @Override
    public Account findById(Long id) {
        return null;
    }

    @Override
    public Account save(Account account) {
       return accountRepository.save(account);
    }

    @Override
    public void register(SignUpDto signUpDto) {
        // xử lí Account
        accountRepository.save(Account.builder()
                .username(signUpDto.getUsername())
                .password(BCrypt.hashpw(signUpDto.getPassword(),BCrypt.gensalt(5)))
                .roles(new HashSet<>(signUpDto.getRoles()))
                .address(signUpDto.getAddress())
                .phone(signUpDto.getPhone())
                .fullName(signUpDto.getFullName())
                .build());
    }

    @Override
    public void delete(Long id) {

    }
}
