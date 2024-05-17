package trabajo;

import java.io.IOException;
import java.util.List;

public class AppFormula1 {
    public static void main(String[] args) throws IOException {
        List<Integer> years = List.of(2023, 2024);
        String sessions = Formula1Service.getSessions(years);
        System.out.println(sessions + "\n");

        String drivers = Formula1Service.getDrivers();
        String stints = Formula1Service.getStints();

    }
}