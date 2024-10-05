package com.pinsoft.burakTask.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class MinesweeperResponse {
  private String[] hints;

}

