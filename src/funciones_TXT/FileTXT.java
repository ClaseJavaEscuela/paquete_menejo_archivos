package funciones_TXT;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileTXT {
    private String nombre;

    public FileTXT(String nombre) {
        this.nombre = nombre;
    }


    public boolean deleteFile() {
        File file = new File(this.nombre);
        return file.delete();
    }

    public boolean copyFile(String destination) {
        try (InputStream is = new FileInputStream(this.nombre);
             OutputStream os = new FileOutputStream(destination)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
            return true;
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }


    public boolean moveFile(String destination) {
        File file = new File(this.nombre);
        File dest = new File(destination);
        return file.renameTo(dest);
    }


    public boolean renameFile(String newName) {
        File file = new File(this.nombre);
        File newFile = new File(newName);
        if (file.renameTo(newFile)) {
            this.nombre = newName;
            return true;
        }
        return false;
    }


    public List<String> listDirectory(String directoryPath) {
        File dir = new File(directoryPath);
        List<String> list = new ArrayList<>();
        if (dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    list.add(file.getName());
                }
            }
        }
        return list;
    }


    public List<String[]> ReadFileTXT(){
        try(BufferedReader file = new BufferedReader(new FileReader(this.nombre))){

            String line ="";
            List<String[]> list = new ArrayList<>();

            while((line = file.readLine()) != null){
                String[] lines = line.split(",");
                list.add(lines);
            }
            file.close();
            return list;

        }catch (FileNotFoundException e){
            System.out.println("Error: "+e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


    public boolean WriteFile(String mensage, boolean overwrite) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.nombre, overwrite))) {
            writer.write(mensage);
            writer.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return false;
    }

}
