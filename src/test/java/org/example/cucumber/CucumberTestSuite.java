package org.example.cucumber;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

//https://stackoverflow.com/questions/70574831/cucumberoptions-tag-is-being-ignored-when-suite-junit-is-used
//https://junit.org/junit5/docs/current/user-guide/#running-tests-tags

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "org.example.stepdefinitions")
@IncludeTags("login | sidebar") //Note that @IncludeTags is to target specific tags because @Suite uses JUnit 5
public class CucumberTestSuite {
}
