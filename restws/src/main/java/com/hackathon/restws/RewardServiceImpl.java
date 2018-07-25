package com.hackathon.restws;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.hackathon.restws.exceptions.RewardBusinessException;
import com.hackathon.restws.model.Reward;

@Service
public class RewardServiceImpl implements RewardService {

	Map<Long, Reward> Rewards = new HashMap<>();
	long currentId = 123;

	public RewardServiceImpl() {
		init();
	}

	void init() {
		Reward Reward = new Reward();
		Reward.setId(currentId);
		Reward.setName("John");
		Reward.setReminder("Track the time");
		Rewards.put(Reward.getId(), Reward);
	}

	@Override
	public List<Reward> getRewards() {
		Collection<Reward> results = Rewards.values();
		List<Reward> response = new ArrayList<>(results);
		return response;
	}

	@Override
	public Reward getReward(Long id) {
		if (Rewards.get(id) == null) {
			throw new NotFoundException();
		}
		return Rewards.get(id);
	}

	@Override
	public Response createReward(Reward Reward) {
		Reward.setId(++currentId);
		Rewards.put(Reward.getId(), Reward);
		return Response.ok(Reward).build();
	}

	@Override
	public Response updateReward(Reward Reward) {

		Reward currentReward = Rewards.get(Reward.getId());

		Response response;
		if (currentReward != null) {
			Rewards.put(Reward.getId(), Reward);
			response = Response.ok().build();
		} else {
			throw new RewardBusinessException();
		}
		return response;
	}

	@Override
	public Response deleteReward(Long id) {
		Reward Reward = Rewards.get(id);

		Response response;

		if (Reward != null) {
			Rewards.remove(id);
			response = Response.ok().build();
		} else {
			response = Response.notModified().build();
		}
		return response;
	}

}
