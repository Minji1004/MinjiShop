package minji.project.JpaPractice.domain.delivery;


import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import minji.project.JpaPractice.domain.Address;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DELIVERY_ID")
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

    @Embedded
    private Address address;

    public Delivery(Address address){
        this.address = address;
        deliveryStatus = DeliveryStatus.READY;
    }

    public void cancel() {
        this.deliveryStatus = DeliveryStatus.CANCEL;
    }
}
