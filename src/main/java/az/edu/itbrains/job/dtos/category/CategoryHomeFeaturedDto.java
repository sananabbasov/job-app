package az.edu.itbrains.job.dtos.category;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryHomeFeaturedDto {
    private Long id;
    private String name;
    private String icon;
    private int count;



    public void setCount(int count) {
        this.count = count;
    }


}
