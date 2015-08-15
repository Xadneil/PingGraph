import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        PingForm form = new PingForm();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        form.start();
        try {
            Scanner in = new Scanner(System.in);
            while (true) {
                String line = in.nextLine();
                if (line.indexOf("time=") != -1) {
                    String sub = line.substring(line.indexOf("time="));
                    sub = sub.substring(0, sub.indexOf("ms"));
                    sub = sub.replace("time=", "");
                    int ms = Integer.parseInt(sub);
                    form.plotData(ms);
                } else {
                    form.plotData(10000);
                }
            }
        } catch (Exception e) {

        }
    }
}
