// 이번주의 예약상태
{
    getThisWeekReservations{
        user {
            id,
            name,
            team
        },
        conferenceRoom {
            id,
            name,
            size
        },
        start_dt,
        end_dt
    }
}

// 해당 시간에 비어있는 회의식 목록
{
    getEmptyConferenceRooms(start_dt :"2019-12-03T12:00:00"){
    
        id,
        name,
        size
        
    }
}

// 회의실 예약하기
mutation {
    reservation(
        User : 1,
        ConferenceRoom : 1,
        start_dt :"2019-12-03T12:00:00",
        end_dt : "2019-12-03T12:30:00"){
        user {
            id,
            name,
            team
        },
        conferenceRoom {
            id,
            name,
            size
        },
        start_dt,
        end_dt
    }
}

// 전체 유저리스트
{
    users{
        id,
        name,
        team
    }
}

// 전체 예약리스트
{
    reservations{
        user {
            id,
            name,
            team
        },
        conferenceRoom {
            id,
            name,
            size
        },
        start_dt,
        end_dt
    }
}

// 전체회의실 리스트

{
    conferenceRooms {
        id,
        name,
        size
    }
}

캐쉬는 레디스를 사용하였습니다.
데이터는 제가 임의로 한시간마다 배치로 레디스에 저장하도록 처리하였습니다.
