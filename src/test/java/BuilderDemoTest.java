import java.util.Collections;
import org.junit.Assert;
import org.junit.Test;


public class BuilderDemoTest {

    @Test
    public void should_not_NPE_on_NOT_singularized_item_when_using_toBuilder_from_an_instance_created_with_a_null_collection() {
        final BuilderDemo nullNames = new BuilderDemo(null, Collections.EMPTY_SET);

        final BuilderDemo otherInstance = nullNames.toBuilder().build();

        Assert.assertEquals(otherInstance, BuilderDemo.builder().build());
    }

    @Test
    public void should_not_NPE_on_singularized_item_when_using_toBuilder_from_an_instance_created_with_a_null_collection() {
        final BuilderDemo nullNames = new BuilderDemo(Collections.EMPTY_SET, null);

        final BuilderDemo otherInstance = nullNames.toBuilder().build();

        Assert.assertEquals(otherInstance, BuilderDemo.builder().build());
    }

    @Test
    public void should_not_NPE_when_using_toBuilder_from_an_instance_created_with_an_empty_builder() {
        final BuilderDemo nullNames = BuilderDemo.builder().build();

        final BuilderDemo otherInstance = nullNames.toBuilder().build();

        Assert.assertEquals(otherInstance, BuilderDemo.builder().build());
    }

}