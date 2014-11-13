package de.ehmka.hacking.springdockerexample;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import java.util.List;

/**
 * Created by michi on 13/11/14.
 */
public class BuildingStorySteps  {



    @Given("There are <building>")
    public void given() {

    }


    @When("I ask for all buildings")
    public void when() {

    }

    @Then("I should see a list which have <number_of_buildings>")
    public void then(@Named("number_of_buildings") Integer numberOfBuildings) {
        Assert.assertEquals(new Integer(2), numberOfBuildings);
    }
}
