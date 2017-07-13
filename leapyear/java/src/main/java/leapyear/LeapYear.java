package leapyear;

class LeapYear {

    static boolean isLeap(int year) {

        return year % 400 == 0 || year % 4 == 0 && year % 100 != 0;
    }
}
