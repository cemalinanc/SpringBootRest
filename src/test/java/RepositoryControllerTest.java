import com.inancc.Application;
import com.inancc.controllers.restcontrollers.RepositoryController;
import com.inancc.models.GitRepository;
import com.inancc.services.IRepositoryService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.core.Is.is;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(RepositoryController.class)
@ContextConfiguration(classes={Application.class})
public class RepositoryControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private IRepositoryService repositoryService;

    private GitRepository repositoryA = new GitRepository();
    private GitRepository repositoryB = new GitRepository();
    private GitRepository repositoryC = new GitRepository();

    @Before
    public void init(){
        repositoryA.setFullName("inancc");
        repositoryA.setDescription("repositoryA");

        repositoryB.setFullName("inancc");
        repositoryB.setDescription("repositoryB");

        repositoryC.setFullName("user");
        repositoryC.setDescription("repositoryC");
    }


    @Test
    public void repositoryControllerTest() throws Exception{

        given(repositoryService.getRepositoryInformation("inancc","repositoryA"))
                .willReturn(repositoryA);

        given(repositoryService.getRepositoryInformation("inancc","repositoryB"))
                .willReturn(repositoryB);

        given(repositoryService.getRepositoryInformation("user","repositoryC"))
                .willReturn(repositoryC);


        mvc.perform(get("/repositories/inancc/repositoryA")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.full_name", is(repositoryA.getFullName())))
                .andExpect(jsonPath("$.description", is(repositoryA.getDescription())));


        mvc.perform(get("/repositories/inancc/repositoryB")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.full_name", is(repositoryB.getFullName())))
                .andExpect(jsonPath("$.description", is(repositoryB.getDescription())));


        mvc.perform(get("/repositories/user/repositoryC")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.full_name", is(repositoryC.getFullName())))
                .andExpect(jsonPath("$.description", is(repositoryC.getDescription())));


    }



}
