package com.verizon.cloud.races;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verizon.cloud.Participant;
import com.verizon.cloud.races.clientapps.ParticipantClient;

@SpringBootApplication
@RestController
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.verizon.cloud.races.clientapps"})
public class RacerApplication implements CommandLineRunner {
	private static List<Race> races = new ArrayList<Race>();
	
	@Autowired
	private ParticipantClient participantClient;
	
	public static void main(String[] args) {
		SpringApplication.run(RacerApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		races.add(new Race("Mahesh", "123", "TS", "Hyderabad"));
		races.add(new Race("Sai", "456", "KA", "Bangalore"));
	}
	@RequestMapping("/")
	public List<Race> getRaces() {
		return races;
	}
	
	@RequestMapping("/participants")
	public List<RaceWithParticipants> getRacesWithParticipants() {
		List<RaceWithParticipants> returnRaces = new ArrayList<RaceWithParticipants>();
		for(Race r : races) {
			returnRaces.add(new RaceWithParticipants(r, participantClient.getParticipants(r.getId())));
		}
		return returnRaces;
	}
}
