package de.ehmka.hacking.springdockerexample;

import org.jbehave.core.embedder.Embedder;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by michi on 13/11/14.
 */
public class BuildingStoryTest {

    @Test
    public void shouldShowAll() {
        Embedder e = new BuildingStoryEmbedder();
        List<String> storyPaths = Arrays.asList("de/ehmka/hacking/springdockerexample/");
        e.runStoriesAsPaths(storyPaths);
    }
}
