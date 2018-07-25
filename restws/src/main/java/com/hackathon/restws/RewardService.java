package com.hackathon.restws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.hackathon.restws.model.Reward;

@Consumes("application/xml,application/json")
@Produces("application/xml,application/json")
@Path("/Rewardservice")
public interface RewardService {

	@Path("/Rewards")
	@GET
	List<Reward> getRewards();

	@Path("/Rewards/{id}")
	@GET
	Reward getReward(@PathParam("id") Long id);

	@Path("/Rewards")
	@POST
	Response createReward(Reward Reward);

	@Path("/Rewards")
	@PUT
	Response updateReward(Reward Reward);

	@Path("/Rewards/{id}")
	@DELETE
	Response deleteReward(@PathParam("id") Long id);

}
