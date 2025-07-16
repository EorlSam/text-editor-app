package com.github.eorlsam.texteditorapp.util;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileIO {

    private File file;

    public FileIO(File file) {
        this.file = file;
    }

    public String readFile(File file) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            return stringBuilder.toString();
        }  catch (IOException e) {
            throw new RuntimeException("Failed to read file: " + file.getName(), e);
        }
    }

    public void writeFile(File file, String content) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8))) {
            bufferedWriter.write(content);
        }  catch (IOException e) {
            throw new RuntimeException("Failed to read file: " + file.getName(), e);
        }
    }
}
