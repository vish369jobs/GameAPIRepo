package com.msdassign.rest;

import com.msdassign.domain.PointsEntity;
import com.msdassign.dto.TransferPointsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.msdassign.service.GameAPIService;

import java.util.List;

@RestController
public class GameAPIController {

    @Autowired
    private GameAPIService gameService;

    @RequestMapping("/test")
    public String showTestMsg() {
        return"Hi Test!";
    }

    @RequestMapping("/scoreboard")
    public List<PointsEntity> getAllPoints() {
        return gameService.listPoints();
    }

    @PostMapping("/addPts")
    public void addPoints(@RequestBody PointsEntity pt) {
        gameService.addPointEntity(pt);
    }

    @PutMapping("/transferPts")
    public void transferPoints(@RequestBody TransferPointsDTO transferPtsDto) {
        PointsEntity winnerEnt = gameService.getEntitiyById(transferPtsDto.getWinnerUserId());
        winnerEnt.setPoints(winnerEnt.getPoints() + transferPtsDto.getPoints2Transfer());
        gameService.addPointEntity(winnerEnt);

        PointsEntity looserEnt = gameService.getEntitiyById(transferPtsDto.getLooserUserId());
        looserEnt.setPoints(looserEnt.getPoints() - transferPtsDto.getPoints2Transfer());
        gameService.addPointEntity(looserEnt);
    }

}
