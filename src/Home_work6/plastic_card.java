package Home_work6;

public class plastic_card implements card {
    void addcash() {
        System.out.println("Сумма зачислина успешно");

    }

    void getcash() {
        System.out.println("Транзакция проведена успешна");

    }

    plastic_card Visa = new plastic_card();

    public plastic_card getVisa() {
        return Visa;
    }

    public void setVisa(plastic_card visa) {
        Visa = visa;
    }

    @Override
    public void pay() {
        card.super.pay();
    }

}
