package com.SecureFinence.main.service;

import java.util.Optional;

import com.SecureFinence.main.model.CibilScore;

public interface CibilScoreGenerator {
	public abstract Integer cibilScoreGenerator(int min, int max);

	public abstract Optional<CibilScore> getSingleCibilObject(int cibilId);

}
