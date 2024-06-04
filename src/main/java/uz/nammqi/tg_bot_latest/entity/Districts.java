package uz.nammqi.tg_bot_latest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Districts {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = true)
    private Long regionId;

    @Column(nullable = true)
    private String name_uz;

    @Column(nullable = true)
    private String name_oz;

    @Column(nullable = true)
    private String name_ru;


}
