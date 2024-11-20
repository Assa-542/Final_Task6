package com.example;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Getter
@Setter
public class MontyHall {
    private static final Random random = new Random();

    public static void main(String[] args) {
        int simulations = 1000;
        Map<Integer, Boolean> results = new HashMap<>();

        int winsIfSwitched = 0;
        int winsIfStayed = 0;

        for (int i = 0; i < simulations; i++) {
            boolean switchChoice = random.nextBoolean();
            boolean win = simulateGame(switchChoice);
            results.put(i, win);

            if (switchChoice && win) {
                winsIfSwitched++;
            } else if (!switchChoice && win) {
                winsIfStayed++;
            }
        }

        // Вывод статистики по победам и поражениям
        int wins = (int) results.values().stream().filter(b -> b).count();
        int losses = simulations - wins;

        System.out.println("Wins if switched: " + winsIfSwitched);
        System.out.println("Wins if stayed: " + winsIfStayed);
        System.out.println("Total wins: " + wins);
        System.out.println("Total losses: " + losses);
    }

    private static boolean simulateGame(boolean switchChoice) {
        int winningDoor = random.nextInt(3);
        int chosenDoor = random.nextInt(3);

        return switchChoice ? chosenDoor != winningDoor : chosenDoor == winningDoor;
    }
}
