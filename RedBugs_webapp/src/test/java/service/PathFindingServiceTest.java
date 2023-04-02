package service;

import com.isa.pl.redbugs.service.PathFindingService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {PathFindingServiceTest.class})
@WebAppConfiguration
public class PathFindingServiceTest {

    @Autowired
    private PathFindingService pathFindingService;
    @Test
    @Disabled
    void shouldRoute() {
        String path = pathFindingService.getPath();
        assertThat(path).isEqualTo("Hello");
    }
}
