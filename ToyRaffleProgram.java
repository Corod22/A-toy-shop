import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class ToyRaffleProgram {
    private List<Toy> toyList;
    private List<Toy> prizeList;

    public ToyRaffleProgram() {
        toyList = new ArrayList<>();
        prizeList = new ArrayList<>();
    }

    public void addToy(int id, String name, int quantity, double weight) {
        Toy newToy = new Toy(id, name, quantity, weight);
        toyList.add(newToy);
    }

    public void changeWeight(int toyId, double newWeight) {
        for (Toy toy : toyList) {
            if (toy.getId() == toyId) {
                toy.setWeight(newWeight);
                break;
            }
        }
    }

    public void drawPrize() {
        double totalWeight = 0;
        for (Toy toy : toyList) {
            totalWeight += toy.getWeight();
        }

        Random random = new Random();
        double randomNumber = random.nextDouble() * totalWeight;

        double cumulativeWeight = 0;
        for (Toy toy : toyList) {
            cumulativeWeight += toy.getWeight();
            if (randomNumber <= cumulativeWeight) {
                prizeList.add(toy);
                toy.decreaseQuantity();
                break;
            }
        }

        toyList.remove(prizeList.get(0));
        savePrizeToFile(prizeList.get(0));
        prizeList.clear();
    }

    private void savePrizeToFile(Toy toy) {
        try (FileWriter writer = new FileWriter("prizes.txt", true)) {
            writer.write(toy.getName() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}