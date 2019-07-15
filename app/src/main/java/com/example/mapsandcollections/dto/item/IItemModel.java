package com.example.mapsandcollections.dto.item;

import java.util.List;

public interface IItemModel {

      String MAP = "Maps";
      String COLLECTION = "Collections";

   List<ItemResult> getItems();

   int getCountSpan();

}
