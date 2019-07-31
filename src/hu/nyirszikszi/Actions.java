package hu.nyirszikszi;

import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

class Actions {
    private static String name;

    private static String getName() {
        return name;
    }

    private static void setName(String name) {
        Actions.name = name;
    }

    static ArrayList<AutoVerseny> fileToList(String fileName) {
        ArrayList<AutoVerseny> list = new ArrayList<>();

        try {
            RandomAccessFile raf = new RandomAccessFile(fileName, "r");
            String row = raf.readLine();
            row = raf.readLine();
            String[] slice;

            while (row != null) {
                slice = new String(row.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8).split(";");

                list.add(new AutoVerseny(slice[0], slice[1], Integer.parseInt(slice[2]), slice[3], slice[4], Integer.parseInt(slice[5])));

                row = raf.readLine();
            }

            raf.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    static int task3(ArrayList<AutoVerseny> list) {
        return list.size();
    }

    static String task4(ArrayList<AutoVerseny> list, String name, String track, int round) {
        int result = 0;

        for (AutoVerseny autoVerseny : list) {
            if (autoVerseny.getVersenyzo().equals(name) && autoVerseny.getPalya().equals(track) && autoVerseny.getKor() == round) {
                String time = autoVerseny.getKorido();
                String[] units = time.split(":");
                int hours = Integer.parseInt(units[0]),
                        minutes = Integer.parseInt(units[1]),
                        seconds = Integer.parseInt(units[2]);

                result = hours * 3600 + minutes * 60 + seconds;
                break;
            }
        }

        return result + " másodperc";
    }

    static void task5() {
        Scanner s = new Scanner(System.in);

        System.out.print("Kérem egy versenyző nevét: ");
        setName(s.nextLine());

        s.close();
    }

    static String task6(ArrayList<AutoVerseny> list) {
        String lapTime;
        String[] units;
        int index = 0,
                currentSecs = Integer.MAX_VALUE;
        boolean error = true;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getVersenyzo().equals(getName())) {
                lapTime = list.get(i).getKorido();
                units = lapTime.split(":");
                int hours = Integer.parseInt(units[0]),
                        minutes = Integer.parseInt(units[1]),
                        seconds = Integer.parseInt(units[2]),
                        secs = hours * 3600 + minutes * 60 + seconds;

                if (secs < currentSecs) {
                    index = i;
                    currentSecs = secs;
                }

                error = false;
            }
        }

        if (error) {
            return "Nincs ilyen versenyző az állományban!";
        }

        return list.get(index).getPalya() + ", " + list.get(index).getKorido();
    }
}