import org.junit.Assert;
import org.junit.Test;


public class BuilderDemoTest {

    @Test
    public void should_not_NPE_when_using_toBuilder_from_an_instance_created_with_a_null_collection() {
        final TestMe nullNames = new TestMe(null);

        final TestMe a = nullNames.toBuilder().name("a").build();

        Assert.assertEquals(a, TestMe.builder().name("a").build());
    }

    @Test
    public void should_not_NPE_when_using_toBuilder_from_an_instance_created_with_an_empty_builder() {
        final TestMe nullNames = TestMe.builder().build();

        final TestMe a = nullNames.toBuilder().name("a").build();

        Assert.assertEquals(a, TestMe.builder().name("a").build());
    }

}