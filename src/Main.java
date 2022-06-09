import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        File src = new File("E://Games", "src");
        File res = new File("E://Games", "res");
        File savegames = new File("E://Games", "savegames");
        File temp = new File("E://Games", "temp");
        File main = new File(src, "main");
        File test = new File(src, "test");
        File drawables = new File(res, "drawables");
        File vectors = new File(res, "vectors");
        File icons = new File(res, "icons");
        File mainJava = new File(main, "Main.java");
        File utilsJava = new File(main, "Utils.java");
        File tempTxt = new File(temp, "temp.txt");

        File[] dirs = {src, res, savegames, temp, main, test, drawables, vectors, icons};
        File[] files = {mainJava, utilsJava, tempTxt};
        StringBuilder log = new StringBuilder();

        for (File dir : dirs) {
            if (dir.mkdir()) {
                log.append("Создана новая директория " + dir.getName() + "\n");
            } else {
                log.append("Ошибка создания директории " + "\n");
            }
        }

        for (File file : files) {
            try {
                if (file.createNewFile()) {
                    log.append("Создан новый файл " + file.getName() + "\n");
                } else {
                    log.append("Ошибка создания файла" + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (FileWriter fileWriter = new FileWriter(tempTxt, true)) {
            fileWriter.write(String.valueOf(log));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
