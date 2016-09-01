package me.zhuao.bdd.repository;

import me.zhuao.bdd.domain.History;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface HistoryRepository extends Repository<History, Long> {
    public void save(History history);

    public List<History> findAll();
}
