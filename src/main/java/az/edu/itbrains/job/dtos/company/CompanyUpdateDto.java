package az.edu.itbrains.job.dtos.company;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyUpdateDto {
    private String name;
    private String photoUrl;
    private String description;
}
