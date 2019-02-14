package com.molveno.molveno.restaurant.reservation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.molveno.molveno.restaurant.guest.Guest;
import com.molveno.molveno.restaurant.guest.GuestController;
import com.molveno.molveno.restaurant.guest.GuestRepository;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GestControllerTest {



    @InjectMocks
    private GuestController guestController;
    @Mock
    private GuestRepository guestRepository;


    private MockMvc mockMvc;


    @Before
    public  void setup(){
        this.mockMvc= MockMvcBuilders.standaloneSetup(guestController).build();
    }



    @Test
    public  void GeustControllerTest() throws Exception {
     Guest guest1 = new Guest();
       guest1.setId(10);
     guest1.setMobileNumber("0932969327");
        guest1.setEmail("Sam01715@hotmail.com");
        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(guest1);







       when(guestRepository.save(Mockito.any(Guest.class))).thenReturn(guest1);

        this.mockMvc.perform(post("/save-guest")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andDo(print())
                .andExpect(jsonPath("$.id",is((int)guest1.getId()))).
               // .andExpect(jsonPath("$.name",is(guest1.getName()))).
                andExpect(jsonPath("$.mobileNumber",is(guest1.getMobileNumber())))
                .andExpect(jsonPath("$.email",is(guest1.getEmail())))
                .andExpect(status().isOk());









    }
    @Test
    public  void GeustControllerTestFaild() throws Exception {
        Guest guest1 = new Guest();
        guest1.setId(10);
        guest1.setMobileNumber("0932969327");
        guest1.setEmail("Sam01715@hotmail.com");

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(guest1);

        Guest guest2 = new Guest();
        guest2.setId(2);
        guest2.setMobileNumber("093296932744");
        guest2.setEmail("Sam0123715@hotmail.com");

        ObjectMapper mapper1 = new ObjectMapper();

        String json1 = mapper.writeValueAsString(guest2);





        when(guestRepository.save(Mockito.any(Guest.class))).thenThrow(new Exception("Test"));

        this.mockMvc.perform(post("/save-guest")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json1))
                .andDo(print())
                .andExpect(jsonPath("$.id",is((int)guest2.getId()))).
               // .andExpect(jsonPath("$.name",is(guest2.getName()))).
                andExpect(jsonPath("$.mobileNumber",is(guest2.getMobileNumber())))
                .andExpect(jsonPath("$.email",is(guest2.getEmail())))
                .andExpect(status().isOk());









    }


}
