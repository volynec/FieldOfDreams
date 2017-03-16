import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static final String INPUT_FILE = "INPUT.TXT";
    public static final String OUTPUT_FILE = "OUTPUT.TXT";
    public static int sectorNumbers;


    public static void main(String[] args) {
        try {
            parseFileAndCalculate();
            writeFile();
        } catch (IOException e) {
            System.out.println("Произошла ошибка ввода/выводв! ");
            System.out.println("Подробная отладочная информация: ");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Произошла неизвестная ошибка! ");
            System.out.println("Подробная отладочная информация: ");
            e.printStackTrace();
        }

    }

    private static void parseFileAndCalculate() throws IOException {

        List<Integer> indexList = new ArrayList<Integer>();

        Scanner scanner = new Scanner(Paths.get(INPUT_FILE));
        String line = scanner.nextLine();
        int amountNumbers = Integer.parseInt(line);
        int n = 2;
        int m = 1;

        String line2 = scanner.nextLine();
        String[] strArr = line2.split(" ");
        int numArr[] = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            numArr[i] = Integer.parseInt(strArr[i]);
        }

        for (int k = 0; k < numArr.length; k++) {
            int firstNnumber = numArr[0];
            if (numArr[k] == firstNnumber) {
                indexList.add(k);
            }
        }
        if (indexList.size() % 2 == 0) {
            sectorNumbers = indexList.get(1) - indexList.get(0);
//
        } else {
            sectorNumbers = indexList.get(2) - indexList.get(0);
            while (amountNumbers % sectorNumbers != 1) {

                sectorNumbers = indexList.get(n) - indexList.get(0);
                n = n + 1;
            }
        }

        scanner.close();

        for (int i : indexList) {
            System.out.println(i);
        }
        System.out.println("sectorNumbers " + sectorNumbers);

    }


    private static void writeFile() throws IOException {
        try {
            FileWriter fw = new FileWriter(OUTPUT_FILE);
            Writer output = new BufferedWriter(fw);
//            output.append(summArr + " ");
//            output.append(multArr + "");
            output.append(sectorNumbers + "");
            output.flush();
            output.close();
            fw.close();
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
    }
}



