package GuessingGame;

import javax.swing.*;

public class GuessingGame {
    public static void main(String[] args) {
        int computerNumber = (int) (Math.random()*100 +1);
        int userAnswer = 0;
        int count = 1;

        while (userAnswer != computerNumber && count < 11){
            String response = JOptionPane.showInputDialog(null,
                    "У Вас 10 попыток. Введите число от 1 до 100: ", "Угадай число", 3);
            userAnswer = Integer.parseInt(response);
            JOptionPane.showMessageDialog(null, ""+ determineGuess(userAnswer, computerNumber, count));
            count++;
            JOptionPane.showMessageDialog(null, "Ваши баллы: " + getPoints(count));
        }
    }
    public static int getPoints(int count){
        int result = switch (count) {
            case 1 -> 10;
            case 2 -> 9;
            case 3 -> 8;
            case 4 -> 7;
            case 5 -> 6;
            case 6 -> 5;
            case 7 -> 3;
            case 8 -> 1;
            case 9 -> 0;
            default -> 0;
        };
        return result;
    }
    public static String determineGuess(int userAnswer, int computerNumber, int count){
        if(userAnswer <=0 || userAnswer > 100){
            return "Ваше число не в заданном диапазоне";
        }
        else if(count == 10){

            return "Игра окончена. Вы проиграли!"+ "\n" + "Кол-во попыток: " + count;
        }
        else if (userAnswer == computerNumber){
            return "ВЫ УГАДАЛИ!" + "\n" + "Кол-во попыток: " + count;
        }
        else if (userAnswer > computerNumber){
            return "Ваше число больше загаданного. " + "\n" + "Попробуйте снова" + "\n" +
                    "Кол-во попыток: " + count;
        }
        else if (userAnswer < computerNumber){
            return "Ваше число меньше загаданного. " + "\n" + "Попробуйте снова" + "\n" +
                    "Кол-во попыток: " + count;
        }
        else {
            return "Ваш ввод некорректен." + "\n" + "Попробуйте снова" + "\n" +
                    "Кол-во попыток: " + count;
        }
    }
}
