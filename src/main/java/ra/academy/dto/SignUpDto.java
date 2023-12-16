package ra.academy.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ra.academy.entity.Role;

import java.util.List;
import java.util.Set;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SignUpDto {
    private String username;
    private String password,fullName;
    private String phone;
    private String address;
    private List<Role> roles;
}
