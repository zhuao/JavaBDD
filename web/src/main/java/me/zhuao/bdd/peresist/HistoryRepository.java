package me.zhuao.bdd.peresist;

import org.springframework.data.repository.Repository;

import java.util.List;

public interface HistoryRepository extends Repository<History, Long> {
    public void save(String expression, int result);

    public List<History> findAll();
}
