package com.fileparser.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public final class FileParserUtil {
    
    private FileParserUtil() {
    }

    /**
     * @param fileName
     * @return
     */

    public static List<FileLine> getFileLineList(URL resource) {
        if (resource == null) {
            return null;
        }
        List<FileLine> lines = new ArrayList<>();
        int repeticiones=0;
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(resource.toURI())))){
            String line = "";
            int lineNumber = 0;
			repeticiones = Integer.parseInt(reader.readLine());
            while (lineNumber <= repeticiones && (line = reader.readLine()) != null) {
                lines.add(new FileLine(line));
                lineNumber++;
			}
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lines;
    }
}
