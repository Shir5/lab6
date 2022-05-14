package packages;

import interfaces.packages.IHandlePackage;

import java.util.ArrayList;
import java.util.List;

public class HandlePackage implements IHandlePackage {
    List<String> resultLines;

    public HandlePackage(String line) {
        this.resultLines = new ArrayList<>();
        this.resultLines.add(line);
    }

    @Override
    public void append(String line) {
        this.resultLines.add(line);
    }

    @Override
    public void unpack() {
        for (String i : resultLines) {
            System.out.println(i);
        }
        System.out.print("Введите команду: ");
    }
}
