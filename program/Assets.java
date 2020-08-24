package lab2;

import java.util.Arrays;

public class Assets {

    private FinanceInstrument[] myAssets;
    private int numAccounts;
    private int numStocks;
    private int yearsSinceSale;


    public Assets(double depSavings, double monthlySavings, double depStocks, double monthlyStocks){
        myAssets = new FinanceInstrument[2];
        myAssets[0] = new SavingsAccount(depSavings, monthlySavings);
        myAssets[1] = new StockPortfolio(depStocks, monthlyStocks);
        this.numAccounts = 1;
        this.numStocks = 1;
        this.yearsSinceSale = 0;
    }

    public Assets(int numAccounts, int numStocks){
        this.numAccounts = numAccounts;
        this.numStocks = numStocks;
        this.yearsSinceSale = 0;
        myAssets = new FinanceInstrument[numAccounts+numStocks];
        for (int i=0; i<numAccounts; i++){
            myAssets[i] = new SavingsAccount(Math.random()*1000, Math.random()*1000);
        }

        for (int i=0; i<numStocks;i++) {
            myAssets[i+numAccounts] = new StockPortfolio(Math.random()*1000, Math.random()*1000);
        }
    }

    public void runSimulation(int years){
        for (int i=0; i<years; i++) {

            for (int j = 0; j < myAssets.length; j++) {
                myAssets[j].update();
            }
        }
    }

    public void runSimulation(int years, double threshold){
        for (int i=0; i<years; i++) {

            for (int j = 0; j < myAssets.length; j++) {
                myAssets[j].update();
                if(myAssets[j].getInterestRate()>=threshold && yearsSinceSale > 5)
                {
                    System.out.println("Sold stock!");
                    myAssets[0].add(myAssets[j].withdraw(myAssets[j].getValue()));
                    yearsSinceSale = 0;
                }
                else{
                    yearsSinceSale++;
                }
            }
        }
    }

    public void printSummary(){
        System.out.println(Arrays.toString(myAssets));

        System.out.println("Sum:");

        double tempSum = 0;

        for (int i=0; i<myAssets.length;i++){
            tempSum += myAssets[i].getValue();
        }
        System.out.printf("%.2f", tempSum);
    }

    public double returnSumStocks()
    {
        double tempValue = 0;
        for (int i=numAccounts; i<numAccounts+numStocks; i++)
        {
            tempValue += myAssets[i].getValue();
        }
        return tempValue;
    }

    public double returnSumAccounts()
    {
        double tempValue = 0;
        for (int i=0; i<numAccounts; i++)
        {
            tempValue += myAssets[i].getValue();
        }
        return tempValue;
    }
}

