package funciones_TXT;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        FileTXT file = new FileTXT("miArchivo.txt");
        List<String[]>lineas = file.ReadFileTXT();

    }

}
