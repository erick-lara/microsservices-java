package com.example.hrpayroll.hrpayroll.services;

import com.example.hrpayroll.hrpayroll.entities.Payment;
import com.example.hrpayroll.hrpayroll.entities.Worker;
import com.example.hrpayroll.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(long workerId, int days){
        Worker worker = workerFeignClient.findById(workerId).getBody();
        if(worker != null) {
            return new Payment(worker.getName(), worker.getDailyIncome(), days);
        }
        return null;
    }
}
