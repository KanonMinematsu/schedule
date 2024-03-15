package jp.ac.ohara.schedule.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.ac.ohara.schedule.model.Private;


@Repository
public interface PrivateRepository extends JpaRepository<Private, Long> {
  public List<Private>findAllBynumberEquals(String number);
}