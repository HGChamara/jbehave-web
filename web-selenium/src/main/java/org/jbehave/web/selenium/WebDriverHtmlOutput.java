package org.jbehave.web.selenium;

import org.jbehave.core.configuration.Keywords;
import org.jbehave.core.reporters.FilePrintStreamFactory;
import org.jbehave.core.reporters.HtmlOutput;
import org.jbehave.core.reporters.StoryReporter;
import org.jbehave.core.reporters.StoryReporterBuilder;

import java.io.PrintStream;
import java.util.Properties;

public class WebDriverHtmlOutput extends HtmlOutput {

    public static final org.jbehave.core.reporters.Format WEB_DRIVER_HTML = new org.jbehave.core.reporters.Format("HTML") {
        @Override
        public StoryReporter createStoryReporter(FilePrintStreamFactory factory, StoryReporterBuilder storyReporterBuilder) {
            factory.useConfiguration(storyReporterBuilder.fileConfiguration("html"));
            return new org.jbehave.web.selenium.WebDriverHtmlOutput(factory.createPrintStream(), storyReporterBuilder.keywords()).doReportFailureTrace(storyReporterBuilder.reportFailureTrace());
        }
    };


    public WebDriverHtmlOutput(PrintStream output) {
        super(output);
        changeALine();
    }

    public WebDriverHtmlOutput(PrintStream output, Properties outputPatterns) {
        super(output, outputPatterns);
        changeALine();
    }

    public WebDriverHtmlOutput(PrintStream output, Keywords keywords) {
        super(output, keywords);
        changeALine();
    }

    public WebDriverHtmlOutput(PrintStream output, Properties outputPatterns, Keywords keywords) {
        super(output, outputPatterns, keywords);
        changeALine();
    }

    public WebDriverHtmlOutput(PrintStream output, Properties outputPatterns, Keywords keywords, boolean reportFailureTrace) {
        super(output, outputPatterns, keywords, reportFailureTrace);
        changeALine();
    }

    private void changeALine() {
        super.overwritePattern("failed",
                "<div class=\"step failed\">{0} <span class=\"keyword failed\">({1})</span><br/><span class=\"message failed\">{2}</span>" +
                        "<br/><a color=\"black\" href=\"../screenshots/failed-scenario-{3}.png\">[screen shot]</a></div>\n");
    }

    @Override
    public void failed(String step, Throwable correlatedFailure) {
        super.failed(step, correlatedFailure);
    }


}