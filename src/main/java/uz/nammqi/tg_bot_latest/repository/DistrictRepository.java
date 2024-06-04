package uz.nammqi.tg_bot_latest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.nammqi.tg_bot_latest.entity.Districts;
import uz.nammqi.tg_bot_latest.entity.Regions;

@Repository
public interface DistrictRepository extends JpaRepository<Districts,Integer> {





}
