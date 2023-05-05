package ua.com.faculty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.faculty.entity.Rate;
import ua.com.faculty.repository.RateRepository;

import java.util.List;

@Service
public class RateManagerService {
    private final RateRepository rateRepository;

    @Autowired
    public RateManagerService(RateRepository rateRepository) {
        this.rateRepository = rateRepository;
    }


    public List<Rate> findListOrderByStatus(int grate){
        return rateRepository.findByGrate(grate);
    }

    public List<Rate> findAllOrder(){
        return rateRepository.findAll();
    }
}
