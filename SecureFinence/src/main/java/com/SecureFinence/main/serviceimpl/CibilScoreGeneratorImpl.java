package com.SecureFinence.main.serviceimpl;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SecureFinence.main.model.CibilScore;
import com.SecureFinence.main.repository.CibilScoreRepository;
import com.SecureFinence.main.service.CibilScoreGenerator;
@Service
public class CibilScoreGeneratorImpl implements CibilScoreGenerator{
	@Autowired
	CibilScoreRepository cibilScoreRepository;
	
	@Override
	public Integer cibilScoreGenerator(int min, int max) {

		Random random = new Random();
		return random.nextInt(max - min) + min;

	}

	@Override
	public Optional<CibilScore> getSingleCibilObject(int cibilId) {

		Optional<CibilScore> singleCibilObject = cibilScoreRepository.findById(cibilId);
		return singleCibilObject;
	}

}
