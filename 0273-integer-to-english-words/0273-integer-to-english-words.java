class Solution {
    String[] ones = {
        "", "One", "Two", "Three", "Four", "Five",
        "Six", "Seven", "Eight", "Nine", "Ten",
        "Eleven", "Twelve", "Thirteen", "Fourteen",
        "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    String[] tens = {
        "", "", "Twenty", "Thirty", "Forty",
        "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    String[] places = {
        "", "Thousand", "Million", "Billion"
    };
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        StringBuilder result = new StringBuilder();

        int i = 0;
        while (num > 0) {
            int digits = num % 1000;

            if (digits != 0) {
                String subResult = conversion_toEnglish(digits);
                result.insert(0, subResult + " " + places[i] + " ");
            }
            num /= 1000;
            i++;
        }

        return result.toString().trim();
    }
    public String conversion_toEnglish(int number) {
        StringBuilder temp = new StringBuilder();
        // if number > 100
        if (number >= 100) {
            int hundereds_place = number / 100;
            temp.append(ones[hundereds_place] + " Hundred ");
            number %= 100;
        }
        

        // if the number is in the 1 - 19 range. this is already in the hashmap
        if (number >= 20) {
            int tens_place = number / 10;
            temp.append(tens[tens_place] + " ");
            number %= 10; 
        }

        if (number > 0) {
            int ones_place = number;
            temp.append(ones[ones_place] + " ");
        }

        return temp.toString().trim();
    }
}