package org.example.Builders;

import org.openqa.selenium.edge.EdgeOptions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class EdgeOptionsBuilder {

    private final List<String> args = new ArrayList<>();
    private final List<File> files = new ArrayList<>();

    public EdgeOptionsBuilder setWindowSize(String s) {
        return this.setAdditionalArguments(s);
    }

    public EdgeOptionsBuilder setExtension(File file) {
        return this.setAdditionalArguments(file);
    }

    public EdgeOptionsBuilder setAdditionalArguments(String s) {
        this.args.add(s);
        return this;
    }

    public EdgeOptionsBuilder setAdditionalArguments(File file) {
        this.files.add(file);
        return this;
    }

    public EdgeOptions build() {
        return new EdgeOptions()
                .addArguments(args)
                .addExtensions(files);
    }
}
