package exam.model.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ShopSeedRootDto {

    @XmlElement
    private List<ShopSeedDto> shops;


    public List<ShopSeedDto> getShops() {
        return shops;
    }


    public void setShops(List<ShopSeedDto> shops) {
        this.shops = shops;
    }
}
