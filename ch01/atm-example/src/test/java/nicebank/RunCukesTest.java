package nicebank;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import cucumber.runtime.snippets.Snippet;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(snippets = SnippetType.CAMELCASE)
public class RunCukesTest {
}