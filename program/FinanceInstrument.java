package lab2;

public class FinanceInstrument {
    private double interestRate;
    private double value;
    private double deposits;
    private final double scale=100;

    public FinanceInstrument(double interestRate, double value, double deposits){
        this.interestRate = interestRate;
        this.value = value;
        this.deposits = deposits;
    }

    public double getInterestRate(){
        return interestRate;
    }

    public double getValue(){
        return value;
    }

    public double getDeposits(){
        return deposits;
    }

    public void add(double amount){
        value += amount;
    }

    public void setInterestRate(double interestRate){
        this.interestRate = interestRate;
    }

    public double withdraw(double amount){
        value -= amount;
        return amount;
    }

    public void update(){
        value *= (1+interestRate);
        value += deposits;
    }

    @Override
    public String toString(){
        return "Current value: " + Math.round(value*scale)/scale + "\n" + "Interest rate: " + Math.round(interestRate*scale)/scale;
    }
}
