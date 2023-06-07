package org.example.Builders;

import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ChromeOptionsBuilder {

    private final List<String> args = new ArrayList<>();
    private final List<File> files = new ArrayList<>();

    //Creates a list of arguments to be appended to the object in the build() method
    public ChromeOptionsBuilder setAdditionalArguments(String args) {
        this.args.add(args);
        return this;
    }

    public ChromeOptionsBuilder setAdditionalArguments(File file) {
        this.files.add(file);
        return this;
    }

//    public ChromeOptionsBuilder setMaxWindowSize(String s) {
//        this.isMax = s;
//        return this;
//    }

    public ChromeOptions build() {
        //Invoke ChromeOptions constructor to build object
        return new ChromeOptions()
                .addArguments(args)
                .addExtensions(files);
    }
}
