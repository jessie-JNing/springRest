package spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestPersonController {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllPerson() throws Exception {
        this.mockMvc.perform(get("/person/all")).andExpect(status().isOk());
                //.andExpect(jsonPath("$.content").value("Hello, World!"));
    }

    @Test
    public void testGetPersonByIdParam() throws Exception {
        this.mockMvc.perform(get("/person?id="+1)).andExpect(status().isOk());
        //.andExpect(jsonPath("$.content").value("Hello, World!"));
    }

    @Test
    public void testGetPersonByIdVariable() throws Exception {
        this.mockMvc.perform(get("/person/"+1)).andExpect(status().isOk());
        //.andExpect(jsonPath("$.content").value("Hello, World!"));
    }

}
