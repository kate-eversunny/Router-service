package com.gornostaeva.Router.service;

import com.gornostaeva.Router.entity.ResponseEntity;

public interface RouterService {
    ResponseEntity hasDirectRoute(int from, int to);
}
