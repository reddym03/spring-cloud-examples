/**
 * 
 */
package com.verizon.cloud.races.clientapps;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.verizon.cloud.Participant;

/**
 * @author Mahesh
 *
 */
@FeignClient("participants")
public interface ParticipantClient {
	@RequestMapping(method = RequestMethod.GET, value="/races/{raceId}")
	List<Participant> getParticipants(@PathVariable("raceId") String raceId);
}
