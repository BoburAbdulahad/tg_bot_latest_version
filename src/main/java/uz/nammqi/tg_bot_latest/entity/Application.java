package uz.nammqi.tg_bot_latest.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "application")

public class Application {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private Long chatId;

    @Column(nullable = true)
    private String fullName;

    @Column(nullable = true)
    private String username;

    @Column(nullable = true)
    private String murojaatTuri;

    @Column(nullable = true)
    private String hudud;

    @Column(nullable = true)
    private String telNomer;

    @Column(nullable = true)
    private String jins;

    @Column(nullable = true)
    private int yil;


    @Column(nullable = true)
    private String oy;

    @Column(nullable = true)
    private int kun;

    @Column(nullable = true)
    private String maqom;

    @Column(nullable = true)
    private String qabul;

    @Column(nullable = true)
    private String murojaatMatni;


    public Application(Long chatId) {
        this.chatId = chatId;

    }

}
