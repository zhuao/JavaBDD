package io.pivotal.microservices.repository;

import io.pivotal.microservices.domain.History;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface HistoryRepository extends Repository<History, Long> {
    public void save(History history);

    public List<History> findAll();
}
