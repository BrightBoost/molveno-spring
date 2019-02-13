//package com.molveno.molveno.hotel.Guest;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.Before;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.MethodSorters;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultMatcher;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.ArrayList;
//
//import static net.bytebuddy.matcher.ElementMatchers.is;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//
//@RunWith(MockitoJUnitRunner.class)
//@SpringBootTest
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class GuestControllerTest {
//
//    @InjectMocks
//    private GuestController guestController;
//
//    @Mock
//    private GuestRepository guestRepository;
//
//    private MockMvc mockMvc;
//
//    @Before
//    public void setup(){
//        this.mockMvc = MockMvcBuilders.standaloneSetup(guestController).build();
//    }
//
//    @Test
//    public void findByIdTest() throws Exception {
//        {
//            Guest newGuest = new Guest();
//            ObjectMapper mapper = new ObjectMapper();
//            String json = mapper.writeValueAsString(newGuest);
//
//            ArrayList<Guest> guestList = new ArrayList<>();
//            guestList.add(newGuest);
//            when(guestRepository.save(Mockito.any(Guest.class))).thenReturn(newGuest);
//
//            this.mockMvc.perform(get("/get-guest" )
//                    .contentType(MediaType.APPLICATION_JSON)
//                    .content(json))
//                    .andDo(print())
//                    .andExpect((ResultMatcher) jsonPath( "$.[0].id", is("kamil")));
//        }
//    }
//}