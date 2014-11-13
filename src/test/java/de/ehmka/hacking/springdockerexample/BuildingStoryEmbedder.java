package de.ehmka.hacking.springdockerexample;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.EmbedderControls;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.parsers.RegexPrefixCapturingPatternParser;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.ParameterConverters;
import org.jbehave.core.steps.SilentStepMonitor;

import java.text.SimpleDateFormat;

/**
 * Created by michi on 13/11/14.
 */
public class BuildingStoryEmbedder extends Embedder {

    @Override
    public EmbedderControls embedderControls() {
        return new EmbedderControls().doIgnoreFailureInStories(true).doIgnoreFailureInView(true);
    }

    @Override
    public Configuration configuration() {
        Class<? extends BuildingStoryEmbedder> embedderClass = this.getClass();
        return new MostUsefulConfiguration()
                .useStoryLoader(new LoadFromClasspath(embedderClass.getClassLoader()))
                .useStoryReporterBuilder(new StoryReporterBuilder()
                        .withCodeLocation(CodeLocations.codeLocationFromClass(embedderClass))
                        .withDefaultFormats()
                        //.withFormats(Format.CONSOLE, Format.TXT)
                        .withCrossReference(new CrossReference()))
                .useParameterConverters(new ParameterConverters()
                        .addConverters(new ParameterConverters.DateConverter(new SimpleDateFormat("yyyy-MM-dd"))))
                        // use custom date pattern
                .useStepPatternParser(new RegexPrefixCapturingPatternParser(
                        "%")) // use '%' instead of '$' to identify parameters
                .useStepMonitor(new SilentStepMonitor());
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new BuildingStoryEmbedder());
    }
}
