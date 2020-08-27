package lab2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    	/*int count = 0;

    	while(true){
			Assets myAssets = new Assets(0, 1000, 0, 1000);
			myAssets.runSimulation(30);

			if(myAssets.returnSumAccounts()>myAssets.returnSumStocks())
			{
				System.out.println("Stocks performed worse after " + count + " loops!");
				break;
			}
			count++;
		}*/


	    Assets myAssets2 = new Assets(0,1000,0,1000);
		myAssets2.runSimulation(30, 0.2);
		myAssets2.printSummary();

		System.out.println();
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the number of saving accounts:");
		int n = input.nextInt();
		System.out.println("Please enter the number of stock portfolios:");
		int m = input.nextInt();

		Assets myAssets3 = new Assets(n,m);
		myAssets3.runSimulation(30);
		myAssets3.printSummary();
    }
}
