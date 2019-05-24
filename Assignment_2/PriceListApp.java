import java.util.Scanner;

class PriceListApp {
	public static void main(String[] args) {
		PriceList priceList = new PriceList();
		
		Scanner sc = new Scanner(System.in);
		int selectedMenu;
		
		while (true) {
			System.out.println(
				"============== Main Menu ==============\n" +
				"(1) Add a oil to price list\n" +
				"(2) View region information\n" +
				"(3) Print the entire price list\n" +
				"(4) Exit program\n" +
				"======================================="
			);
			
			System.out.print("choose a menu: ");
			
			selectedMenu = sc.nextInt();
			
			System.out.println("");
			
			switch (selectedMenu) {
				case 1:
					try {
						if (priceList.isFull()) {
							throw new FullArrayException();
						}
						
					} catch (FullArrayException e) {
						int amount;
						System.out.print(e.getMessage() + ": ");
						amount = sc.nextInt();
						priceList.extendList(amount);
						System.out.println("list is extended.\n");
					} finally {
						String company;
						int supplyPrice;
						
						String[] oilTypes = {"gasoline", "diesel"};
						
						for (String oilType: oilTypes) {
							System.out.print("company: ");
							company = sc.next();
							System.out.print("supply price: ");
							supplyPrice = sc.nextInt();
							sc.nextLine();
							
							if (oilType.equals("gasoline")) {
								Gasoline gasoline = new Gasoline(supplyPrice, company);
								priceList.setPriceList(priceList.getSize(), 0, gasoline);
							} else if (oilType.equals("diesel")) {
								Diesel diesel = new Diesel(supplyPrice, company);
								priceList.setPriceList(priceList.getSize(), 1, diesel);
							}
							System.out.printf("%s added\n\n", oilType);
						}
						
						priceList.setSize(priceList.getSize() + 1);
					}
					break;
				case 2:
					int region;
					System.out.print("region number to view: ");
					region = sc.nextInt() - 1;
					sc.nextLine();
					
					System.out.print(priceList.getRegionInfo(region));;
					
					break;
				case 3:
					System.out.println(priceList.getEntirePriceList());
					
					break;
				case 4:
					System.out.println("exit application");
					System.exit(0);
					break;
			}
		}
	}
}