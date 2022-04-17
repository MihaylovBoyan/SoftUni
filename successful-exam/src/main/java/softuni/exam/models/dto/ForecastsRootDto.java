package softuni.exam.models.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "forecasts")
@XmlAccessorType(XmlAccessType.FIELD)
public class ForecastsRootDto {

    @XmlElement(name = "forecast")
    private List<ForeCastDto> forecasts;

    public List<ForeCastDto> getForecasts() {
        return forecasts;
    }

    public ForecastsRootDto setForecasts(List<ForeCastDto> forecasts) {
        this.forecasts = forecasts;
        return this;
    }
}
