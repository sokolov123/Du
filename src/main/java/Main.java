import org.kohsuke.args4j.*;

public class Main {
    @Argument()
    String[] inputName;

    @Option(name = "-h")
    Boolean h;

    @Option(name = "-c")
    Boolean c;

    @Option(name = "--si") // опшн значит есть они или нет
    Boolean si;

    private Paket launch(String[] args) { // чтобы штука выше работала и она кидает ашыпку
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.out.println("Используйте пожалуйста корректные аргументы"); // возможно на англ перевести в скобках
            parser.printUsage(System.err);
            System.exit(1);
        } // весь этот код работает ТИПА как регекс
        return new Paket(inputName, h, c ,si);
    }

    public static void main(String[] args) {
        Paket paket = null;
        try {
            paket = new Main().launch(args);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        CoreFile coreFile = null;

        try {
            coreFile = new CoreFile(paket.inputName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }

        String[] answer = coreFile.core(paket.h, paket.c, paket.si);
        printer(answer);
    }

    private static void printer(String[] answer){
        for(String s: answer) System.out.println(s);
    }

}
