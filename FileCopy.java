import java.io.*;

public class FileCopy {

    public static void main(String... args) {

        String from = "from.txt", to = "to.txt";
        if (args.length > 0) {
            from = args[0];
        }
        if (args.length > 1) {
            to = args[1];
        }

        try {
            if (!new File(from).exists()) {
                BufferedWriter writer = new BufferedWriter(
                        new FileWriter(from)
                );
                writer.write("This is a default 'from' file created for you.\n");
                writer.write("Follow java call with 'from' and 'to' file locations\n");
                writer.close();
            }

            BufferedReader reader = new BufferedReader(
                    new FileReader(from)
            );
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter(to)
            );
            String str;
            while ((str = reader.readLine()) != null) {
                writer.write(str+"\n");
            }
            reader.close();
            writer.close();
            System.out.println("Done!");

        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}