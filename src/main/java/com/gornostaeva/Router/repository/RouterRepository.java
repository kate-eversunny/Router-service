package com.gornostaeva.Router.repository;

import java.util.List;

public interface RouterRepository {

    int getSize();

    List<Integer> getRoute(int index);
}
