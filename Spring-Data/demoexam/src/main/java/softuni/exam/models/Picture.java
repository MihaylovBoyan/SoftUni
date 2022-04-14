package softuni.exam.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "pictures")
public class Picture extends BaseEntity{

    private String name;
    private LocalDateTime dateAndTime;
    private Car car;

    @Column(unique = true)
    public String getName() {
        return name;
    }

    public Picture setName(String name) {
        this.name = name;
        return this;
    }

    @Column
    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public Picture setDateAndTime(LocalDateTime dateAndTime) {
        this.dateAndTime = dateAndTime;
        return this;
    }

    @ManyToOne
    public Car getCar() {
        return car;
    }

    public Picture setCar(Car car) {
        this.car = car;
        return this;
    }
}
