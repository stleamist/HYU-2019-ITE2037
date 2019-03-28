class Lab04 {
	public static void main(String[] args) {
		City seoul = new City("Seoul", 23, 45);
		City paris = new City("Paris", 123, 41);
		City racoonCity = new City("Racoon City");
		City megaCity = new City("Mega City");
		
		System.out.println(seoul);
		System.out.println(paris);
		System.out.println(racoonCity);
		System.out.println(megaCity);
		
		System.out.printf("%s-%s : %f\n", seoul.getName(), paris.getName(), City.distance(seoul, paris));
		System.out.printf("%s-%s : %f\n", seoul.getName(), racoonCity.getName(), City.distance(seoul, racoonCity));
		System.out.printf("%s-%s : %f\n", paris.getName(), megaCity.getName(), City.distance(paris, megaCity));
	}
}