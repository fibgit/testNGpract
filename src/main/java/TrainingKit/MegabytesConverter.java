package TrainingKit;


 class MegabytesConverter {

    void printMegaBytesAndKiloBytes(double kiloBytes) {


        if (kiloBytes < 0) {
            System.out.println("Invalid value");
        } else {
            System.out.println(kiloBytes + " KB = " + (Math.round(kiloBytes)) / 1024 + " MB and " + (Math.round(kiloBytes % 1024))  + " KB");

        }
    }

}

