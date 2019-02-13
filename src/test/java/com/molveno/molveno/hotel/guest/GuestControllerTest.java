package com.molveno.molveno.hotel.guest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.molveno.molveno.hotel.guest.Guest;
import com.molveno.molveno.hotel.guest.GuestController;
import com.molveno.molveno.hotel.guest.GuestRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
public class GuestControllerTest {
	
	@InjectMocks
	private GuestController subject;
	@Mock
    private GuestRepository guestRepository;
	
	private MockMvc mockMvc;

	@Before public void init() {
		Guest guest = new Guest();
		when(guestRepository.save(any())).thenReturn(guest );
		this.mockMvc = MockMvcBuilders.standaloneSetup(subject).build();
	}
	
	@Test public void happyFlow() throws Exception {
		Guest guest = new Guest();
		guest.setCity("test");
		guest.setFirstName("test");
		
		String json = new ObjectMapper().writeValueAsString(guest);
		
		mockMvc.perform(post("/add-guest")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json))
		.andDo(print())
		.andExpect(status().isOk());
	}
}
