package Examples;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Example24FormatDate {

    public static void main(String[] args) throws InterruptedException {

        String pattern = "MM-dd-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);  // IMPORTANT CLASS

        String date = simpleDateFormat.format(new Date()); // Important method
        System.out.println(date);


    }

}
