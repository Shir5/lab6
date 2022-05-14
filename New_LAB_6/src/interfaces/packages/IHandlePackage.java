package interfaces.packages;

import java.io.Serializable;

public interface IHandlePackage extends Serializable {
    void append(String line);

    void unpack();

}
