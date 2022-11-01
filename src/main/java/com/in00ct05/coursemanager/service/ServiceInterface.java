package com.in00ct05.coursemanager.service;

import java.util.List;

interface ServiceInterface<T> {

  List<T> getItems();
  T getById(String id);
  T add(T item);

}
