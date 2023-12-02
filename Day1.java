public class Day1 {
    public static String day1() {
        int values = 0;
        for (int i = 0; i < 4; i++) {
            values += valueReturned(getValues(i));
        }
        String va = String.valueOf(values);
        return va;
    }

    private static String getValues(int chosenOne) {
        if (chosenOne == 0) {
            return "1abc2";
        } else if (chosenOne == 1) {
            return "pqr3stu8vwx";
        } else if (chosenOne == 2) {
            return "a1b2c3d4e5f";
        } else if (chosenOne == 3) {
            return "treb7uchet";
        }
        return "wtf";
    }

    private static int valueReturned(String calibration) {
        int number = 0;
        calibration = calibration.replaceAll("[a-zA-Z]", "");
        if (calibration.length() > 2) {
            StringBuilder output = new StringBuilder();
            char first = calibration.charAt(0);
            char last = calibration.charAt(calibration.length() - 1);
            output.append(first);
            output.append(last);
            calibration = output.toString();
        }
        if (calibration.length() == 1) {
            calibration = calibration + calibration;
        }
        if (calibration.matches("-?\\d+")) {
            try {
                number = Integer.valueOf(calibration);
            } catch (NumberFormatException e) {
                System.err.println("An unexpected error occurred while parsing the string '" + calibration + "'.");
                e.printStackTrace();
            }
        } else {
            System.out.println("The string '" + calibration + "' is not a valid integer.");
        }
        return number;
    }
}