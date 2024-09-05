//package fr.fms;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import fr.fms.dao.CityRepository;
//import fr.fms.dao.HotelRepository;
//import fr.fms.dao.RoleRepository;
//import fr.fms.dao.UserRepository;
//import fr.fms.Service.AccountServiceImpl;
//import fr.fms.Web.AccountControler;
//import fr.fms.entity.appUser;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import java.util.ArrayList;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.mockito.Mockito.when;
//
//@WebMvcTest(controllers = AccountControler.class)
//public class AccountControllerTest {
//
//    @Autowired
//    private MockMvc mvc;
//
//    @MockBean
//    private AccountServiceImpl accountService;
//
//    @MockBean
//    private UserDetailsService userDetailsService;
//
//    @MockBean
//    private HotelRepository hotelRepository;
//
//    @MockBean
//    private CityRepository cityRepository;
//
//    @MockBean
//    private UserRepository userRepository;
//
//    @MockBean
//    private RoleRepository roleRepository;
//
//    @MockBean
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @Test
//    void testGetUsers() throws Exception{
//        mvc.perform(get("/users")).andExpect(status().isOk());
//    }
//
//    @Test
//    void testSaveUser() throws Exception{
//        ObjectMapper objectMapper = new ObjectMapper();
//
//        appUser newUser = new appUser(null, "papa", "superpapa", new ArrayList<>());
//        String requestContent = objectMapper.writeValueAsString(newUser);
//        when(accountService.saveUser(newUser)).thenReturn(newUser);
//        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post("/users")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(requestContent))
//                .andExpect(status().isOk())
//                .andReturn();
//    }
//}