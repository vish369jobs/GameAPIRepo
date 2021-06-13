package com.msdassign.service;

import com.msdassign.domain.PointsEntity;
import com.msdassign.domain.PointsTableRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameAPIService {

    @Autowired
    private PointsTableRepo pointsTable;

    public List<PointsEntity> listPoints() {
        List<PointsEntity> pointsList = new ArrayList<>();
        pointsTable.findAll().forEach(pt -> pointsList.add((PointsEntity)pt));
        return pointsList;
    }

    public void addPointEntity(PointsEntity ptEnt) {
        pointsTable.save(ptEnt);
    }

    public PointsEntity getEntitiyById(String id) {
        return pointsTable.getById(id);
    }
}
