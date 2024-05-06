package ra.practiceemployee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.servlet.http.Part;
import java.text.SimpleDateFormat;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeDTO
{
    private Integer id;
    private String name;
    private Date dob;
    private Boolean sex;
    private Part fileAvatar;
}
