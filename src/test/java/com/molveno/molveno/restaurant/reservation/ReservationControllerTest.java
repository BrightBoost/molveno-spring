package com.molveno.molveno.restaurant.reservation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.molveno.molveno.restaurant.guest.Guest;
import com.molveno.molveno.restaurant.guest.GuestRepository;
import com.molveno.molveno.restaurant.table.TableRepository;
import com.molveno.molveno.restaurant.table.Tablee;
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
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ReservationControllerTest {

    @InjectMocks
    private ReservationController reservationController;
    @Mock
    private  ReservationRepository reservationRepository;
    @Mock
    private GuestRepository guestRepository;
    @Mock
    private TableRepository tableRepository;



    private MockMvc mockMvc;
    @Before
    public  void setup(){
        this.mockMvc= MockMvcBuilders.standaloneSetup(reservationController).build();
    }
    @Test
    public void reservationControllerTest() throws Exception {
        Reservation res1 = new Reservation();
        Guest gus1 = new Guest();
        gus1.setId(1);
       // gus1.setName("Nina");
        gus1.setMobileNumber("0687443322");
        res1.setGuest(gus1);
        //LocalDateTime l1 = LocalDateTime.of(2019,3,13,14,3);
        //res1.setReservationTime(l1);
        res1.setNumberOfpoeple(4);
res1.setId(1);
        List<Tablee> tablees = new ArrayList<>();

        Tablee tablee = new Tablee();
        tablee.setNameoftable("table1");
        tablee.setNumberofchairs(4);
        tablee.setId(1);
        tablees.add(tablee);
        res1.setTablees(tablees);


        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(res1);
                //mapper.writeValueAsString(res1);



       when(reservationRepository.save(Mockito.any(Reservation.class))).thenReturn(res1);
       // mock save(from reservation respository ) behavior
       // when(tableRepository.save(Mockito.any(Tablee.class))).thenReturn(tablee);
        //when(guestRepository.save(Mockito.any(Guest.class))).thenReturn(gus1);

        this.mockMvc.perform(post("/save-reservation")
                .contentType(MediaType.APPLICATION_JSON)

                .content(json))
                .andDo(print())
             .andExpect(jsonPath("$.id",is((int)res1.getId())))
               .andExpect(jsonPath("$.guest.id",is((int)res1.getGuest().getId()))).

              andExpect(jsonPath("$.numberOfpoeple",is(res1.getNumberOfpoeple())))

              .andExpect(jsonPath("$.reservationTime",is(res1.getReservationTime())))
                .andExpect(status().isOk());






    }
    @Test
    public void reservationControllerTest1() throws Exception {
        Reservation res1 = new Reservation();
        Guest gus1 = new Guest();
        gus1.setId(1);
      //  gus1.setName("Nina");
        gus1.setMobileNumber("0687443322");
        res1.setGuest(gus1);
        //LocalDateTime l1 = LocalDateTime.of(2019,3,13,14,3);
        //res1.setReservationTime(l1);
        res1.setNumberOfpoeple(4);
        res1.setId(1);
        List<Tablee> tablees = new ArrayList<>();

        Tablee tablee = new Tablee();
        tablee.setNameoftable("table1");
        tablee.setNumberofchairs(4);
        tablee.setId(1);
        tablees.add(tablee);
        res1.setTablees(tablees);


        ObjectMapper mapper = new ObjectMapper();

        String json ="{\"id\":1,\"reservationTime\":null,\"tablees\":[{\"id\":1,\"numberofchairs\":4,\"nameoftable\":\"table1\"}],\"guest\":{\"id\":1,\"name\":\"abgahsssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssem\",\"mobileNumber\":\"0687443322\",\"email\":null},\"numberOfpoeple\":4}\n" +
                "   ";

        //mapper.writeValueAsString(res1);



        when(reservationRepository.save(Mockito.any(Reservation.class))).thenReturn(res1);
        // mock save(from reservation respository ) behavior


        this.mockMvc.perform(post("/save-reservation")
                .contentType(MediaType.APPLICATION_JSON)

                .content(json))
                .andDo(print())
            //    .andExpect(jsonPath("$.id",is((int)res1.getId())))
              //  .andExpect(jsonPath("$.guest.id",is((int)res1.getGuest().getId()))).

                //andExpect(jsonPath("$.numberOfpoeple",is(res1.getNumberOfpoeple())))

                //.andExpect(jsonPath("$.reservationTime",is(res1.getReservationTime())))
                .andExpect(status().isOk());






    }




}
