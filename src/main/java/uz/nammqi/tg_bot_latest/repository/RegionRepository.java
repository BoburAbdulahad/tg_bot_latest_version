package uz.nammqi.tg_bot_latest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.nammqi.tg_bot_latest.entity.Application;
import uz.nammqi.tg_bot_latest.entity.Regions;

@Repository
public interface RegionRepository extends JpaRepository<Regions,Integer> {





}
