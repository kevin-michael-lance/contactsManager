

import java.util.Scanner;

public class Input {

    private Scanner scanner;

    public Input() {
        this.scanner = new Scanner(System.in);
    }

    public String getString() {
        System.out.println("Enter a string");
        return scanner.nextLine();
    }

    public String getString(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    public boolean yesNo() {
        System.out.println("y/n?");
        String input = scanner.nextLine();
        return input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes");
    }

    public boolean yesNo(String prompt) {
        System.out.println(prompt);
        String input = scanner.nextLine();
        return input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes");
    }

    public int getInt(int min, int max) {
        int input;
        boolean isValid = false;

        try {
            System.out.println(String.format("Enter an integer between %d and %d", min, max));
            do {
                input = Integer.parseInt(scanner.nextLine());

                if (input > min && input < max) {
                    isValid = true;
                } else {
                    System.out.println("Invalid input");
                }
            } while (!isValid);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
            return getInt(min, max);
        }

        return input;
    }

    public int getInt(int min, int max, String prompt) {
        int input;
        boolean isValid = false;

        try {
            System.out.println(prompt);
            do {
                input = Integer.parseInt(scanner.nextLine());

                if (input >= min && input <= max) {
                    isValid = true;
                } else {
                    System.out.println("Invalid input");
                }
            } while (!isValid);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
            return getInt(min, max, prompt);
        }

        return input;
    }

    public int getInt() {
        int input;

        try {
            System.out.println("Enter an integer");
            input = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
            return getInt();
        }

        return input;
    }

    public int getInt(String prompt) {
        int input;

        try {
            System.out.println(prompt);
            input = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
            return getInt(prompt);
        }

        return input;
    }

    public double getDouble(double min, double max) {
        double input;
        boolean isValid = false;

        try {
            System.out.println(String.format("Enter a double between %.2f and %.2f", min, max));
            do {
                input = Double.parseDouble(scanner.nextLine());

                if (input > min && input < max) {
                    isValid = true;
                } else {
                    System.out.println("Invalid input");
                }
            } while (!isValid);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
            return getDouble(min, max);
        }

        return input;
    }

    public double getDouble(double min, double max, String prompt) {
        double input;
        boolean isValid = false;

        try {
            System.out.println(prompt);
            do {
                input = Double.parseDouble(scanner.nextLine());

                if (input > min && input < max) {
                    isValid = true;
                } else {
                    System.out.println("Invalid input");
                }
            } while (!isValid);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
            return getDouble(min, max, prompt);
        }

        return input;
    }

    public double getDouble() {
        double input;

        try {
            System.out.println("Enter a double");
            input = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
            return getDouble();
        }

        return input;
    }

    public double getDouble(String prompt) {
        double input;

        try {
            System.out.println(prompt);
            input = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
            return getDouble(prompt);
        }

        return input;
    }

    public int getBinary() {
        int input;

        try {
            System.out.println("Enter a binary number");
            input = Integer.parseInt(scanner.nextLine(), 2);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
            return getBinary();
        }
        return input;
    }

    public int getHex() {
        int input;

        try {
            System.out.println("Enter a hexadecimal number");
            input = Integer.parseInt(scanner.nextLine(), 16);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input");
            return getHex();
        }
        return input;
    }
}