import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentsIntegrationTest {

    @Autowired
clprivate MockMvc mockMvc;

    @Test
    public void testGetStudentsEndpoint() throws Exception {
        // Make an API call to your endpoint
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/students"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        // Deserialize the JSON response into the Students class
        ObjectMapper objectMapper = new ObjectMapper();
        Students students = objectMapper.readValue(result.getResponse().getContentAsString(), Students.class);

        // Perform assertions on the students object
        // For example, check if it contains the expected data
        // assertEquals(expectedStudents, students);
    }
}
