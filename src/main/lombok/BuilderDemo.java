import java.util.Set;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

@Data
@Builder(toBuilder = true)
public class BuilderDemo {
    @Singular
    private Set<String> names;
}
