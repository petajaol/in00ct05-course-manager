package com.in00ct05.coursemanager.service;

import java.util.List;

interface ServiceInterface<T> {

  List<T> getItems();
  T getById(int id);
  T add(T item);
  void updateIdCounter();

}
