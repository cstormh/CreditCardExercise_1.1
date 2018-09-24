import java.io.*;

class GameHelper {
    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.print(prompt + " ");
        try {
            BufferedReader is = new BufferedReader(
                    new InputStreamReader(System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0 ) return null;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputLine;
    }
}

class validateCC {

    private String card;

    public void setCC (String input) {
        card = input;
    }

    public String getCC () {
        return card;
    }

    // check if user input is numbers
    public void checkNumber () {

        try {
            long numCard = Long.parseLong(card);
            System.out.println("Card number is: "+numCard);
            System.out.println("User input for credit card is validated as a number");
        }
        catch (NumberFormatException e) {
            System.out.println("Not a valid input, please only enter numbers.");
        }
    }

    // check for special characters with replaceAll()
    public void checkSpecial () {
        String replaceAllInput = card.replaceAll("[^0-9]", "");
        if (replaceAllInput != card) {
            System.out.println("Not a valid input, there are special characters.");
        }
        else {
            System.out.println("Credit card number is validated for no special characters");
        }
    }

    // check for length
    public void checkLength () {
        long numCard = Long.parseLong(card);
        long inputLength = String.valueOf(numCard).length();
        System.out.println("Number length: "+inputLength);
        if (inputLength < 14 || inputLength > 18) {
            System.out.println("Not a valid input, credit card must have been 14 and 18 digits.");
        }
        else {
            System.out.println("Credit card number length is validated.");
        }
    }


}

public class CreditCard {
    public static void main(String[]args){

        GameHelper helper = new GameHelper();

        String input = helper.getUserInput("Enter credit card number");

        validateCC test = new validateCC();

        test.setCC(input);
        test.getCC();
        test.checkNumber();
        test.checkSpecial();
        test.checkLength();
    }
}

