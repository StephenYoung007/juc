package tech.ityoung.study.demo.markdown;

import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SummaryGeneration {
    private static String ancestorPath = "";

    public static void main(String[] args) throws IOException {
        ClassPathResource resource = new ClassPathResource("markdown/doc");
        File file = resource.getFile();
        if (file.isDirectory()) {
            ancestorPath = file.getPath();
            File[] files = file.listFiles();
            List<String> concepts = new ArrayList<>();
            for (File currentFile : files) {
                String structure = getFileStructure(currentFile, "", "  ");
                if (structure != null) {
                    concepts.add(structure);
                }
            }
            File summary = new File("SUMMARY.md");
            StringBuffer buffer = new StringBuffer();
            String context = "# Summary\n\n";
            buffer.append(context);
            for (String concept : concepts) {
                System.out.println(concept);
                System.out.println();
                buffer.append(concept);
                buffer.append("\n");
            }
            String summaryContext = buffer.toString();
            byte[] contextBytes = summaryContext.getBytes("UTF-8");
            FileOutputStream fileOutputStream = new FileOutputStream(summary);
            fileOutputStream.write(contextBytes);
            fileOutputStream.close();
        }
    }

    private static String getFileStructure(File currentFile, String father, String tab) {
        String name = currentFile.getName();
        if (currentFile.isFile() && ".md".equals(name.substring(name.lastIndexOf(".")))) {
            return father + "* [" + name.substring(0, name.lastIndexOf(".")) + "](" + setRelativeFilePath(currentFile.getAbsolutePath()) + ")";
        } else if (currentFile.isDirectory() && !"assets".equals(name)) {
            String fatherOrigin = "* [" + name + "]()";
            File[] files = currentFile.listFiles();
            if (files.length == 0) {
                return null;
            }
            List<String> subStructure = new ArrayList<>();
            for (File file : files) {
                String newTab = tab + "  ";
                String fileStructure = getFileStructure(file, "", newTab);
                if (fileStructure != null) {
                    subStructure.add(fileStructure);
                }
            }
            if (subStructure.size() == 0) {
                return null;
            }
            for (int i = 0; i < subStructure.size(); i++) {
                fatherOrigin = fatherOrigin + "\n" + tab + subStructure.get(i);
            }
            return fatherOrigin;
        }
        return null;
    }

    private static void renameFile(File[] files) {
    }

    /**
     * 更改md文件为相对路径
     *
     * @param absolutePath 根层级绝对路径
     * @return 番号相对路径
     */
    private static String setRelativeFilePath(String absolutePath) {
        int length = ancestorPath.length();
        return absolutePath.substring(length + 1);
    }
}
