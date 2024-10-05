package com.pinsoft.burakTask.controller;

import com.pinsoft.burakTask.model.MinesweeperRequest;
import com.pinsoft.burakTask.model.MinesweeperResponse;
import com.pinsoft.burakTask.service.MinesweeperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for mnswper.
 *
 * @author Burak
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class MinesweeperController {

  @Autowired
  private MinesweeperService minesweeperService;

  @PostMapping("/show-hints")
  public ResponseEntity<MinesweeperResponse> showHints(@RequestBody MinesweeperRequest request) {
    log.info("Received a request to generate hints for the Minesweeper game.");
    final String[] hints = minesweeperService.generateHints(request);
    return ResponseEntity.ok(MinesweeperResponse.builder().hints(hints).build());
  }
}

