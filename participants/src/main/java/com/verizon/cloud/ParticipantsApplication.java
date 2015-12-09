package com.verizon.cloud;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class ParticipantsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ParticipantsApplication.class, args);
    }
    
    private static List<Participant> participants = new ArrayList<Participant>();
    
    
 
	@Override
	public void run(String... arg0) throws Exception {
		participants.add(new Participant("Reddy", "Mahesh", "TS", "S", Arrays.asList("123", "456")));
		participants.add(new Participant("Sai", "Ram", "KA", "S", Arrays.asList("456")));		
	}
	
	@RequestMapping("/")
	public List<Participant> getParticipants() {
		return participants;
	}
	
	@RequestMapping("/races/{id}")
	public List<Participant> getParticipants(@PathVariable String id) {
		List<Participant> list = new ArrayList<Participant>();
		for (Participant participant : participants) {
			if (participant.getRaces().contains(id)) {
				list.add(participant);
				return list;
			}
		}
		return participants;
	}
}
