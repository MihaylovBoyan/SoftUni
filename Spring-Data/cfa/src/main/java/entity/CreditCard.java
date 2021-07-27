package entity;

import javax.persistence.*;

@Entity
@Table(name  = "credit_card")
public class CreditCard extends BillingDetail{

    private CardType cardType;
    private Integer expMonth;
    private Integer expYEar;


    public CreditCard(){

    }


    @Enumerated(EnumType.STRING)
    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    @Column(name = "exp_month")
    public Integer getExpMonth() {
        return expMonth;
    }

    public void setExpMonth(Integer expMonth) {
        this.expMonth = expMonth;
    }

    @Column(name = "exp_year")
    public Integer getExpYEar() {
        return expYEar;
    }

    public void setExpYEar(Integer expYEar) {
        this.expYEar = expYEar;
    }
}
