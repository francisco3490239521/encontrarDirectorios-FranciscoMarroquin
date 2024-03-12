package encontrarDirectorios;

public class econtrarDirectorios {

	public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Por favor, proporciona la ruta para ejecutar el programa.");
            return;
        }

        String ruta = args[0];

        System.out.println("Directorios encontrados en " + ruta + ":");
        encontrarDirectorios(ruta);
    }

    public static void encontrarDirectorios(String ruta) {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(ruta))) {
            for (Path path : stream) {
                if (Files.isDirectory(path)) {
                    System.out.println(path);
                    encontrarDirectorios(path.toString());
                }
            }
        } catch (Exception e) {
            System.out.println("Error al acceder a los directorios: " + e.getMessage());
        }
    }
}