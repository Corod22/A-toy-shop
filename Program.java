
public class Program {
    public static void main(String[] args) {
        ToyRaffleProgram raffleProgram = new ToyRaffleProgram();
        raffleProgram.addToy(1, "Заяц", 10, 20);
        raffleProgram.addToy(2, "Волк", 8, 15);
        raffleProgram.addToy(3, "Медведь", 10, 23);
        raffleProgram.addToy(4, "Ёжик", 5, 18);
        raffleProgram.addToy(5, "Машинка", 5, 28);
        raffleProgram.changeWeight(1, 30);  // Изменение веса для игрушки с id = 1

        raffleProgram.drawPrize();  // Розыгрыш приза
    }
}