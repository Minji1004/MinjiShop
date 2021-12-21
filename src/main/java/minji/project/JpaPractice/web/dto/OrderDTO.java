package minji.project.JpaPractice.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderDTO {

    private Long memberId;
    private Long itemId;

    private int count;

}
