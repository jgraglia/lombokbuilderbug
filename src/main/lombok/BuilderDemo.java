import java.util.Set;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

@Data
@Builder(toBuilder = true)
public class BuilderDemo {

    private final Set<String> names;

    @Singular
    private final Set<String> singularNames;
}
