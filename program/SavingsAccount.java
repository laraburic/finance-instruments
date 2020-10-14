package lab2solutions;

public class SavingsAccount extends FinanceInstrument {

    public static final double INTEREST = 0.01;

    public SavingsAccount(double value, double savings){
        super(INTEREST, value, savings);
    }

}
