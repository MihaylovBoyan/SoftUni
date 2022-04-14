package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Set;

@XmlRootElement(name = "sellers")
@XmlAccessorType(XmlAccessType.FIELD)
public class SellerRootDto {

    @XmlElement(name = "seller")
    private List<SellerDto> sellers;

    public List<SellerDto> getSellers() {
        return sellers;
    }

    public SellerRootDto setSellers(List<SellerDto> sellers) {
        this.sellers = sellers;
        return this;
    }
}
