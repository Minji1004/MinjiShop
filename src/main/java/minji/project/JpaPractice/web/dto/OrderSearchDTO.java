package minji.project.JpaPractice.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderSearchDTO {

    private String memberName;
    private String orderStatus;
}
