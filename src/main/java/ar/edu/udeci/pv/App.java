package ar.edu.udeci.pv;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;

public class App {
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        // Configuración de opciones de línea de comandos
        Options options = new Options();
        options.addOption("n", "name", true, "Nombre de usuario");

        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine cmd = parser.parse(options, args);
            if (cmd.hasOption("n")) {
                String name = cmd.getOptionValue("n");
                logger.info("Hola, " + name + "!");
                System.out.println("Hola, " + name + "!");
            } else {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("Actividad2", options);
            }
        } catch (ParseException e) {
            logger.error("Error al analizar argumentos: " + e.getMessage());
        }
    }
}
