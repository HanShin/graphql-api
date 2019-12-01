create table conference_room
(
	id bigint auto_increment
		primary key,
	name varchar(32) null,
	size enum('FOUR', 'SIX', 'EIGHT') null
);

create table user
(
	id bigint auto_increment
		primary key,
	name varchar(32) null,
	team varchar(64) null
);

create table reservation
(
	id bigint auto_increment
		primary key,
	user_id bigint null,
	conference_room_id bigint null,
	start_dt datetime null,
	end_dt datetime null,
	constraint reservation_conference_room_ID_fk
		foreign key (conference_room_id) references conference_room (id),
	constraint reservation_user_id_fk
		foreign key (user_id) references user (id)
);

