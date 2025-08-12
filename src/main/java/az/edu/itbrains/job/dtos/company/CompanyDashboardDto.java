package az.edu.itbrains.job.dtos.company;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDashboardDto {
    private Long id;
    private String name;
    private String photoUrl;
}
