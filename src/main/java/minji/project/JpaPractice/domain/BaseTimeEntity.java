package minji.project.JpaPractice.domain;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class}) //Entity에 Auditing 기능 추가
public class BaseTimeEntity {

    @CreationTimestamp //엔터티 생성될 때 시간 기록.
    private LocalDateTime createdDate;
    //기존 Date 타입의 문제점을 고친 LocalDateTime. Java 8 부터 지원

    @LastModifiedDate //엔터티 수정할 때 시간 기록
    private LocalDateTime lastModifiedDate;

}
