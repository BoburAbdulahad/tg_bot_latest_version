package uz.nammqi.tg_bot_latest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.nammqi.tg_bot_latest.entity.Application;

@Repository
public interface AppRepository extends JpaRepository<Application,Long> {


    @Query(value = "insert into application(chat_id, username) values (chat_id, username)", nativeQuery = true)
    void saveApp(Application application);



}
