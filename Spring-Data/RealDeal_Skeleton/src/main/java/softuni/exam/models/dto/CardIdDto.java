package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class CardIdDto {

    private Long id;

    public Long getId() {
        return id;
    }

    public CardIdDto setId(Long id) {
        this.id = id;
        return this;
    }
}
