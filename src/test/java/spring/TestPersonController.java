package spring;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import spring.dao.PersonRepository;
import spring.model.Person;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationTest.properties")
public class TestPersonController {

    private static final long ID = 1;

    @MockBean(name="personRepository")
    private PersonRepository personRepository;

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testGetAllPerson() throws Exception {
        this.mockMvc.perform(get("/person/all")).andExpect(status().isOk());
                //.andExpect(jsonPath("$.content").value("Hello, World!"));
    }

    @Test
    @Ignore
    public void testGetPersonByIdParamNotFound() throws Exception {
        when(personRepository.findOne(ID)).thenReturn(null);
        this.mockMvc.perform(get("/person?id="+1)).andExpect(status().isNotFound());
        //.andExpect(jsonPath("$.content").value("Hello, World!"));
    }

    @Test
    public void testGetPersonByParamSuccess() throws Exception {
        when(personRepository.findOne(ID)).thenReturn(new Person("testFirstName", "testLastName"));
        mockMvc.perform(get("/person?id=" + ID)).andExpect(status().isOk());

    }

    @Test
    public void testGetPersonByIdVariable() throws Exception {
        when(personRepository.findOne(ID)).thenReturn(new Person("testFirstName", "testLastName"));
        this.mockMvc.perform(get("/person/" + ID)).andExpect(status().isOk());
        //.andExpect(jsonPath("$.content").value("Hello, World!"));
    }

}
