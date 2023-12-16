package ra.academy.service;

import ra.academy.dto.AccountResponse;
import ra.academy.dto.SignInDto;
import ra.academy.dto.SignUpDto;
import ra.academy.entity.Account;
import ra.academy.exception.UsernamePasswordException;

public interface IAccountService extends IGenericService<Account,Long> {
    AccountResponse login(SignInDto signInDto) throws UsernamePasswordException;
    void register(SignUpDto signUpDto);
}
