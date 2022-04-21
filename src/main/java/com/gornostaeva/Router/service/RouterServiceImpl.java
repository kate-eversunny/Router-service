package com.gornostaeva.Router.service;

import com.gornostaeva.Router.entity.ResponseEntity;
import com.gornostaeva.Router.repository.RouterRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class RouterServiceImpl implements RouterService {

    @Autowired
    private RouterRepository repository;

    public ResponseEntity hasDirectRoute(int from, int to) {
        List<CompletableFuture<Boolean>> futures = new LinkedList<>();
        int i = 0;
        int size = repository.getSize();
        while (i < size) {
            int route = i;
            CompletableFuture<Boolean> future = CompletableFuture.supplyAsync(() -> {
                List<Integer> stops = repository.getRoute(route);
                int fromIndex = stops.indexOf(from);
                int toIndex = stops.indexOf(to);
                return fromIndex >= 0 && fromIndex < toIndex;
            });
            futures.add(future);
            i++;
        }
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(
                futures.toArray(new CompletableFuture[futures.size()])
        );

        CompletableFuture<List<Boolean>> joinedFutures = allFutures.thenApply(v -> futures.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList()));

        CompletableFuture<Boolean> result = joinedFutures.thenApply(future ->
                future.stream()
                        .anyMatch(calculationResult -> calculationResult.equals(true)));

        Boolean finalResult = false;

        // TODO: proper error handling
        try {
            finalResult = result.get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(from, to, finalResult);
    }
}
