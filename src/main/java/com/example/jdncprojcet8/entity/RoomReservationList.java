package com.example.jdncprojcet8.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.mapping.ToOne;

@Entity
@Getter
@Setter
public class RoomReservationList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // 이건 무조건 들어가야 하는 친구

    private String name;

    private String roomName;
    // 어느방에 몇시가 예약 되어있는지 알면 되는거니까 이름만 가져오고 연관관계 X
    // 하면 복잡해지니까

    private String contents;

    @OneToOne
    @JoinColumn(name = "room_use_time_id")
    private RoomUseTime room_use_time;

    public void gain(String name, String roomName, RoomUseTime useTime) {
        this.name = name;
        this.roomName = roomName;
        this.room_use_time = useTime;
    }

    public void abc(RoomUseTime roomUseTime, String name, String roomName) {
        this.name = name;
        this.roomName = roomName;
        this.room_use_time = roomUseTime;
        this.contents ="예약 취소";
    }
}
