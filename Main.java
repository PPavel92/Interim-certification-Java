public class Main {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();
        toyStore.addToy(new Toy(1, "Кукла", 10, 20));
        toyStore.addToy(new Toy(2, "Машинка", 15, 30));
        toyStore.addToy(new Toy(3, "Мяч", 20, 50));

        toyStore.updateFrequency(1, 10); 

        toyStore.drawPrizeToy();
    }
}
