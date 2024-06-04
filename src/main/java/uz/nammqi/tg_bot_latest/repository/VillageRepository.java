package uz.nammqi.tg_bot_latest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.nammqi.tg_bot_latest.entity.Regions;
import uz.nammqi.tg_bot_latest.entity.Villages;

@Repository
public interface VillageRepository extends JpaRepository<Villages,Integer> {





}
