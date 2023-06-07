package org.example.Builders;

import org.openqa.selenium.edge.EdgeOptions;

import java.util.ArrayList;
import java.util.List;

public class EdgeOptionsBuilder {

    private List<String> args = new ArrayList<>();

    public EdgeOptionsBuilder setAdditionalArguments(String s) {
        this.args.add(s);
        return this;
    }

    public EdgeOptions build(){
        return new EdgeOptions().addArguments(args);
    }
}
