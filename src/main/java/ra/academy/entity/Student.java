package ra.academy.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor@AllArgsConstructor
@Data
public class Student {
    @Id
    @Column(length = 4)
    private String studentId;
    @Column(length = 100)
    private String studentName;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy")
    private Date birthDay;
    private Boolean gender;
    @Column(columnDefinition = "text")
    private String address;
    @Column(length = 45, unique = true)
    private String phoneNumber;
}
