package com.mosq.services;


import com.mosq.entities.Status;
import com.mosq.repositories.StatusRepo;

import java.util.List;

public class StatusService {
    private StatusRepo statusRepo=new StatusRepo();

    public List<Status> readAll(){
        return statusRepo.readAll();
    }

    public Status findStatusById(Long id){
        return statusRepo.read(id);
    }

    public Status createStatus(Status status){
        return statusRepo.create(status);
    }
}
