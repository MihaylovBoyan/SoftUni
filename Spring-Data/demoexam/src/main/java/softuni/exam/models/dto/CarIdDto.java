package softuni.exam.models.dto;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlAccessorType(XmlAccessType.FIELD)
public class CarIdDto {

    @XmlElement
    private Long id;

    @NotNull
    public Long getId() {
        return id;
    }

    public CarIdDto setId(Long id) {
        this.id = id;
        return this;
    }
}
