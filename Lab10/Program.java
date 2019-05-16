public class Program {
	public static void main(String[] args) {
		Dog dog = new Dog();
		Tiger tiger = new Tiger();
		Turtle turtle = new Turtle();
		
		Animal[] animal = new Animal[3];
		animal[0] = dog;
		animal[1] = tiger;
		animal[2] = turtle;
		
		Person person = new Person() {
			int hp = 100;
			
			@Override
			public void control(Barkable b) {
				if (b instanceof Tiger) {
					this.hp -= 80;
				} else if (b instanceof Dog) {
					this.hp -= 10;
				}
				if (b instanceof Animal) {
					Animal a = (Animal) b;
					System.out.printf("%s를 제압하였습니다.\n", a.getName());
				}
			}
			
			@Override
			public void showInfo() {
				System.out.printf("사람 HP : %s\n", this.hp);
			}
		};
		
		showResult(animal, person);
	}
	
	private static void showResult(Animal[] animals, Person p) {
		for (int i = 0; i < animals.length; i++) {
			Animal a = animals[i];
			if (a instanceof Barkable) {
				Barkable b = (Barkable) a;
				
				System.out.printf("%d번째 동물 : %s\n", i + 1, a.getName());
				System.out.printf("%d번째 동물 울음소리 : %s\n", i + 1, b.bark());
				
				p.control(b);
				p.showInfo();
			}
		}
	}
}