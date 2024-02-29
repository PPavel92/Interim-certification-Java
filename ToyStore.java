import java.io.*;
import java.util.*;

class Toy {
    private int id;
    private String name;
    private int quantity;
    private double frequency; 

    public Toy(int id, String name, int quantity, double frequency) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.frequency = frequency;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getFrequency() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }

    public void decreaseQuantity() {
        quantity--;
    }
}

class ToyStore {
    private List<Toy> toys;
    private List<Toy> prizeToys;

    public ToyStore() {
        toys = new ArrayList<>();
        prizeToys = new ArrayList<>();
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void updateFrequency(int toyId, double frequency) {
        for (Toy toy : toys) {
            if (toy.getId() == toyId) {
                toy.setFrequency(frequency);
                return;
            }
        }
        System.out.println("Игрушка с id " + toyId + " не найдена.");
    }

    public void drawPrizeToy() {
        double totalFrequency = toys.stream().mapToDouble(Toy::getFrequency).sum();
        double randomNumber = Math.random() * totalFrequency;
        double sum = 0;
        for (Toy toy : toys) {
            sum += toy.getFrequency();
            if (randomNumber <= sum) {
                if (toy.getQuantity() > 0) {
                    toy.decreaseQuantity();
                    prizeToys.add(toy);
                    System.out.println("Выиграна игрушка: " + toy.getName());
                    saveToFile(toy);
                } else {
                    System.out.println("Извините, данной игрушки больше нет в наличии.");
                }
                return;
            }
        }
    }

    private void saveToFile(Toy toy) {
        try (FileWriter writer = new FileWriter("prize_toys.txt", true)) {
            writer.write("Выиграна игрушка: " + toy.getName() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


